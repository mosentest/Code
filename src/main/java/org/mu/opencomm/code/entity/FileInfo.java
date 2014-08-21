package org.mu.opencomm.code.entity;

import java.util.List;

import org.mu.opencomm.common.annotation.DBEmbeddedDocument;
import org.mu.opencomm.common.annotation.DBField;

@DBEmbeddedDocument
public class FileInfo {

	@DBField
	private String name;

	@DBField
	private Long size;

	@DBField
	private String extension;

	@DBField
	private boolean isDir;

	private String path;

	@DBField
	private int nFiles;

	@DBField
	private List<FileInfo> files;
	
	public FileInfo() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String type) {
		this.extension = type;
	}

	public boolean isDir() {
		return isDir;
	}

	public void setDir(boolean isDir) {
		this.isDir = isDir;
	}

	public int getNFiles() {
		return nFiles;
	}

	public void setNFiles(int nFiles) {
		this.nFiles = nFiles;
	}

	public List<FileInfo> getFiles() {
		return files;
	}

	public void setFiles(List<FileInfo> files) {
		this.files = files;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "FileInfo [name=" + name + ", size=" + size + ", extension="
				+ extension + ", isDir=" + isDir + ", path=" + path
				+ ", nFiles=" + nFiles + ", files=" + files + "]";
	}
	
}
