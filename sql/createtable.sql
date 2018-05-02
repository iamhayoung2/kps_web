drop table bitpred;
drop table alarm;
drop table coin;
drop table member;
drop table risk;
drop table contact;
drop table prominum;

CREATE TABLE `bitpred` (
	`timestamp` INT(20) NOT NULL,
	`premium` FLOAT NULL DEFAULT NULL,
	PRIMARY KEY (`timestamp`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;

CREATE TABLE `alarm` (
	`no` INT(11) NOT NULL AUTO_INCREMENT,
	`coin_no` INT(11) NOT NULL,
	`percent` FLOAT NOT NULL DEFAULT '0',
	`contact_no` INT(11) NOT NULL DEFAULT '1',
	`member_no` INT(11) NOT NULL,
	PRIMARY KEY (`no`),
	INDEX `FK_alarm_coin` (`coin_no`),
	INDEX `FK_alarm_contact` (`contact_no`),
	INDEX `FK_alarm_member` (`member_no`),
	CONSTRAINT `FK_alarm_coin` FOREIGN KEY (`coin_no`) REFERENCES `coin` (`no`) ON DELETE CASCADE,
	CONSTRAINT `FK_alarm_contact` FOREIGN KEY (`contact_no`) REFERENCES `contact` (`no`) ON DELETE CASCADE,
	CONSTRAINT `FK_alarm_member` FOREIGN KEY (`member_no`) REFERENCES `member` (`no`) ON DELETE CASCADE
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
AUTO_INCREMENT=13
;


CREATE TABLE `coin` (
	`no` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`no`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;

CREATE TABLE `contact` (
	`no` INT(11) NOT NULL AUTO_INCREMENT,
	`member_no` INT(11) NOT NULL,
	`type` INT(11) NOT NULL DEFAULT '',
	`address` VARCHAR(60) NOT NULL DEFAULT '',
	`certification` INT(11) NOT NULL DEFAULT '0',
	PRIMARY KEY (`no`),
	INDEX `FK_contact_member` (`member_no`),
	CONSTRAINT `FK_contact_member` FOREIGN KEY (`member_no`) REFERENCES `member` (`no`) ON DELETE CASCADE
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
AUTO_INCREMENT=20
;

CREATE TABLE `member` (
	`no` INT(11) NOT NULL AUTO_INCREMENT,
	`id` VARCHAR(50) NOT NULL,
	`pw` VARCHAR(50) NOT NULL,
	`email` VARCHAR(50) NOT NULL,
	`agree` INT(11) NOT NULL DEFAULT '0',
	`risk_no` INT(11) NOT NULL DEFAULT '0',
	PRIMARY KEY (`no`),
	INDEX `FK_member_risk` (`risk_no`),
	CONSTRAINT `FK_member_risk` FOREIGN KEY (`risk_no`) REFERENCES `risk` (`no`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;

CREATE TABLE `premium` (
	`timestamp` INT(11) NOT NULL,
	`premium` FLOAT NULL DEFAULT NULL,
	PRIMARY KEY (`timestamp`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;

CREATE TABLE `risk` (
	`no` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(100) NOT NULL DEFAULT '0',
	PRIMARY KEY (`no`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;