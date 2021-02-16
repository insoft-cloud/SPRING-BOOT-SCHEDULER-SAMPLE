package kr.insoft.batch.jobs.sample;

import java.util.Collection;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import kr.insoft.batch.annotation.SingleTask;
import kr.insoft.batch.jobs.AbstractJob;

@Component
public class SampleJob2 extends AbstractJob<Collection<Map<String, Object>>, Collection<Map<String, Object>>, Collection<Map<String, Object>>> {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Collection<Map<String, Object>> read() throws Exception {
		// TODO Auto-generated method stub
		logger.debug("=== SampleJob2.read");
		Thread.sleep(10000);
		return null;
	}

	@Override
	public Collection<Map<String, Object>> process(Collection<Map<String, Object>> readedItem) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("=== SampleJob2.process");
		return null;
	}

	@Override
	public Collection<Map<String, Object>> write(Collection<Map<String, Object>> convertedItem) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("=== SampleJob2.write");
		return null;
	}

	@Override
	public void notify(Collection<Map<String, Object>> resultItem) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("=== SampleJob2.notify");
	}

}
