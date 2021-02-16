package kr.insoft.batch.dao.slave.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import kr.insoft.batch.dao.slave.SlaveDao;
import kr.insoft.batch.model.slave.Slave;

@Repository
public class SlaveDaoImpl implements SlaveDao {
	
	@Autowired
	@Qualifier("slaveSqlSessionTemplate")
	private SqlSession sqlSession;
	private String namespace = "kr.insoft.batch.mapper.slave.";

	@Override
	public List<Slave> findAll() {
		return sqlSession.selectList(namespace + "selectAll");
	}

}
