package org.mu.opencomm.common.repository;

import java.io.Serializable;
import java.util.List;

import org.mu.opencomm.common.dbutil.QueryParam;

import com.mongodb.DBObject;

public interface DBRepository<T, PK extends Serializable> {
	
	public List<T> find(DBObject query, DBObject fields,  
			DBObject order, int offset, int limit);
	
	public List<T> find(String query, String fields, QueryParam params, 
			DBObject order, int offset, int limit);
	
	public List<T> find(String query, String fields, QueryParam params, 
			int offset, int limit);
	
	public List<T> find(String query, String fields, QueryParam params);
	
	public long count(String query, QueryParam params);
	
	public long count();

	public T findOne(DBObject query, DBObject fields);

	public T findOne(String query, String fields, QueryParam params);

	public T findOne(PK id);
	
	public boolean exists(PK id);
	
	public void save(T entity);
	
	public void updateOne(T entity);
	
	public void update(String command, QueryParam params);
	
	public void delete(String command, QueryParam params);
	
	public void delete(DBObject condition) ;
	
	public void deleteOne(PK id);
	
}
