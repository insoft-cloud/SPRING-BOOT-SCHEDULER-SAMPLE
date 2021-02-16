package kr.insoft.batch.model.master;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_master")
public class Master implements Serializable {
	private static final long serialVersionUID = 774305992181485841L;

	@Id
	@Column(name = "seq")
	private int seq;
	
	@Column(name = "master_name")
	private String masterName;
	
	@Column(name = "master_text", columnDefinition = "TEXT")
	private String masterText;
	
	@Column(name = "create_id")
	private String createId;
	
	@Column(name = "create_datetime", columnDefinition = "TIMESTAMP")
	private LocalDateTime createDatetime;
	
	@Column(name = "update_id")
	private String updateId;
	
	@Column(name = "update_datetime", columnDefinition = "TIMESTAMP")
	private LocalDateTime updateDatetime;
}
