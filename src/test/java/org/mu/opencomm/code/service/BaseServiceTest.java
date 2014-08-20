package org.mu.opencomm.code.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:WebContent/WEB-INF/applicationContext.xml",
		"file:WebContent/WEB-INF/scheduler.xml" })
public class BaseServiceTest {

	@Test
	public void test() {
	}

}
