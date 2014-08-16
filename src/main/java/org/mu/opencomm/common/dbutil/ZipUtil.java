package org.mu.opencomm.common.dbutil;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.mu.opencomm.code.entity.FileInfo;
import org.mu.opencomm.code.entity.JarFile;

public class ZipUtil {
	
	private static Comparator<FileInfo> lengthComparator = new Comparator<FileInfo>() {
		@Override
		public int compare(FileInfo i1, FileInfo i2) {
			if (i1.getPath().length() > i2.getPath().length()) {
				return -1;
			} else {
				return 1;
			}
		}
	};
	
	private static Comparator<FileInfo> alphaComparator = new Comparator<FileInfo>() {
		@Override
		public int compare(FileInfo i1, FileInfo i2) {
			return i1.getPath().compareTo(i2.getPath());
		}
	};

	public static JarFile parseJarFile(String file) throws Exception {
		JarFile jarFile = new JarFile();
		List<FileInfo> files = new ArrayList<>();
		List<FileInfo> dirs = new ArrayList<>();
		InputStream in = new BufferedInputStream(new FileInputStream(file));  
        ZipInputStream zipIn = new ZipInputStream(in);
        ZipEntry entry;
        jarFile.setLabels(new String[] { "java" });
        jarFile.setName(file.substring(file.lastIndexOf("\\") + 1));
        while ((entry = zipIn.getNextEntry()) != null) {
        	FileInfo info = new FileInfo();
        	info.setPath(entry.getName());
        	info.setSize(entry.getSize());
            if (entry.isDirectory()) {
            	info.setDir(true);
            	info.setNFiles(0);
            	dirs.add(info);
            } else {
            	info.setExtension(entry.getName().substring(entry.getName().lastIndexOf('.') + 1));
            	info.setDir(false);
            	files.add(info);
            }
        }
        zipIn.closeEntry();
        zipIn.close();
        Collections.sort(dirs, lengthComparator);
        jarFile.setContents(parseFileInfo(files, dirs));
        return jarFile;
	} 
	
	private static List<FileInfo> parseFileInfo(List<FileInfo> files, List<FileInfo> dirs) {
		List<FileInfo> list = new ArrayList<>();
		for (FileInfo dir : dirs) {
			dir.setName(dir.getPath());
			dir.setFiles(new ArrayList<>());
			list.add(dir);
			
			Iterator<FileInfo> it = files.iterator();
			while (it.hasNext()) {
				FileInfo info = it.next();
				if (info.getPath().startsWith(dir.getPath())) {
					info.setName(info.getPath().substring(info.getPath().lastIndexOf("/") + 1));
					dir.getFiles().add(info);
					dir.setNFiles(dir.getNFiles() + 1);
					it.remove();
				}
			}
		}
		
		Iterator<FileInfo> it = list.iterator();
		while (it.hasNext()) {
			FileInfo dir = it.next();
			for (FileInfo directory : dirs) {
				if (!dir.getPath().equals(directory.getPath()) && 
						dir.getPath().startsWith(directory.getPath())) {
					if (directory.getFiles() == null) {
						directory.setFiles(new ArrayList<>());
					}
					directory.getFiles().add(dir);
					it.remove();
					break;
				}
			}
		}
		Collections.sort(list, alphaComparator);
		return list;
	}
	
}
