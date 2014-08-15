package org.mu.opencomm.common.repository;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.mu.opencomm.common.dbutil.QueryParam;
import org.mu.opencomm.common.entity.Identifiable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.DBCursor;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

public class AbstractFileRepository<T extends Identifiable, PK extends Serializable> 
	extends AbstractRepository<T, PK> implements FileRepository {
	
	private static final Logger logger = LoggerFactory.getLogger(AbstractFileRepository.class);
	
	protected String bucket;
	
	protected GridFS fileSystem;
	
	public AbstractFileRepository(String dbName, String bucket) {
		super(dbName);
		try {
			this.bucket = bucket;
			fileSystem = new GridFS(db, bucket);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void saveFile(File file, String alias, String contentType) {
		GridFS fileSystem = new GridFS(db, bucket);
		GridFSInputFile inputFile;
		try {
			inputFile = fileSystem.createFile(file);
			inputFile.setFilename(alias);
			inputFile.setContentType(contentType);
			inputFile.save();
			logger.debug("Saved file '{}' into gridFS bucekt '{}'", 
					new Object[] { file.getName(), bucket });
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteFile(String file) {
		fileSystem.remove(fileSystem.findOne(file));
	}

	@Override
	public GridFSDBFile findOneFile(String file) {
		return fileSystem.findOne(file);
	}

	@Override
	public List<GridFSDBFile> findAllFile() {
		List<GridFSDBFile> list = new ArrayList<>();
		DBCursor cursor = fileSystem.getFileList();
		while (cursor.hasNext()) {
			list.add((GridFSDBFile) cursor.next());
		}
		return list;
	}

	@Override
	public List<GridFSDBFile> queryFile(String command, QueryParam params) {
		return fileSystem.find(entityManager.buildQuery(classType, command, params));
	}

	@Override
	public GridFSDBFile findOneFile(String command, QueryParam params) {
		return fileSystem.findOne(entityManager.buildQuery(classType, command, params));
	}
	
}
