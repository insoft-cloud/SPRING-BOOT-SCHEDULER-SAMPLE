package kr.insoft.batch.repository.slave;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.insoft.batch.model.slave.Slave;

@Repository
public interface SlaveRepository extends JpaRepository<Slave, Long> {

}
