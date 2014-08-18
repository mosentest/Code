package org.mu.opencomm.code.repository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.mu.opencomm.code.entity.Tag;
import org.mu.opencomm.common.dbutil.QueryParam;
import org.mu.opencomm.common.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

@Repository("tagRepository")
public class TagRepository extends AbstractRepository<Tag, ObjectId> {
	
	private DBCollection dailyCollection;
	
	private DBCollection monthlyCollection;
	
	public TagRepository() {
		super("opencomm");
		dailyCollection = db.getCollection("tag_daily_summary");
		monthlyCollection = db.getCollection("tag_monthly_summary");
	}
	
	public List<Tag> findByType(String type) {
		return this.find(
				new BasicDBObject("type", type), 
				entityManager.getQueryField(classType, "minimal"), 
				new BasicDBObject("nTags", -1),
				0, 30);
	}
	
	public boolean dailySchedule(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		Date start = calendar.getTime();
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		Date end = calendar.getTime();
		calendar.add(Calendar.DAY_OF_YEAR, -31);
		Date expiredStart = calendar.getTime();
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		Date expiredEnd = calendar.getTime();
		DBCursor cursor = collection.find();
		while (cursor.hasNext()) {
			DBObject object = cursor.next();
			DBObject current = dailyCollection.findOne(
					entityManager.buildQuery(classType, "dateCompare", 
							new QueryParam().put("${start}", start).put("${end}", end)));
			DBObject removed = dailyCollection.findOne(
					entityManager.buildQuery(classType, "dateCompare", 
							new QueryParam().put("${start}", expiredStart).put("${end}", expiredEnd)));
			int difference = (int) current.get("nTags") - (int) removed.get("nTags");
			monthlyCollection.update(
					new BasicDBObject("tag", object.get("tag")),
					entityManager.buildQuery(classType, "increment", 
						new QueryParam("increment", difference)));
			Tag tag = new Tag();
			tag.setTag((String) object.get("tag"));
			tag.setDate(end);
			tag.setType((String) object.get("tag"));
			tag.setNTags(0);
			save(tag);
		}
		return true;
	}

}
