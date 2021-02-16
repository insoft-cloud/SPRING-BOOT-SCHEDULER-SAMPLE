package kr.insoft.batch.dao.slave;

import java.util.List;

import kr.insoft.batch.model.slave.Slave;

public interface SlaveDao {

	public List<Slave> findAll();
}
