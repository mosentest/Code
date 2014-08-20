package org.mu.opencomm.code.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试类
 * 
 * @author moziqi
 *
 */
public class TagSchedulerTest extends BaseServiceTest {
	private static final Logger logger = LoggerFactory
			.getLogger(TagSchedulerTest.class);

	private TagScheduler tagScheduler;

	public TagScheduler getTagScheduler() {
		return tagScheduler;
	}

	@Resource
	public void setTagScheduler(TagScheduler tagScheduler) {
		this.tagScheduler = tagScheduler;
	}

	@Test
	public void testDailySchedule() {
		logger.debug("启动前");
		tagScheduler.dailySchedule();
		logger.debug("启动后");
	}

}
