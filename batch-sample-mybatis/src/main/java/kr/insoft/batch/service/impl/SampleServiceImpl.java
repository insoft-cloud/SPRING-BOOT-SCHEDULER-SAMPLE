package kr.insoft.batch.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.insoft.batch.dao.master.MasterDao;
import kr.insoft.batch.dao.slave.SlaveDao;
import kr.insoft.batch.model.master.Master;
import kr.insoft.batch.model.slave.Slave;
import kr.insoft.batch.service.SampleService;

@Service
public class SampleServiceImpl implements SampleService {
	
	@Autowired
	private MasterDao masterDao;
	
	@Autowired
	private SlaveDao slaveDao;

	@Override
	public List<Master> selectMasterList() {
		return masterDao.findAll();
	}

	@Override
	public List<Slave> selectSlaveList() {
		return slaveDao.findAll();
	}

}
