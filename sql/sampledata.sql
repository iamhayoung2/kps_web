INSERT INTO `kps`.`` (`name`) VALUES ('bitcoin'),('etherium');
select * from coin;

INSERT INTO `kps`.`risk` (`name`) VALUES ('high'),('middle'),('low');
select * from risk;

INSERT INTO `kps`.`bitpred` (`timestamp`,`premium`) VALUES (201800000,4);
INSERT INTO `kps`.`bitpred` (`timestamp`,`premium`) VALUES (201800001,3);
INSERT INTO `kps`.`bitpred` (`timestamp`,`premium`) VALUES (201800002,2);
INSERT INTO `kps`.`bitpred` (`timestamp`,`premium`) VALUES (201800003,2.5);
select * from bitpred;
