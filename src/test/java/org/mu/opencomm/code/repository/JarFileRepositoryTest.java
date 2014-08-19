package org.mu.opencomm.code.repository;

import javax.annotation.Resource;

import org.junit.Test;

/**
 * 测试JarFileRepository下的方法
 * 
 * @author moziqi
 *
 */
public class JarFileRepositoryTest extends BaseRepositoryTest {
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
