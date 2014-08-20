package org.mu.opencomm.code.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.mu.opencomm.code.entity.JarFile;
import org.mu.opencomm.common.dbutil.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试类
 * 
 * @author moziqi
 *
 */
public class JarFileServiceTest extends BaseServiceTest {
	private static final Logger logger = LoggerFactory
			.getLogger(JarFileServiceTest.class);
	
	private JarFileService jarFileService;

	public JarFileService getJarFileService() {
		return jarFileService;
	}

	@Resource
	public void setJarFileService(JarFileService jarFileService) {
		this.jarFileService = jarFileService;
	}

	@Test
	public void testGetJarFile() {
		JarFile jarFile = jarFileService.getJarFile("logback-core-1.0.9.jar");
		Assert.assertNotNull(jarFile);
		logger.info("testGetJarFile--->" + jarFile.toString());
	}

	@Test
	public void testGetJarFiles() {
		Page<JarFile> jarFiles = jarFileService.getJarFiles(1, 6);
		Assert.assertNotNull(jarFiles);
		List<JarFile> content = jarFiles.getContent();
		Assert.assertNotNull(content);
		for (int i = 0; i < content.size(); i++) {
			JarFile jarFile = content.get(i);
			logger.info("testGetJarFiles:----->" + jarFile.toString());
		}
	}

}
