package com.sagol.dto;

import java.sql.Timestamp;

public class userVO {
	
	private String uid;
	private String nickname;
	private String kakao_email;
	private String comp_email;
	private String comp_cd;
	private String dft_cc_id;
	private int join_club_num;
	private String gender;
	private int hit;
	private int comp_year;
	private int report_num;
	private String act_yn;
	private String auth_yn;
	private String auth_cd;
	private String admin_yn;
	private Timestamp reg_dt;
	private Timestamp mdfy_dt;
	private String message;
	
	
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
	public int getJoin_club_num() {
		return join_club_num;
	}
	public void setJoin_club_num(int join_club_num) {
		this.join_club_num = join_club_num;
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
	public int getReport_num() {
		return report_num;
	}
	public void setReport_num(int report_num) {
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
	
//	{
//    "uid": "",
//	  "nikname" : "",
//	  "kakao_email" : "",
//	  "comp_email" : "",
//	  "comp_cd" : "",
//	  "dft_cc_id" : "",
//	  "join_club_num" : "",
//	  "gender" : "",
//	  "hit" : "",
//	  "comp_year" : "", 
//	  "report_num" : "",
//	  "act_yn" : "",
//	  "auth_yn" : "",
//	  "reg_dt" : "",
//	  "mdfy_dt" : ""
//}
	
}
