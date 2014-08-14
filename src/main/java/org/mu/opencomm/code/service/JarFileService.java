package org.mu.opencomm.code.service;

import org.mu.opencomm.code.entity.JarFile;
import org.mu.opencomm.code.repository.JarFileRepository;
import org.mu.opencomm.common.dbutil.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("jarFileService")
public class JarFileService {

	@Autowired
	private JarFileRepository jarFileRepository;
	
	public JarFile getJarFile(String name) {
		return jarFileRepository.getJarFile(name);
	}
	
	public Page<JarFile> getJarFiles(int pn, int size) {
		return jarFileRepository.getJarFiles(pn * size, size);
	}

	public JarFileRepository getJarFileRepository() {
		return jarFileRepository;
	}

	public void setJarFileRepository(JarFileRepository jarFileRepository) {
		this.jarFileRepository = jarFileRepository;
	}
	
}
