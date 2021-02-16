package kr.insoft.batch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.insoft.batch.model.master.Master;
import kr.insoft.batch.repository.master.MasterRepository;

@Service
@Transactional("masterTransactionManager")
public class MasterService {

	@Autowired
	private MasterRepository masterRepository;
	
	public List<Master> selectMaster() {
		return masterRepository.findAll();
	}
}
