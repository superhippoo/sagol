package com.sagol.dto;

import java.sql.Timestamp;

public class clubmemVO {
	
	private String club_id;
	private String uid;
	private String owner_yn;
	private String nickname;
	private String gender;
	private String hit;
	private String comp_year;
	private Timestamp reg_dt;

	private String orderby_key;
	private String orderby_rule;


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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}
	public String getComp_year() {
		return comp_year;
	}
	public void setComp_year(String comp_year) {
		this.comp_year = comp_year;
	}
	public Timestamp getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Timestamp reg_dt) {
		this.reg_dt = reg_dt;
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



}
