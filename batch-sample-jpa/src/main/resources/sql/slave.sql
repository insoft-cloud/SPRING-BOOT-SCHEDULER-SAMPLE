CREATE TABLE `tb_slave` (
  `seq` int(10) NOT NULL AUTO_INCREMENT,
  `slave_name` varchar(128) DEFAULT NULL COMMENT '마스터명',
  `slave_text` text DEFAULT NULL COMMENT '마스터 텍스트',
  `create_datetime` timestamp NULL DEFAULT NULL COMMENT '생성 일시',
  `create_id` varchar(50) DEFAULT NULL COMMENT '생성자 ID',
  `update_datetime` timestamp NULL DEFAULT NULL COMMENT '수정 일시ㅏ',
  `update_id` varchar(50) DEFAULT NULL COMMENT '수정자 ID',
  PRIMARY KEY (`seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
  
INSERT INTO slave.tb_slave (slave_name, slave_text, create_datetime, create_id, update_datetime, update_id) VALUES ('슬레이브1', '슬레이브1의 텍스트 입니다', now(), 'aaaa', now(), 'aaaa');
INSERT INTO slave.tb_slave (slave_name, slave_text, create_datetime, create_id, update_datetime, update_id) VALUES ('슬레이브2', '슬레이브2의 텍스트 입니다', now(), 'bbbb', now(), 'bbbb');
INSERT INTO slave.tb_slave (slave_name, slave_text, create_datetime, create_id, update_datetime, update_id) VALUES ('슬레이브3', '슬레이브3의 텍스트 입니다', now(), 'cccc', now(), 'cccc');
INSERT INTO slave.tb_slave (slave_name, slave_text, create_datetime, create_id, update_datetime, update_id) VALUES ('슬레이브4', '슬레이브4의 텍스트 입니다', now(), 'dddd', now(), 'dddd');
INSERT INTO slave.tb_slave (slave_name, slave_text, create_datetime, create_id, update_datetime, update_id) VALUES ('슬레이브5', '슬레이브5의 텍스트 입니다', now(), 'eeee', now(), 'eeee');
INSERT INTO slave.tb_slave (slave_name, slave_text, create_datetime, create_id, update_datetime, update_id) VALUES ('슬레이브6', '슬레이브6의 텍스트 입니다', now(), 'ffff', now(), 'ffff');
INSERT INTO slave.tb_slave (slave_name, slave_text, create_datetime, create_id, update_datetime, update_id) VALUES ('슬레이브7', '슬레이브7의 텍스트 입니다', now(), 'hhhh', now(), 'hhhh');
INSERT INTO slave.tb_slave (slave_name, slave_text, create_datetime, create_id, update_datetime, update_id) VALUES ('슬레이브8', '슬레이브8의 텍스트 입니다', now(), 'iiii', now(), 'iiii');
INSERT INTO slave.tb_slave (slave_name, slave_text, create_datetime, create_id, update_datetime, update_id) VALUES ('슬레이브9', '슬레이브9의 텍스트 입니다', now(), 'jjjj', now(), 'jjjj');
INSERT INTO slave.tb_slave (slave_name, slave_text, create_datetime, create_id, update_datetime, update_id) VALUES ('슬레이브10', '슬레이브10의 텍스트 입니다', now(), 'kkkk', now(), 'kkkk');