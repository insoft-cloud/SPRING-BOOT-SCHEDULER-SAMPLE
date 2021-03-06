package kr.insoft.batch.model.slave;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Slave implements Serializable {
	private static final long serialVersionUID = -6633114733808450944L;
	
	private int seq;
	private String slaveName;
	private String slaveText;
	private String createId;
	private LocalDateTime createDatetime;
	private String updateId;
	private LocalDateTime updateDatetime;
}
