package kr.insoft.batch.repository.master;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.insoft.batch.model.master.Master;

@Repository
public interface MasterRepository extends JpaRepository<Master, Long> {
//	public interface MasterRepository extends CrudRepository<Master, Integer> {

}
