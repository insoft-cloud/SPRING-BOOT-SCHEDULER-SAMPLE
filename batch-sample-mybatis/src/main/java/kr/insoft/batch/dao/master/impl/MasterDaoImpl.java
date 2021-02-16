package kr.insoft.batch.dao.master.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import kr.insoft.batch.dao.master.MasterDao;
import kr.insoft.batch.model.master.Master;

@Repository
public class MasterDaoImpl implements MasterDao {

	@Autowired
	@Qualifier("masterSqlSessionTemplate")
	private SqlSession sqlSession;
	private String namespace = "kr.insoft.batch.mapper.master.";
	
	@Override
	public List<Master> findAll() {
		return sqlSession.selectList(namespace + "selectAll");
	}

}
