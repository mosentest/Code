package org.mu.opencomm.code.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:WebContent/WEB-INF/applicationContext.xml",
		"file:WebContent/WEB-INF/scheduler.xml" })
public class BaseRepositoryTest {

	@Test
	public void test() {
	}

}
