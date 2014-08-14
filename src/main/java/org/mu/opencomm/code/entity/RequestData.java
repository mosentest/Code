package org.mu.opencomm.code.entity;

import org.mu.opencomm.common.annotation.DBEmbeddedDocument;
import org.mu.opencomm.common.annotation.DBField;

@DBEmbeddedDocument
public class RequestData {

	@DBField
	private String method;

	@DBField
	private String resource;

	@DBField
	private String protocol;

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	
}
