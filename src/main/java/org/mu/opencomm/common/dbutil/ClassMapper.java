package org.mu.opencomm.common.dbutil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.mu.opencomm.common.annotation.DBField;
import org.mu.opencomm.common.annotation.DBId;
import org.mu.opencomm.common.annotation.DBIndexed;
import org.mu.opencomm.common.annotation.DBReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.BasicDBObject;

public class ClassMapper {
	
	private static final Logger logger = LoggerFactory.getLogger(ClassMapper.class);
	
	private String idField;
	
	private Map<String, Method> setterMapper;
	
	private Map<String, Class<?>> complextMapper;
	
	private Map<String, Class<?>> collectionMapper;
	
	private Map<String, Class<?>> arrayMapper;
	
	private Map<Method, String> getterMapper;
	
	public ClassMapper(Class<?> classType) {
		this(classType, null);
	}
	
	public ClassMapper(Class<?> classType, com.mongodb.DBCollection collection) {
		setterMapper = new HashMap<>();
		getterMapper = new HashMap<>();
		complextMapper = new HashMap<>();
		arrayMapper = new HashMap<>();
		collectionMapper = new HashMap<>();
		init(classType, collection);
	}
	
	private void init(Class<?> classType, com.mongodb.DBCollection collection) {
		String upper = null;
		String getterName = null;
		String setterName = null;
		String fieldName = null;
		Field[] fields = classType.getDeclaredFields();
		for (Field field : fields) {
			if (hasValidAnnotation(field)) {
				try {
					Class<?> fieldType = field.getType();
					upper = field.getName().substring(0,1).toUpperCase();
					if (fieldType.equals(boolean.class) || fieldType.equals(Boolean.class)) {
						if (field.getName().toLowerCase().startsWith("is")) {
							getterName = field.getName();
							setterName = "set" + field.getName().substring(2);
						} else {
							getterName = "is" + upper + field.getName().substring(1);
							setterName = "set" + upper + field.getName().substring(1);
						}
					} else {
						getterName = "get" + upper + field.getName().substring(1);
						setterName = "set" + upper + field.getName().substring(1);
					}
					fieldName = getFieldName(field);
					setterMapper.put(fieldName, classType.getMethod(setterName, fieldType));
					getterMapper.put(classType.getMethod(getterName, new Class<?>[] {}), fieldName);
					if (field.getType().isArray()) {
						arrayMapper.put(fieldName, field.getClass().getComponentType());
					}
					if (DBUtil.isCollection(fieldType)) {
						collectionMapper.put(fieldName, fieldType.getComponentType());
					}
					if (isComplexType(fieldType)) {
						complextMapper.put(fieldName, fieldType);
					}
					if (collection != null && field.isAnnotationPresent(DBIndexed.class)) {
						BasicDBObject options = new BasicDBObject(fieldName, field.getAnnotation(DBIndexed.class).value());
						if (field.getAnnotation(DBIndexed.class).unique()) {
							options.put("unique", true);
						}
						collection.createIndex(options);
						logger.debug("Creating index for collection '{}' field '{}' with options {}", 
								new Object[] {collection.getName(), fieldName, options});
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		logger.debug("class {} loaded", new Object[] { classType.getName()});
	}
	
	private boolean isComplexType(Class<?> classType) {
		return !(classType.isPrimitive() || 
				classType.equals(String.class) ||
				classType.equals(Integer.class) ||
				classType.equals(java.util.Date.class) ||
				classType.equals(java.sql.Date.class) ||
				classType.equals(Long.class) ||
				classType.equals(Boolean.class) ||
				classType.equals(Double.class) ||
				classType.equals(Float.class) ||
				classType.equals(Short.class) ||
				classType.equals(Character.class) ||
				classType.equals(Byte.class));
	}
	
	private boolean hasValidAnnotation(Field field) {
		return field.isAnnotationPresent(DBField.class) || 
				field.isAnnotationPresent(DBId.class) ||
				field.isAnnotationPresent(DBReference.class);
	}
	
	private String getFieldName(Field field) {
		String fieldName = field.getName();
		if (field.isAnnotationPresent(DBId.class)) {
			idField = "_id";
			return "_id";
		} else if (field.isAnnotationPresent(DBField.class)) {
			return field.getAnnotation(DBField.class).value().equals("") ? fieldName :
				field.getAnnotation(DBField.class).value();
		} else if (field.isAnnotationPresent(DBReference.class)) {
			return field.getAnnotation(DBReference.class).reference().equals("") ? fieldName :
				field.getAnnotation(DBReference.class).reference();
		}
		return null;
	}
	
	public boolean isId(String field) {
		return idField != null && idField.equals(field);
	}
	
	public boolean isArrayType(String field) {
		return arrayMapper.containsKey(field);
	}
	
	public boolean isCollectionType(String field) {
		return collectionMapper.containsKey(field);
	}
	
	public boolean isComplexType(String field) {
		return complextMapper.containsKey(field);
	}
	
	public Class<?> getArrayType(String field) {
		return arrayMapper.get(field);
	}
	
	public Class<?> getCollectionType(String field) {
		return collectionMapper.get(field);
	}
	
	public Class<?> getComplexeType(String field) {
		return complextMapper.get(field);
	}
	
	public String getGetter(Method method) {
		return getterMapper.get(method);
	}
	
	public Method getSetter(String field) {
		return setterMapper.get(field);
	}

	public Map<Method, String> getGetterMapper() {
		return getterMapper;
	}

	public String getIdField() {
		return idField;
	}

	public void setIdField(String idField) {
		this.idField = idField;
	}
	
}