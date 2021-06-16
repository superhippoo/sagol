package com.sagol.dto;

import java.sql.Timestamp;

public class clubVO {
	private String club_id;
	private String club_nm;
	private int club_mem_num;
	private String gender;
	private int hit;
	private int comp_year;
	private String cc_id;
	private String club_type;
	private Timestamp reg_dt;
	private Timestamp mdfy_dt;
	
	public String getClub_id() {
		return club_id;
	}
	public void setClub_id(String club_id) {
		this.club_id = club_id;
	}
	public String getClub_nm() {
		return club_nm;
	}
	public void setClub_nm(String club_nm) {
		this.club_nm = club_nm;
	}
	public int getClub_mem_num() {
		return club_mem_num;
	}
	public void setClub_mem_num(int club_mem_num) {
		this.club_mem_num = club_mem_num;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getComp_year() {
		return comp_year;
	}
	public void setComp_year(int comp_year) {
		this.comp_year = comp_year;
	}
	public String getCc_id() {
		return cc_id;
	}
	public void setCc_id(String cc_id) {
		this.cc_id = cc_id;
	}
	public String getClub_type() {
		return club_type;
	}
	public void setClub_type(String club_type) {
		this.club_type = club_type;
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



}
