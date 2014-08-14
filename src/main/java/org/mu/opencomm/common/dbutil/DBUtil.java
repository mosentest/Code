package org.mu.opencomm.common.dbutil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class DBUtil {
	
	public static boolean isCollection(Class<?> classType) {
		return Collection.class.isAssignableFrom(classType);
	}
	
	public static boolean isList(Class<?> classType) {
		return List.class.isAssignableFrom(classType);
	}
	
	public static boolean isSet(Class<?> classType) {
		return Set.class.isAssignableFrom(classType);
	}
	
	public static boolean isMap(Class<?> classType) {
		return Map.class.isAssignableFrom(classType);
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> getList(Class<T> classType) {
		if (classType.isInterface()) {
			return new ArrayList<T>();
		}
		try {
			List<T> list = (List<T>) classType.newInstance();
			return list;
		} catch (Exception e) {
			return new ArrayList<T>();
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> Set<T> getSet(Class<T> classType) {
		if (classType.isInterface()) {
			return new HashSet<T>();
		}
		try {
			Set<T> list = (Set<T>) classType.newInstance();
			return list;
		} catch (Exception e) {
			return new HashSet<T>();
		}
	}
	
}
