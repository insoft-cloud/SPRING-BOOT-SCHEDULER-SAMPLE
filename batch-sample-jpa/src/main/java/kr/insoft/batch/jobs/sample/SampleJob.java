package kr.insoft.batch.jobs.sample;

import java.util.Collection;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.insoft.batch.annotation.SingleTask;
import kr.insoft.batch.jobs.AbstractJob;
import kr.insoft.batch.model.master.Master;
import kr.insoft.batch.service.MasterService;

@Component
@SingleTask
public class SampleJob extends AbstractJob<Collection<Master>, Collection<Master>, Collection<Master>> {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private boolean isRunning = false;
	public final static String JOB_ID = "SAMPLE-001";
	
	@Autowired
	private MasterService masterService;

	@Override
	public Collection<Master> read() throws Exception {
		// TODO Auto-generated method stub
		logger.debug("/// SampleJob.read : " + isRunning);
		isRunning = true;
		Thread.sleep(10000);
		
		return masterService.selectMaster();
	}

	@Override
	public Collection<Master> process(Collection<Master> readedItem) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("/// SampleJob.process");
		return null;
	}

	@Override
	public Collection<Master> write(Collection<Master> convertedItem) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("/// SampleJob.write");
		return null;
	}

	@Override
	public void notify(Collection<Master> resultItem) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("/// SampleJob.notify : " + isRunning);
		isRunning = false;
	}

}
