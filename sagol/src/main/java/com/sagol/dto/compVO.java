package com.sagol.dto;

import java.sql.Timestamp;

public class compVO {
	
	private String comp_cd;
	private String comp_nm;
	private String comp_domain;
	private String comp_stat;
	private String comp_user_num;
	private Timestamp reg_dt;
	private Timestamp mdfy_dt;
	
	private String orderby_key;
	private String orderby_rule;
	
	public String getComp_cd() {
		return comp_cd;
	}
	public void setComp_cd(String comp_cd) {
		this.comp_cd = comp_cd;
	}
	public String getComp_nm() {
		return comp_nm;
	}
	public void setComp_nm(String comp_nm) {
		this.comp_nm = comp_nm;
	}
	public String getComp_domain() {
		return comp_domain;
	}
	public void setComp_domain(String comp_domain) {
		this.comp_domain = comp_domain;
	}
	public String getComp_stat() {
		return comp_stat;
	}
	public void setComp_stat(String comp_stat) {
		this.comp_stat = comp_stat;
	}
	public String getComp_user_num() {
		return comp_user_num;
	}
	public void setComp_user_num(String comp_user_num) {
		this.comp_user_num = comp_user_num;
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
//	{
//	    "comp_cd": "",
//	    "comp_nm": "",
//	    "comp_user_num": 1,
//	    "reg_dt": "",
//	    "mdfy_dt": ""
//	}
	

}
