package test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mu.opencomm.code.entity.JarFile;
import org.mu.opencomm.code.repository.JarFileRepository;
import org.mu.opencomm.common.dbutil.ZipUtil;

import com.mongodb.BasicDBObject;

public class JarLoader {

	public static void main(String[] args) {
		JarFileRepository jarRepository = new JarFileRepository();
		jarRepository.delete(new BasicDBObject());
		jarRepository.deleteFiles();
		File base = new File("C:\\Users\\Muu\\.m2\\repository");
		List<File> files = new ArrayList<>();
		getFiles(files, base);
		for (File file : files) {
			try {
				JarFile jarFile = ZipUtil.parseJarFile(file.getAbsolutePath());
				jarRepository.saveFile(file, file.getName(), "jar");
				jarRepository.save(jarFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void getFiles(List<File> list, File dir) {
		for (File file : dir.listFiles()) {
			if (file.isDirectory()) {
				getFiles(list, file);
			}
			if (isJar(file)) {
				list.add(file);
			}
		}
	}
	
	private static boolean isJar(File file) {
		return !file.getName().endsWith("sources.jar") &&
				 !file.getName().endsWith("javadoc.jar") &&
				 file.getName().endsWith("jar");
	}
}
