package org.mu.opencomm.code.entity;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.mu.opencomm.common.annotation.DBCompoundIndex;
import org.mu.opencomm.common.annotation.DBDocument;
import org.mu.opencomm.common.annotation.DBField;
import org.mu.opencomm.common.annotation.DBId;
import org.mu.opencomm.common.annotation.DBIndexed;
import org.mu.opencomm.common.annotation.DBQueries;
import org.mu.opencomm.common.annotation.DBQuery;
import org.mu.opencomm.common.annotation.DBQueryField;
import org.mu.opencomm.common.annotation.DBQueryFields;
import org.mu.opencomm.common.entity.Identifiable;

@DBDocument(collection = "java_file", compoundIndexes = {
		@DBCompoundIndex(def = "{name : 1, extension : -1}"),
		@DBCompoundIndex(def = "{lines : 1, size : -1}")
})
@DBQueries({
	@DBQuery(name = "test1", query = "{ size : { $gt : ${size} }}"),
	@DBQuery(name = "test2", query = "{ size : { $gt : 50 }, user.account : '123'}")
})
@DBQueryFields({
	@DBQueryField(name = "minimal", fields = "{name:1,extention:1,size:1,create:1,labels:1}"),
	@DBQueryField(name = "complete", fields = "{name:1,extention:1,size:-1,create:1,labels:1,content:1,path:1}")
})
public class JavaFile extends CodeFile implements Identifiable {

	@DBId
	protected ObjectId id;

	@DBField
	private User uploader;

	@DBField
	private String name;

	@DBField
	private String extension;

	@DBField
	private String content;

	@DBField
	private Integer lines;

	@DBField
	private Long size;

	@DBField
	private Date create;

	@DBField
	private Date update;

	@DBField
	private String[] labels;

	@DBField
	@DBIndexed(-1)
	private String path;

	@DBField
	private List<JavaProject> project;

	public User getUploader() {
		return uploader;
	}

	public void setUploader(User uploader) {
		this.uploader = uploader;
	}

	public List<JavaProject> getProject() {
		return project;
	}

	public void setProject(List<JavaProject> project) {
		this.project = project;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getLines() {
		return lines;
	}

	public void setLines(Integer lines) {
		this.lines = lines;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public Date getCreate() {
		return create;
	}

	public void setCreate(Date create) {
		this.create = create;
	}

	public Date getUpdate() {
		return update;
	}

	public void setUpdate(Date update) {
		this.update = update;
	}

	public String[] getLabels() {
		return labels;
	}

	public void setLabels(String[] labels) {
		this.labels = labels;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}
	
}
