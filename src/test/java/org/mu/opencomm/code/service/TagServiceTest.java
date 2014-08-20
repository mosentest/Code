package org.mu.opencomm.code.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.mu.opencomm.code.entity.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试类
 * 
 * @author moziqi
 *
 */
public class TagServiceTest extends BaseServiceTest {
	private final static Logger Logger = LoggerFactory
			.getLogger(TagServiceTest.class);

	private TagService tagService;

	public TagService getTagService() {
		return tagService;
	}

	@Resource
	public void setTagService(TagService tagService) {
		this.tagService = tagService;
	}

	@Test
	public void testGetMostTagged() {
		List<Tag> mostTagged = tagService.getMostTagged("java");
		Assert.assertNotNull(mostTagged);
		for (int i = 0; i < mostTagged.size(); i++) {
			Tag tag = mostTagged.get(i);
			Logger.info("testGetMostTagged----->" + tag.toString());
		}
	}

}
