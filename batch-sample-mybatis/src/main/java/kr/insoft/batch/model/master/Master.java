package kr.insoft.batch.model.master;

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
public class Master implements Serializable {
	private static final long serialVersionUID = 774305992181485841L;
	
	private int seq;
	private String masterName;
	private String masterText;
	private String createId;
	private LocalDateTime createDatetime;
	private String updateId;
	private LocalDateTime updateDatetime;
}
