package kr.insoft.batch.jobs.sample;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.insoft.batch.jobs.AbstractJob;
import kr.insoft.batch.model.slave.Slave;
import kr.insoft.batch.service.SampleService;

@Component
public class SampleJob2 extends AbstractJob<Collection<Slave>, Collection<Slave>, Collection<Slave>> {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SampleService sampleService;
	
	@Override
	public Collection<Slave> read() throws Exception {
		// TODO Auto-generated method stub
		logger.debug("=== SampleJob2.read");
		return sampleService.selectSlaveList();
	}

	@Override
	public Collection<Slave> process(Collection<Slave> readedItem) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("=== SampleJob2.process");
		return null;
	}

	@Override
	public Collection<Slave> write(Collection<Slave> convertedItem) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("=== SampleJob2.write");
		return null;
	}

	@Override
	public void notify(Collection<Slave> resultItem) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("=== SampleJob2.notify");
	}

}
