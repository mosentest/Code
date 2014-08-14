package org.mu.opencomm.code.entity;

import org.mu.opencomm.common.annotation.DBEmbeddedDocument;
import org.mu.opencomm.common.annotation.DBField;

@DBEmbeddedDocument
public class User {

	@DBField
	private String account;

	@DBField
	private Long id;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
