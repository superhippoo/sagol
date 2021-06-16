CREATE DATABASE sgdb default CHARACTER SET UTF8;
use sgdb;

DROP table sg_user;
DROP table sg_comp;
DROP table sg_cc;
DROP table sg_club;
DROP table sg_clubmem;
DROP table sg_qna;

CREATE TABLE sg_user (
    uid VARCHAR(20) PRIMARY KEY,
    nikname VARCHAR(50),
    kakao_email VARCHAR(50),
    comp_email VARCHAR(50),
    comp_cd VARCHAR(4),
    dft_cc_id VARCHAR(8),
    join_club_num INT(11),
    gender VARCHAR(2),
    hit INT(11),
    comp_year INT(11),
    report_num INT(11),
    act_yn VARCHAR(2),
    auth_yn VARCHAR(2),
    admin_yn VARCHAR(2),
    reg_dt TIMESTAMP,
    mdfy_dt TIMESTAMP
)  ENGINE=INNODB;

insert into sg_user values ('1','1','1','1','1','1',1,'1',1,1,1,'1','1','1','20200910','20200910');
select * from sg_user;

CREATE TABLE sg_comp (
    comp_cd VARCHAR(4) PRIMARY KEY,
    comp_nm VARCHAR(50),
    comp_stat VARCHAR(2),
    comp_user_num INT(11),
    reg_dt TIMESTAMP,
    mdfy_dt TIMESTAMP
)  ENGINE=INNODB;

insert into sg_comp values ('1','1','1',1,'20200910','20200910');
select * from sg_comp;

CREATE TABLE sg_cc (
    cc_id VARCHAR(20) PRIMARY KEY,
    cc_nm VARCHAR(50),
    comp_cd VARCHAR(4),
    cc_stat VARCHAR(2),
    uid VARCHAR(20),
    cc_user_num INT(11),
    reg_dt TIMESTAMP,
    mdfy_dt TIMESTAMP
)  ENGINE=INNODB;


insert into sg_cc values ('1','1','1','1','1',1,'20200910','20200910');
select * from sg_cc;

CREATE TABLE sg_club (
    club_id VARCHAR(20) PRIMARY KEY,
    club_nm VARCHAR(20),
    club_mem_num INT(11),
    gender VARCHAR(2),
    hit INT(11),
    comp_year INT(11),
    cc_id VARCHAR(20),
    club_type VARCHAR(2),
    reg_dt TIMESTAMP,
    mdfy_dt TIMESTAMP
)  ENGINE=INNODB;

insert into sg_club values ('2','1',1,'1',1,1,'1','C','20200910','20200910');
select * from sg_club;

CREATE TABLE sg_clubmem (
    club_id VARCHAR(20) PRIMARY KEY,
    uid VARCHAR(20),
    owner_yn VARCHAR(2),
    reg_dt TIMESTAMP
)  ENGINE=INNODB;

insert into sg_clubmem values ('1','1','1','20200910');
select * from sg_clubmem;

CREATE TABLE sg_qna (
    qna_id VARCHAR(20) PRIMARY KEY,
    q_title VARCHAR(50),
    q_body LONGTEXT,
    uid VARCHAR(20),
    answer_yn VARCHAR(2),
    a_title VARCHAR(50),
    a_body LONGTEXT,
    reg_dt TIMESTAMP,
    mdfy_dt TIMESTAMP
)  ENGINE=INNODB;

insert into sg_qna values ('1','1','1','1','1','1','1','20200910','20200910');
select * from sg_qna;

DESC sg_user;
DESC sg_comp;
DESC sg_cc;
DESC sg_club;
DESC sg_clubmem;
DESC sg_qna;