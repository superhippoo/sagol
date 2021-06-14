package com.sagol.dto;

import java.sql.Timestamp;

public class clubmemVO {
	
	private String club_id;
	private String uid;
	private String owner_yn;
	private Timestamp reg_dt;


	public String getClub_id() {
		return club_id;
	}
	public void setClub_id(String club_id) {
		this.club_id = club_id;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getOwner_yn() {
		return owner_yn;
	}
	public void setOwner_yn(String owner_yn) {
		this.owner_yn = owner_yn;
	}
	public Timestamp getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Timestamp reg_dt) {
		this.reg_dt = reg_dt;
	}


}
