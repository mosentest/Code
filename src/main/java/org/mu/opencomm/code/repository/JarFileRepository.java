package org.mu.opencomm.code.repository;

import org.bson.types.ObjectId;
import org.mu.opencomm.code.entity.JarFile;
import org.mu.opencomm.common.dbutil.Page;
import org.mu.opencomm.common.repository.AbstractFileRepository;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;

@Repository("jarFileRepository")
public class JarFileRepository extends AbstractFileRepository<JarFile, ObjectId> {

	public JarFileRepository() {
		super("opencomm", "jar");
	}
	
	public Page<JarFile> getJarFiles(int offset, int limit) {
		Page<JarFile> page = new Page<>();
		page.setTotalElements(count());
		if (page.isEmpty()) {
			return page;
		}
		page.setTotalPages((page.getTotalElements() / limit) + 1);
		page.setContent(find(null, null, new BasicDBObject("create", 1), offset, limit));
		return page;
	}
	
	public JarFile getJarFile(String name) {
		return findOne(new BasicDBObject("name", name), null);
	}

}
