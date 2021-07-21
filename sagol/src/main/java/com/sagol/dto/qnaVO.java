package com.sagol.dto;

import java.sql.Timestamp;

public class qnaVO {

	private String qna_id;
	private String q_title;
	private String q_body;
	private String uid;
	private String answer_yn;
	private String a_title;
	private String a_body;
	private Timestamp reg_dt;
	private Timestamp mdfy_dt;
	
	private String orderby_key;
	private String orderby_rule;
	
	public String getQna_id() {
		return qna_id;
	}
	public void setQna_id(String qna_id) {
		this.qna_id = qna_id;
	}
	public String getQ_title() {
		return q_title;
	}
	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}
	public String getQ_body() {
		return q_body;
	}
	public void setQ_body(String q_body) {
		this.q_body = q_body;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getAnswer_yn() {
		return answer_yn;
	}
	public void setAnswer_yn(String answer_yn) {
		this.answer_yn = answer_yn;
	}
	public String getA_title() {
		return a_title;
	}
	public void setA_title(String a_title) {
		this.a_title = a_title;
	}
	public String getA_body() {
		return a_body;
	}
	public void setA_body(String a_body) {
		this.a_body = a_body;
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
