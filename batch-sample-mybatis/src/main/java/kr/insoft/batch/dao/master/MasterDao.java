package kr.insoft.batch.dao.master;

import java.util.List;

import kr.insoft.batch.model.master.Master;

public interface MasterDao {

	List<Master> findAll();
}
