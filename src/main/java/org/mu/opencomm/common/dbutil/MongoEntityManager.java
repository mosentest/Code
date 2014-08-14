package org.mu.opencomm.common.dbutil;

import java.io.File;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import org.mu.opencomm.common.annotation.DBCompoundIndex;
import org.mu.opencomm.common.annotation.DBDocument;
import org.mu.opencomm.common.annotation.DBEmbeddedDocument;
import org.mu.opencomm.common.annotation.DBQueries;
import org.mu.opencomm.common.annotation.DBQuery;
import org.mu.opencomm.common.annotation.DBQueryField;
import org.mu.opencomm.common.annotation.DBQueryFields;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class MongoEntityManager {
	
	private static final Logger logger = LoggerFactory.getLogger(MongoEntityManager.class);
	
	private static final String PACKAGE_SEPARATOR = ";";
	
	private final Map<Class<?>, ClassMapper> entityMapper;	
	
	private final Map<String, String> commandMapper;
	
	private final Map<Class<?>, String> collectionMapper;
	
	private final Map<String, DBObject> queryFieldMapper;
	
	private static final DBObject COMPLETE = new BasicDBObject();
	
	private ObjectBuilder objectBuilder;
	
	private QueryAnalyzer queryAnalyzer;
	
	public MongoEntityManager(String packages) {
		entityMapper = new HashMap<>();
		commandMapper = new HashMap<>();
		collectionMapper = new HashMap<>();
		queryFieldMapper = new HashMap<>();
		init(packages.split(PACKAGE_SEPARATOR));
		objectBuilder = new ObjectBuilder(entityMapper);
		queryAnalyzer = new QueryAnalyzer();
	}
	
	private void init(String[] packages) {
		MongoClient mongo = null;
		DB db = null;
		try {
			mongo = new MongoClient("localhost", 27017);
			db = mongo.getDB("opencomm");
		} catch (Exception e) {
			logger.debug("Unable to connect to database {}:{} -- {}",
					new Object[] { "localhost", 27017, "opencomm"});
		}
		for (String packageName : packages) {
			if (!packageName.trim().equals("")) {
				loadClass(packageName);
			}
		}
		for (Class<?> classType : entityMapper.keySet()) {
			if (classType.getAnnotation(DBDocument.class) != null) {
				String collectionName = classType.getAnnotation(DBDocument.class).collection();
				if (!db.collectionExists(collectionName)) {
					db.createCollection(collectionName, 
							new BasicDBObject("autoIndexId", classType.getAnnotation(DBDocument.class).autoIndexId()));
				}
				collectionMapper.put(classType, collectionName);
				DBCollection collection = db.getCollection(collectionName);
				collection.dropIndexes();
				if (classType.getAnnotation(DBDocument.class).compoundIndexes().length > 0) {
					for (DBCompoundIndex index : classType.getAnnotation(DBDocument.class).compoundIndexes()) {
						try {
							createCompoundIndex(collection, index);
						} catch (Exception e) {
							logger.debug("Could not create compound index.");
						}
					}
				}
				if (classType.isAnnotationPresent(DBQueries.class)) {
					createQuery(classType);
				}
				if (classType.isAnnotationPresent(DBQueryFields.class)) {
					createQueryField(classType);
				}
				entityMapper.put(classType, new ClassMapper(classType, collection));
			} else {
				entityMapper.put(classType, new ClassMapper(classType));
			}
		}
		mongo.close();
	}
	
	private void createQueryField(Class<?> classType) {
		DBQueryField[] queryFields = classType.getAnnotation(DBQueryFields.class).value();
		String prefix = classType.getSimpleName() + ".";
		for (DBQueryField queryField : queryFields) {
			if (queryFieldMapper.containsKey(prefix + queryField.name())) {
				logger.debug("query fields '{}' already exist, it will not be mapped.", 
						new Object[] { prefix + queryField.name() });
				continue;
			}
			queryFieldMapper.put(prefix + queryField.name(), (DBObject) JSON.parse(queryField.fields()));
		}
	}
	
	private void createQuery(Class<?> classType) {
		DBQuery[] queries = classType.getAnnotation(DBQueries.class).value();
		String prefix = classType.getSimpleName() + ".";
		for (DBQuery query : queries) {
			if (commandMapper.containsKey(prefix + query.name())) {
				logger.debug("query '{}' already exist, it will not be mapped.", 
						new Object[] { prefix + query.name() });
				continue;
			}
			commandMapper.put(prefix + query.name(), query.query());
		}
	}
	
	private void createCompoundIndex(DBCollection collection, DBCompoundIndex index) throws Exception {
		String[] indexArr = index.def().
				replace('{', ' ').replace('}', ' ').
				trim().split(",");
		BasicDBObject options = new BasicDBObject();
		for (String str : indexArr) {
			options.put(str.split(":")[0].trim(), Integer.parseInt(str.split(":")[1].trim()));
		}
		logger.debug("Creating compound index for collection '{}' with options {}", 
				new Object[] { collection.getName(), options });
	}
	
	private void loadClass(String packageName) {
		try {
			Enumeration<URL> dir = Thread.currentThread().getContextClassLoader().
					getResources(packageName.replace('.', '/'));
			while(dir.hasMoreElements()){
				URL url = dir.nextElement();
				File file = new File(url.getFile());
				String[] classes = file.list();
				for(String simpleName : classes){
					simpleName = simpleName.substring(0, simpleName.length() - 6);
					String className = packageName + "." + simpleName;
					Class<?> classType = Class.forName(className);
					if (classType.getAnnotation(DBDocument.class) != null || 
							classType.getAnnotation(DBEmbeddedDocument.class) != null) {
						entityMapper.put(classType, null);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public DBObject buildQuery(Class<?> classType, String command, QueryParam params) {
		if (command == null) {
			return new BasicDBObject();
		}
		return queryAnalyzer.buildQuery(commandMapper.get(classType.getSimpleName() + "." + command)
				, params);
	}
	
	public <T> T buildEntity(Class<T> classType, DBObject dbObject) {
		return objectBuilder.buildEntity(classType, dbObject);
	}
	
	public <T> DBObject buildDBObject(Class<T> classType, T object) {
		return objectBuilder.buildDBObject(classType, object);
	}
	
	public <T> DBObject getQueryField(Class<T> classType, String name) {
		if (name == null || "".equals(name)) {
			return COMPLETE;
		}
		return queryFieldMapper.get(classType.getSimpleName() + "." + name);
	}
	
	public String getCollection(Class<?> classType) {
		return collectionMapper.get(classType);
	}
	
}
