package org.mu.opencomm.code.repository;

import org.bson.types.ObjectId;
import org.mu.opencomm.code.entity.JavaFile;
import org.mu.opencomm.common.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository("javaFileRepository")
public class JavaFileRepository extends AbstractRepository<JavaFile, ObjectId> {

	public JavaFileRepository() {
		super("opencomm");
	}
	
}
