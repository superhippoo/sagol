package com.sagol.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sagol.dto.ccVO;
import com.sagol.dto.qnaVO;

@Repository
public class qnaDaoImple implements qnaDao {

	@Autowired
	private JdbcTemplate jdbdtemplate;

	@Override
	public List<qnaVO> selectQnaList(qnaVO qnavo) {

		String q = "select * from sg_qna";
		return jdbdtemplate.query(q, new BeanPropertyRowMapper<qnaVO>(qnaVO.class));

	}

	@Override
	public List<qnaVO> selectQnaListByUid(qnaVO qnavo) {
		String q = "select * from sg_qna " 
				+ "where uid = ?" ;
		Object[] args = { qnavo.getUid()};
		return jdbdtemplate.query(q, args, new BeanPropertyRowMapper<qnaVO>(qnaVO.class));
	}
	

	@Override
	public qnaVO selectQna(qnaVO qnavo) {
		String q = "select * from sg_qna where qna_id = ? " ;
		Object[] args = { qnavo.getQna_id()};
		try {
			return jdbdtemplate.queryForObject(q, args, new BeanPropertyRowMapper<qnaVO>(qnaVO.class));
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int insertQna(qnaVO qnavo) {
		String q = "  INSERT INTO sg_qna VALUES(?,?,?,?,?,?,?,?,?)";
		Object[] args = { qnavo.getQna_id(), qnavo.getQ_title(), qnavo.getQ_body(), qnavo.getUid(),
				qnavo.getAnswer_yn(), qnavo.getA_title(), qnavo.getA_body(), qnavo.getReg_dt(), qnavo.getMdfy_dt() };
		return jdbdtemplate.update(q, args);
	}

	@Override
	public int updateQna(qnaVO qnavo) {
		String q = "update sg_qna set " 
				+ "q_title = ?  ," 
				+ "q_body = ?  ," 
				+ "answer_yn = ?  ,"
				+ "a_title = ?  ,"
				+ "a_body = ?,  "
				+ "mdfy_dt = ?  "
			    + "where qna_id = ?";
		Object[] args = { qnavo.getQ_title(), qnavo.getQ_body(), qnavo.getAnswer_yn(), qnavo.getA_title(),
				qnavo.getA_body(), qnavo.getMdfy_dt(), qnavo.getQna_id() };
		return jdbdtemplate.update(q, args);
	}

	@Override
	public int deleteQna(qnaVO qnavo) {
		String q = "delete from sg_qna where qna_id = ?" ;
		Object[] args = {qnavo.getQna_id()};
		return jdbdtemplate.update(q,args);
	}





}
