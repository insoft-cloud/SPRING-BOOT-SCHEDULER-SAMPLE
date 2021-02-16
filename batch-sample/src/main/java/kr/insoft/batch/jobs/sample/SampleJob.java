package kr.insoft.batch.jobs.sample;

import java.util.Collection;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import kr.insoft.batch.annotation.SingleTask;
import kr.insoft.batch.jobs.AbstractJob;

@Component
@SingleTask
public class SampleJob extends AbstractJob<Collection<Map<String, Object>>, Collection<Map<String, Object>>, Collection<Map<String, Object>>> {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private boolean isRunning = false;
	public final static String JOB_ID = "SAMPLE-001";

	@Override
	public Collection<Map<String, Object>> read() throws Exception {
		// TODO Auto-generated method stub
		logger.debug("/// SampleJob.read : " + isRunning);
		isRunning = true;
		Thread.sleep(10000);
		return null;
	}

	@Override
	public Collection<Map<String, Object>> process(Collection<Map<String, Object>> readedItem) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("/// SampleJob.process");
		return null;
	}

	@Override
	public Collection<Map<String, Object>> write(Collection<Map<String, Object>> convertedItem) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("/// SampleJob.write");
		return null;
	}

	@Override
	public void notify(Collection<Map<String, Object>> resultItem) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("/// SampleJob.notify : " + isRunning);
		isRunning = false;
	}

}
