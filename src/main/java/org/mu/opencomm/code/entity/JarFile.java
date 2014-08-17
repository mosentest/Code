package org.mu.opencomm.code.entity;

import java.util.List;

import org.bson.types.ObjectId;
import org.mu.opencomm.common.annotation.DBDocument;
import org.mu.opencomm.common.annotation.DBField;
import org.mu.opencomm.common.annotation.DBId;
import org.mu.opencomm.common.annotation.DBIndexed;
import org.mu.opencomm.common.entity.Identifiable;

@DBDocument(collection = "jar_file")
public class JarFile implements Identifiable {

	@DBId
	protected ObjectId id;

	@DBField
	private User uploader;
	
	@DBField
	@DBIndexed(unique = true)
	private String name;

	@DBField
	private String description;
	
	@DBField
	private String project;

	@DBField
	private String[] category;
	
	@DBField
	private String[] tags;
	
	@DBField
	private String version;

	@DBField
	private long downloads;

	@DBField
	private List<FileInfo> contents;
	
	public ObjectId getId() {
		return id;
	}

	public List<FileInfo> getContents() {
		return contents;
	}

	public void setContents(List<FileInfo> contents) {
		this.contents = contents;
	}

	public User getUploader() {
		return uploader;
	}

	public void setUploader(User uploader) {
		this.uploader = uploader;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public long getDownloads() {
		return downloads;
	}

	public void setDownloads(long nDownloads) {
		this.downloads = nDownloads;
	}

	public String[] getCategory() {
		return category;
	}

	public void setCategory(String[] category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
