package com.sagol.dto;

import java.sql.Timestamp;

public class searchVO {
	//usersearchvo
	private String uid;
	private String nickname;
	private String kakao_email;
	private String comp_email;
	private String comp_cd;
	private String dft_cc_id;
	private String join_club_num;
	private String gender;
	private String hit;
	private String comp_year;
	private String report_num;
	private String act_yn;
	private String auth_yn;
	private String auth_cd;
	private String admin_yn;
	private Timestamp reg_dt;
	private Timestamp mdfy_dt;
	private String message;
	//compsearchvo
	private String comp_nm;
	private String comp_domain;
	private String comp_stat;
	private String comp_user_num;
	//ccsearchvo
	private String cc_id;
	private String cc_nm;
	private String cc_stat;
	private String cc_user_num;
	//clubsearchvo
	private String club_id;
	private String club_nm;
	private String club_mem_num;
	private String club_type;
	//clubmemsearchvo
	private String owner_yn;
	//qnasearchvo
	private String qna_id;
	private String q_title;
	private String q_body;
	private String answer_yn;
	private String a_title;
	private String a_body;
	//requestsearchvo
	private String req_id;	
	private String req_cd;
	private String title;
	private String body;
	private String complete_yn;
	//°øÅë Search Type 1. match 2. like
	private String type;

	
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getKakao_email() {
		return kakao_email;
	}
	public void setKakao_email(String kakao_email) {
		this.kakao_email = kakao_email;
	}
	public String getComp_email() {
		return comp_email;
	}
	public void setComp_email(String comp_email) {
		this.comp_email = comp_email;
	}
	public String getComp_cd() {
		return comp_cd;
	}
	public void setComp_cd(String comp_cd) {
		this.comp_cd = comp_cd;
	}
	public String getDft_cc_id() {
		return dft_cc_id;
	}
	public void setDft_cc_id(String dft_cc_id) {
		this.dft_cc_id = dft_cc_id;
	}
	public String getJoin_club_num() {
		return join_club_num;
	}
	public void setJoin_club_num(String join_club_num) {
		this.join_club_num = join_club_num;
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
	public String getReport_num() {
		return report_num;
	}
	public void setReport_num(String report_num) {
		this.report_num = report_num;
	}
	public String getAct_yn() {
		return act_yn;
	}
	public void setAct_yn(String act_yn) {
		this.act_yn = act_yn;
	}
	public String getAuth_yn() {
		return auth_yn;
	}
	public void setAuth_yn(String auth_yn) {
		this.auth_yn = auth_yn;
	}
	public String getAuth_cd() {
		return auth_cd;
	}
	public void setAuth_cd(String auth_cd) {
		this.auth_cd = auth_cd;
	}
	public String getAdmin_yn() {
		return admin_yn;
	}
	public void setAdmin_yn(String admin_yn) {
		this.admin_yn = admin_yn;
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
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
	public String getCc_stat() {
		return cc_stat;
	}
	public void setCc_stat(String cc_stat) {
		this.cc_stat = cc_stat;
	}
	public String getCc_user_num() {
		return cc_user_num;
	}
	public void setCc_user_num(String cc_user_num) {
		this.cc_user_num = cc_user_num;
	}
	
	
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
	public String getClub_mem_num() {
		return club_mem_num;
	}
	public void setClub_mem_num(String club_mem_num) {
		this.club_mem_num = club_mem_num;
	}
	public String getClub_type() {
		return club_type;
	}
	public void setClub_type(String club_type) {
		this.club_type = club_type;
	}
	
	
	public String getOwner_yn() {
		return owner_yn;
	}
	public void setOwner_yn(String owner_yn) {
		this.owner_yn = owner_yn;
	}
	
	
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
	
	
	public String getReq_id() {
		return req_id;
	}
	public void setReq_id(String req_id) {
		this.req_id = req_id;
	}
	public String getReq_cd() {
		return req_cd;
	}
	public void setReq_cd(String req_cd) {
		this.req_cd = req_cd;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getComplete_yn() {
		return complete_yn;
	}
	public void setComplete_yn(String complete_yn) {
		this.complete_yn = complete_yn;
	}
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	
}
