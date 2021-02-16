
CREATE TABLE `tb_master` (
  `seq` int(10) NOT NULL AUTO_INCREMENT,
  `master_name` varchar(128) DEFAULT NULL COMMENT '마스터명',
  `master_text` text DEFAULT NULL COMMENT '마스터 텍스트',
  `create_datetime` timestamp NULL DEFAULT NULL COMMENT '생성 일시',
  `create_id` varchar(50) DEFAULT NULL COMMENT '생성자 ID',
  `update_datetime` timestamp NULL DEFAULT NULL COMMENT '수정 일시ㅏ',
  `update_id` varchar(50) DEFAULT NULL COMMENT '수정자 ID',
  PRIMARY KEY (`seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
  
INSERT INTO master.tb_master (master_name, master_text, create_datetime, create_id, update_datetime, update_id) VALUES ('마스터1', '마스터1의 텍스트 입니다', now(), 'aaaa', now(), 'aaaa');
INSERT INTO master.tb_master (master_name, master_text, create_datetime, create_id, update_datetime, update_id) VALUES ('마스터2', '마스터2의 텍스트 입니다', now(), 'bbbb', now(), 'bbbb');
INSERT INTO master.tb_master (master_name, master_text, create_datetime, create_id, update_datetime, update_id) VALUES ('마스터3', '마스터3의 텍스트 입니다', now(), 'cccc', now(), 'cccc');
INSERT INTO master.tb_master (master_name, master_text, create_datetime, create_id, update_datetime, update_id) VALUES ('마스터4', '마스터4의 텍스트 입니다', now(), 'dddd', now(), 'dddd');
INSERT INTO master.tb_master (master_name, master_text, create_datetime, create_id, update_datetime, update_id) VALUES ('마스터5', '마스터5의 텍스트 입니다', now(), 'eeee', now(), 'eeee');
INSERT INTO master.tb_master (master_name, master_text, create_datetime, create_id, update_datetime, update_id) VALUES ('마스터6', '마스터6의 텍스트 입니다', now(), 'ffff', now(), 'ffff');
INSERT INTO master.tb_master (master_name, master_text, create_datetime, create_id, update_datetime, update_id) VALUES ('마스터7', '마스터7의 텍스트 입니다', now(), 'hhhh', now(), 'hhhh');
INSERT INTO master.tb_master (master_name, master_text, create_datetime, create_id, update_datetime, update_id) VALUES ('마스터8', '마스터8의 텍스트 입니다', now(), 'iiii', now(), 'iiii');
INSERT INTO master.tb_master (master_name, master_text, create_datetime, create_id, update_datetime, update_id) VALUES ('마스터9', '마스터9의 텍스트 입니다', now(), 'jjjj', now(), 'jjjj');
INSERT INTO master.tb_master (master_name, master_text, create_datetime, create_id, update_datetime, update_id) VALUES ('마스터10', '마스터10의 텍스트 입니다', now(), 'kkkk', now(), 'kkkk');