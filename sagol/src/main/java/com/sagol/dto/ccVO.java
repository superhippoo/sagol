package com.sagol.dto;

import java.sql.Timestamp;

public class ccVO {
	
	private String cc_id;
	private String cc_nm;
	private String comp_cd;
	private String cc_stat;
	private String uid;
	private String cc_club_num;
	private Timestamp reg_dt;
	private Timestamp mdfy_dt;

	private String orderby_key;
	private String orderby_rule;
	
	public String getCc_id() {
		return cc_id;
	}
	public void setCc_id(String cc_id) {
		this.cc_id = cc_id;
	}
	public String getCc_nm() {
		return cc_nm;
	}
	public void setCc_nm(String cc_nm) {
		this.cc_nm = cc_nm;
	}
	public String getComp_cd() {
		return comp_cd;
	}
	public void setComp_cd(String comp_cd) {
		this.comp_cd = comp_cd;
	}
	public String getCc_stat() {
		return cc_stat;
	}
	public void setCc_stat(String cc_stat) {
		this.cc_stat = cc_stat;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getCc_club_num() {
		return cc_club_num;
	}
	public void setCc_club_num(String cc_club_num) {
		this.cc_club_num = cc_club_num;
	}
	public Timestamp getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Timestamp reg_dt) {
		this.reg_dt = reg_dt;
	}
	public Timestamp getMdfy_dt() {
		return mdfy_dt;
	}
	public void setMdfy_dt(Timestamp mdfy_dt) {
		this.mdfy_dt = mdfy_dt;
	}
	public String getOrderby_key() {
		return orderby_key;
	}
	public void setOrderby_key(String orderby_key) {
		this.orderby_key = orderby_key;
	}
	public String getOrderby_rule() {
		return orderby_rule;
	}
	public void setOrderby_rule(String orderby_rule) {
		this.orderby_rule = orderby_rule;
	}

//    "cc_id": "1",
//    "cc_nm": "1",
//    "comp_cd": "1",
//    "cc_stat": "1",
//    "uid": "1",
//    "cc_user_num": 1,
//    "reg_dt": "2020-09-10T00:00:00.000+00:00",
//    "mdfy_dt": "2020-09-10T00:00:00.000+00:00"
	

}
