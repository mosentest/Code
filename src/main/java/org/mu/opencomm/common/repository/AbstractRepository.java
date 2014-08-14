package org.mu.opencomm.common.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.mu.opencomm.common.dbutil.MongoEntityManager;
import org.mu.opencomm.common.dbutil.QueryParam;
import org.mu.opencomm.common.entity.Identifiable;
import org.springframework.beans.factory.annotation.Autowired;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public abstract class AbstractRepository<T extends Identifiable, PK extends Serializable> 
	implements DBRepository<T, PK> {

	protected DB db;
	
	protected Class<T> classType;
	
	protected DBCollection collection;
	
	@Autowired
	protected MongoEntityManager entityManager = new MongoEntityManager("org.mu.opencomm.code.entity");
	
	public AbstractRepository() {}

	@SuppressWarnings("unchecked")
	public AbstractRepository(String dbName) {
		this.classType = (Class<T>) ((ParameterizedType)getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		try {
			MongoClient mongo = new MongoClient("localhost", 27017);
			db = mongo.getDB(dbName);
			collection = db.getCollection(entityManager.getCollection(classType));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<T> find(DBObject query, DBObject fields, 
			DBObject order, int offset, int limit) {
		List<T> list = new ArrayList<>();
		DBCursor cursor = collection.find(query, fields);
		if (order != null) {
			cursor.sort(order);
		}
		if (offset != 0) {
			cursor.skip(offset);
		}
		if (limit != 0) {
			cursor = cursor.limit(limit);
		}
		while (cursor.hasNext()) {
			list.add(entityManager.buildEntity(classType, cursor.next()));
		}
		return list;
	}

	@Override
	public List<T> find(String command, String fields, QueryParam params, 
			DBObject order, int offset, int limit) {
		return find(
				entityManager.buildQuery(classType, command, params),
				entityManager.getQueryField(classType, fields),
				order, offset, limit);
	}

	@Override
	public List<T> find(String command, String fields, QueryParam params, 
			int offset, int limit) {
		return find(command, fields, params, null, offset, limit);
	}

	@Override
	public List<T> find(String command, String fields, QueryParam params) {
		return find(command, fields, params, null, 0, 0);
	}

	@Override
	public long count(String command, QueryParam params) {
		return collection.count(entityManager.buildQuery(classType, command, params));
	}

	@Override
	public long count() {
		return collection.count();
	}

	@Override
	public T findOne(DBObject query, DBObject fields) {
		return entityManager.buildEntity(classType, 
				collection.findOne(query ,fields));
	}

	@Override
	public T findOne(String command, String fields, QueryParam params) {
		return findOne(entityManager.buildQuery(classType, command, params), 
				entityManager.getQueryField(classType, fields));
	}

	@Override
	public T findOne(PK id) {
		return entityManager.buildEntity(classType, 
				collection.findOne(new BasicDBObject("_id", id)));
	}

	@Override
	public boolean exists(PK id) {
		return collection.findOne(new BasicDBObject("_id", id)) != null;
	}

	@Override
	public void update(String command, QueryParam params) {
		collection.update(entityManager.buildQuery(classType, command, params), new BasicDBObject());
	}

	@Override
	public void delete(String command, QueryParam params) {
		collection.remove(entityManager.buildQuery(classType, command, params));
	}
	
	public Long count(DBObject query) {
		return collection.count(query);
	}

	@Override
	public void save(T entity) {
		collection.save(entityManager.buildDBObject(classType, entity));
	}

	@Override
	public void updateOne(T entity) {
		collection.update(new BasicDBObject("_id", entity.getId()), 
				entityManager.buildDBObject(classType, entity));
	}

	@Override
	public void deleteOne(PK id) {
		collection.remove(new BasicDBObject("_id", id));
	}

	@Override
	public void delete(DBObject object) {
		collection.remove(object);
	}

	public void setMongoEntityManager(MongoEntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
}
