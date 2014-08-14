package org.mu.opencomm.common.dbutil;

import java.util.Map;

import com.mongodb.DBObject;
import com.mongodb.util.JSON;

public class QueryAnalyzer {

	public DBObject buildQuery(String command, QueryParam params) {
		for (Map.Entry<String, Object> entry : params.getParams().entrySet()) {
			command = command.replace(entry.getKey(), entry.getValue().toString());
		}
		return (DBObject) JSON.parse(command);
	}
	
}
