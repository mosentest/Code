package org.mu.opencomm.common.dbutil;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class ObjectBuilder {

	private final Map<Class<?>, ClassMapper> entityMapper;
	
	public ObjectBuilder(Map<Class<?>, ClassMapper> entityMapper) {
		this.entityMapper = entityMapper;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <T> T buildEntity(Class<T> classType, DBObject dbObject) {
		if (dbObject == null) {
			return null;
		}
		T entity = null;
		try {
			entity = classType.newInstance();
			ClassMapper mapper = entityMapper.get(classType);
			Set<String> fields = dbObject.keySet();
			for (String field : fields) {
				Method method = mapper.getSetter(field);
				if (mapper.isId(field)) {
					method.invoke(entity, dbObject.get(field));
				} else if (mapper.isArrayType(field)) {
					BasicDBList list = (BasicDBList) dbObject.get(field);
					Object array = getArray(list, mapper.getArrayType(field));
					method.invoke(entity, array);
				} else if (mapper.isCollectionType(field)) {
					Class<?> type = mapper.getCollectionType(field);
					BasicDBList dbList = (BasicDBList) dbObject.get(field);
					if (DBUtil.isList(mapper.getComplexeType(field))) {
						List list = DBUtil.getList(type);
						for (Object object : dbList) {
							list.add(buildEntity(type, (DBObject) object));
						}
						method.invoke(entity, list);
					} else if (DBUtil.isSet(mapper.getComplexeType(field))) {
						Set set = DBUtil.getSet(type);
						for (Object object : dbList) {
							set.add(buildEntity(type, (DBObject) object));
						}
						method.invoke(entity, set);
					}
				} else if (mapper.isComplexType(field)) {
					method.invoke(entity, buildEntity(mapper.getComplexeType(field), (DBObject) dbObject.get(field)));
				} else {
					method.invoke(entity, dbObject.get(field));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return entity;
	}
	
	@SuppressWarnings("unchecked")
	private <T> T[] getArray(BasicDBList list, Class<T> classType) {
		return list.toArray((T[]) Array.newInstance(classType, list.size()));
	}
	
	@SuppressWarnings("rawtypes")
	public DBObject buildDBObject(Class<?> classType, Object object) {
		if (object == null) {
			return null;
		}
		DBObject dbObject = new BasicDBObject();
		ClassMapper mapper = entityMapper.get(classType);
		try {
			Map<Method, String> getters = mapper.getGetterMapper();
			for (Map.Entry<Method, String> entry : getters.entrySet()) {
				Object value = entry.getKey().invoke(object);
				if (mapper.isId(entry.getValue())) {
					dbObject.put(entry.getValue(), value);
				} else if (mapper.isArrayType(entry.getValue())) {	
					dbObject.put(entry.getValue(), value);
				} else if (mapper.isCollectionType(entry.getValue())) {
					Class<?> collectionType = mapper.getComplexeType(entry.getValue());
					Class<?> objectType = mapper.getCollectionType(entry.getValue());
					BasicDBList dbList = new BasicDBList();
					if (DBUtil.isSet(collectionType)) {
						if (value != null) {
							Set set = (Set) value;
							for (Object o : set) {
								dbList.add(buildDBObject(objectType ,o));
							}
						}
						dbObject.put(entry.getValue(), dbList);
					} else if (DBUtil.isList(collectionType)) {
						if (value != null) {
							List list = (List) value;
							for (Object o : list) {
								dbList.add(buildDBObject(objectType , o));
							}
						}
						dbObject.put(entry.getValue(), dbList);
					}
				} else if (mapper.isComplexType(entry.getValue())) {
					dbObject.put(entry.getValue(), buildDBObject(mapper.getComplexeType(entry.getValue()), value));
				} else {
					dbObject.put(entry.getValue(), value);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return dbObject;
	}
	
}
