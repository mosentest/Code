package org.mu.opencomm.common.dbutil;

import java.util.HashMap;
import java.util.Map;

public class QueryParam {

	private Map<String, Object> params;
	
	public QueryParam() {
		params = new HashMap<String, Object>();
	}
	
	public QueryParam(String key, Object value) {
		this();
		params.put(key, value);
	}
	
	public QueryParam put(String key, Object value) {
		params.put(key, value);
		return this;
	}
	
	public Map<String, Object> getParams() {
		return params;
	}
	
}
