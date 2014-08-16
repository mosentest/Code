package org.mu.opencomm.code.entity;

import java.util.Date;

import org.bson.types.ObjectId;
import org.mu.opencomm.common.annotation.DBDocument;
import org.mu.opencomm.common.annotation.DBField;
import org.mu.opencomm.common.annotation.DBId;
import org.mu.opencomm.common.annotation.DBIndexed;
import org.mu.opencomm.common.annotation.DBQueries;
import org.mu.opencomm.common.annotation.DBQuery;
import org.mu.opencomm.common.annotation.DBQueryField;
import org.mu.opencomm.common.annotation.DBQueryFields;
import org.mu.opencomm.common.entity.Identifiable;

@DBDocument(collection = "tag", autoIndexId = false)
@DBQueries({
	@DBQuery(name = "dateCompare", query = "{create:{$gte: ${start},lt:${end}}}"),
	@DBQuery(name = "increment", query = "{$inc:{nTags:${increment}}}")
})
@DBQueryFields({
	@DBQueryField(name = "minimal", fields = "{tag:1,nTags:1}")
})
public class Tag implements Identifiable {

	@DBId
	private ObjectId id;
	
	@DBField
	@DBIndexed(unique = true)
	private String tag;

	@DBField
	private long nTags;

	@DBField
	private Date date;

	@DBField
	private String type;
	
	@Override
	public ObjectId getId() {
		return id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public long getNTags() {
		return nTags;
	}

	public void setNTags(long nTags) {
		this.nTags = nTags;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

}
