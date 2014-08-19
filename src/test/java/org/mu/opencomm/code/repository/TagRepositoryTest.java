package org.mu.opencomm.code.repository;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.mu.opencomm.code.entity.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TagRepositoryTest extends BaseRepositoryTest {
	private static final Logger logger = LoggerFactory
			.getLogger(TagRepositoryTest.class);
	private TagRepository tagRepository;

	public TagRepository getTagRepository() {
		return tagRepository;
	}

	@Resource
	public void setTagRepository(TagRepository tagRepository) {
		this.tagRepository = tagRepository;
	}

	@Test
	public void testFindByType() {
		List<Tag> findByType = tagRepository.findByType("cpp");
		for (int i = 0; i < findByType.size(); i++) {
			Tag tag = findByType.get(i);
			logger.info("testFindByType---:---" + tag.toString());
		}
	}

	@Test
	public void testDailySchedule() {

	}

}
