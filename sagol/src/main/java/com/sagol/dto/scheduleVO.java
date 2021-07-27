package com.sagol.dto;

import java.sql.Timestamp;

public class scheduleVO {

	private String schedule_id;
	private String club_id;
	private String description;

	private Timestamp atc_dt;
	private Timestamp reg_dt;
	private Timestamp mdfy_dt;

	private String orderby_key;
	private String orderby_rule;
	
	
	public String getSchedule_id() {
		return schedule_id;
	}
	public void setSchedule_id(String schedule_id) {
		this.schedule_id = schedule_id;
	}
	public String getClub_id() {
		return club_id;
	}
	public void setClub_id(String club_id) {
		this.club_id = club_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Timestamp getAtc_dt() {
		return atc_dt;
	}
	public void setAtc_dt(Timestamp atc_dt) {
		this.atc_dt = atc_dt;
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

}
