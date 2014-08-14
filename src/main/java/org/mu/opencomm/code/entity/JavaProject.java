package org.mu.opencomm.code.entity;

import org.bson.types.ObjectId;
import org.mu.opencomm.common.annotation.DBDocument;
import org.mu.opencomm.common.annotation.DBField;
import org.mu.opencomm.common.annotation.DBId;

@DBDocument(collection = "java_project")
public class JavaProject {

	@DBId
	private ObjectId id;

	@DBField
	private User uploader;
	
	@DBField
	private String[] files;

	@DBField
	private String name;

	@DBField
	private String type;

	@DBField
	private Long size;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public User getUploader() {
		return uploader;
	}

	public void setUploader(User uploader) {
		this.uploader = uploader;
	}

	public String[] getFiles() {
		return files;
	}

	public void setFiles(String[] files) {
		this.files = files;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}
	
}
