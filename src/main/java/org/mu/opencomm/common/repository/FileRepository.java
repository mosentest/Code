package org.mu.opencomm.common.repository;

import java.io.File;
import java.util.List;

import org.mu.opencomm.common.dbutil.QueryParam;

import com.mongodb.gridfs.GridFSDBFile;

public interface FileRepository {

	public void saveFile(File file, String alias, String contentType);
	
	public void deleteFile(String file);
	
	public List<GridFSDBFile> findAllFile();
	
	public List<GridFSDBFile> queryFile(String command, QueryParam params);
	
	public GridFSDBFile findOneFile(String alis);
	
	public GridFSDBFile findOneFile(String command, QueryParam params);
	
}
