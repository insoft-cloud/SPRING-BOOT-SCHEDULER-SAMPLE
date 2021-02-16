package kr.insoft.batch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.insoft.batch.model.slave.Slave;
import kr.insoft.batch.repository.slave.SlaveRepository;

@Service
public class SlaveService {

	@Autowired
	private SlaveRepository slaveRepository;
	
	public List<Slave> selectSlave() {
		return slaveRepository.findAll();
	}
}
