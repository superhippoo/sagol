CREATE DATABASE sgdb default CHARACTER SET UTF8;
use sgdb;

DROP table sg_user;
DROP table sg_comp;
DROP table sg_cc;
DROP table sg_club;
DROP table sg_clubmem;
DROP table sg_qna;
DROP table sg_request;
DROP table sg_schedule;


CREATE TABLE sg_user (
    uid VARCHAR(20) PRIMARY KEY,
    nickname VARCHAR(50),
    kakao_userid VARCHAR(50),
    comp_email VARCHAR(50),
    comp_cd VARCHAR(4),
    dft_cc_id VARCHAR(8),
    join_club_num INT(11),
    gender VARCHAR(2),
    hit INT(11),
    comp_year INT(11),
    kakao_agerange VARCHAR(20),
    report_num INT(11),
    act_yn VARCHAR(2),
    auth_yn VARCHAR(2) default 'N',
    auth_cd INT(11),
    admin_yn VARCHAR(2),
    mailsend_dt TIMESTAMP,
    reg_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    mdfy_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)  ENGINE=INNODB;

create index idx_nickname on sg_user(nickname);

show index from sg_user;

insert into sg_user values ('1','1','1','1','1','1',1,'1',1,1,'1',1,'1','1',1,'1','20200910','20200910','20200910');
select * from sg_user;



CREATE TABLE sg_comp (
    comp_cd VARCHAR(4) PRIMARY KEY,
    comp_nm VARCHAR(50),
    comp_domain VARCHAR(50),
    comp_stat VARCHAR(2),
    comp_user_num INT(11),
    reg_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    mdfy_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)  ENGINE=INNODB;

insert into sg_comp values ('1','1','1','1',1,'20200910','20200910');
select * from sg_comp;


CREATE TABLE sg_cc (
    cc_id VARCHAR(20) ,
    cc_nm VARCHAR(50),
    comp_cd VARCHAR(4),
    cc_stat VARCHAR(2),
    uid VARCHAR(20),
    cc_club_num INT(11),
    reg_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    mdfy_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(cc_id,comp_cd),
    constraint FK_SG_COMP_COMP_CD FOREIGN KEY(comp_cd) references sg_comp(comp_cd)
)  ENGINE=INNODB;

create index FK_SG_COMP_COMP_CD on sg_cc (comp_cd);

show index from sg_cc;


insert into sg_cc values ('1','1','1','1','1',1,'20200910','20200910');
select * from sg_cc;

select * from information_schema.TABLE_CONSTRAINTS where TABLE_NAME  = 'sg_cc';

CREATE TABLE sg_club (
    club_id VARCHAR(20),
    club_nm VARCHAR(20),
    club_mem_num INT(11),
    gender VARCHAR(2),
    hit INT(11),
    comp_year INT(11),
    cc_id VARCHAR(20),
    club_type VARCHAR(2),
    reg_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    mdfy_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(club_id,cc_id),
    constraint FK_SG_CC_CC_ID FOREIGN KEY(cc_id) references sg_cc(cc_id)
)  ENGINE=INNODB;

create index FK_SG_CC_CC_ID on sg_club (cc_id);

show index from sg_club;

insert into sg_club values ('1','1',1,'1',1,1,'1','C','20200910','20200910');
select * from sg_club;
select * from information_schema.TABLE_CONSTRAINTS where TABLE_NAME  = 'sg_club';

CREATE TABLE sg_clubmem (
    uid VARCHAR(20),
    club_id VARCHAR(20),   
    owner_yn VARCHAR(2),
    reg_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(uid,club_id),
    constraint FK_SG_CLUB_CLUB_ID FOREIGN KEY(club_id) references sg_club(club_id)
)  ENGINE=INNODB;

create index FK_SG_CLUB_CLUB_ID on sg_clubmem (club_id);

show index from sg_clubmem;

insert into sg_clubmem values ('1','1','1','20200910');
select * from sg_clubmem;
select * from information_schema.TABLE_CONSTRAINTS where TABLE_NAME  = 'sg_clubmem';

CREATE TABLE sg_qna (
    qna_id VARCHAR(20) PRIMARY KEY,
    q_title VARCHAR(50),
    q_body LONGTEXT,
    uid VARCHAR(20),
    answer_yn VARCHAR(2),
    a_title VARCHAR(50),
    a_body LONGTEXT,
    reg_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    mdfy_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)  ENGINE=INNODB;

insert into sg_qna values ('1','1','1','1','1','1','1','20200910','20200910');
select * from sg_qna;


CREATE TABLE sg_request (
  req_id	VARCHAR(20) PRIMARY KEY,
  req_cd VARCHAR(2),
  title	VARCHAR(50),
  body	longtext,
  uid	VARCHAR(20),
  complete_yn	VARCHAR(2),
  reg_dt	timestamp DEFAULT CURRENT_TIMESTAMP,
  mdfy_dt	timestamp DEFAULT CURRENT_TIMESTAMP
)  ENGINE=INNODB;

insert into sg_request values ('1','1','1','1','1','1','20200910','20200910');
select * from sg_request;


CREATE TABLE sg_schedule (
    schedule_id VARCHAR(20),
    club_id VARCHAR(20),
    description	VARCHAR(200),
    act_dt timestamp	DEFAULT CURRENT_TIMESTAMP,
    reg_dt timestamp	DEFAULT CURRENT_TIMESTAMP,
 	mdfy_dt timestamp DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(schedule_id,club_id),
    constraint FK_SG_SCHEDULE_SG_CLUB_CLUB_ID FOREIGN KEY(club_id) references sg_club(club_id)
)  ENGINE=INNODB;

create index FK_SG_CLUB_CLUB_ID on sg_schedule (club_id);

show index from sg_schedule;

select * from information_schema.TABLE_CONSTRAINTS where TABLE_NAME  = 'sg_schedule';

insert into sg_schedule values ('1','1','desctiption','20200910','20200910','20200910');

insert into sg_schedule values ('2','1','desctiption','20200910','20200910','20200910');

insert into sg_schedule values ('1','C202161510241999501','desctiption','20200910','20200910','20200910');

insert into sg_schedule values ('2','C202161510241999501','desctiption','20200910','20200910','20200910');

select * from sg_user where uid = 'U2021619194052134502';

update sg_user set admin_yn = 'Y' where uid = 'U2021619194052134502';

select * from sg_schedule;

DESC sg_user;
DESC sg_comp;
DESC sg_cc;
DESC sg_club;
DESC sg_clubmem;
DESC sg_qna;
DESC sg_schedule;
