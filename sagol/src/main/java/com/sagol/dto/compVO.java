package com.sagol.dto;

import java.sql.Timestamp;

public class compVO {
	
	private String comp_cd;
	private String comp_nm;
	private String comp_stat;
	private int comp_user_num;
	private Timestamp reg_dt;
	private Timestamp mdfy_dt;
	
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
	public String getComp_stat() {
		return comp_stat;
	}
	public void setComp_stat(String comp_stat) {
		this.comp_stat = comp_stat;
	}
	public int getComp_user_num() {
		return comp_user_num;
	}
	public void setComp_user_num(int comp_user_num) {
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
	
//	{
//	    "comp_cd": "",
//	    "comp_nm": "",
//	    "comp_user_num": 1,
//	    "reg_dt": "",
//	    "mdfy_dt": ""
//	}
	

}
