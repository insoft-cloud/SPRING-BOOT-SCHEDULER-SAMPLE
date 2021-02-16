package kr.insoft.batch.service;

import java.util.List;

import kr.insoft.batch.model.master.Master;
import kr.insoft.batch.model.slave.Slave;

public interface SampleService {

	List<Master> selectMasterList();
	
	List<Slave> selectSlaveList();
}
