package org.mu.opencomm.code.repository;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试JarFileRepository下的方法
 * 
 * @author moziqi
 *
 */
public class JarFileRepositoryTest extends BaseRepositoryTest {
	private static final Logger logger = LoggerFactory
			.getLogger(JarFileRepositoryTest.class);

	private JarFileRepository JarFileRepository;

	public JarFileRepository getJarFileRepository() {
		return JarFileRepository;
	}

	@Resource
	public void setJarFileRepository(JarFileRepository jarFileRepository) {
		JarFileRepository = jarFileRepository;
	}

	@Test
	public void testGetJarFiles() {
	}

	@Test
	public void testGetJarFile() {
	}

}
