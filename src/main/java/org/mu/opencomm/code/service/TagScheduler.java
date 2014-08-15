package org.mu.opencomm.code.service;

import java.util.Date;

import org.mu.opencomm.code.repository.TagRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class TagScheduler {

	private static final Logger logger = LoggerFactory.getLogger(TagScheduler.class);
	
	@Autowired
	private TagRepository tagRepository;
	
	public void dailySchedule() {
		boolean succesful = tagRepository.dailySchedule(new Date());
		if (succesful) {
			logger.debug("MapReduce Succeed");
		} else {
			logger.debug("MapReduce Failed");
		}
	}

	public TagRepository getTagRepository() {
		return tagRepository;
	}

	public void setTagRepository(TagRepository tagRepository) {
		this.tagRepository = tagRepository;
	}
	
}
