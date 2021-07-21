package com.sagol.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sagol.dto.qnaVO;
import com.sagol.dto.searchVO;

@Repository
public class qnaDaoImple implements qnaDao {

//	@Autowired
//	private JdbcTemplate jdbdtemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<qnaVO> selectQnaList(qnaVO qnavo) {

//		String q = "select * from sg_qna";
//		return jdbdtemplate.query(q, new BeanPropertyRowMapper<qnaVO>(qnaVO.class));
		StringBuffer sql = new StringBuffer();

		sql.append("\n").append("select ");
		sql.append("\n").append("* ");
		sql.append("\n").append("from sg_qna ");
		
		if (qnavo.getOrderby_key() != null && qnavo.getOrderby_key() != "") {
			sql.append("\n").append("order by ").append(qnavo.getOrderby_key());	
			if (qnavo.getOrderby_rule() != null && qnavo.getOrderby_rule() != "") {
				sql.append(" ").append(qnavo.getOrderby_rule());	
			}
		}else {
			sql.append("\n").append("order by mdfy_dt");
		}

		RowMapper<qnaVO> mapper = new BeanPropertyRowMapper<qnaVO>(qnaVO.class);
		return namedParameterJdbcTemplate.query(sql.toString(), mapper);
	}

	@Override
	public List<qnaVO> selectQnaListByUid(qnaVO qnavo) {
//		String q = "select * from sg_qna " 
//				+ "where uid = ?" ;
//		Object[] args = { qnavo.getUid()};
//		return jdbdtemplate.query(q, args, new BeanPropertyRowMapper<qnaVO>(qnaVO.class));

		StringBuffer sql = new StringBuffer();

		sql.append("\n").append("select ");
		sql.append("\n").append("* ");
		sql.append("\n").append("from sg_qna ");
		sql.append("\n").append("where uid = :uid");
		
		if (qnavo.getOrderby_key() != null && qnavo.getOrderby_key() != "") {
			sql.append("\n").append("order by ").append(qnavo.getOrderby_key());	
			if (qnavo.getOrderby_rule() != null && qnavo.getOrderby_rule() != "") {
				sql.append(" ").append(qnavo.getOrderby_rule());	
			}
		}else {
			sql.append("\n").append("order by mdfy_dt");
		}

		
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(qnavo);

		RowMapper<qnaVO> mapper = new BeanPropertyRowMapper<qnaVO>(qnaVO.class);
		return namedParameterJdbcTemplate.query(sql.toString(), paramSource, mapper);

	}

	@Override
	public qnaVO selectQna(qnaVO qnavo) {
//		String q = "select * from sg_qna where qna_id = ? " ;
//		Object[] args = { qnavo.getQna_id()};
//		try {
//			return jdbdtemplate.queryForObject(q, args, new BeanPropertyRowMapper<qnaVO>(qnaVO.class));
//		} catch (Exception e) {
//			return null;
//		}
		StringBuffer sql = new StringBuffer();

		sql.append("\n").append("select ");
		sql.append("\n").append("* ");
		sql.append("\n").append("from sg_qna");
		sql.append("\n").append("where qna_id = :qna_id");

		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(qnavo);
		RowMapper<qnaVO> mapper = new BeanPropertyRowMapper<qnaVO>(qnaVO.class);
		try {
			return namedParameterJdbcTemplate.queryForObject(sql.toString(), paramSource, mapper);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int insertQna(qnaVO qnavo) {
//		String q = "  INSERT INTO sg_qna VALUES(?,?,?,?,?,?,?,?,?)";
//		Object[] args = { qnavo.getQna_id(), qnavo.getQ_title(), qnavo.getQ_body(), qnavo.getUid(),
//				qnavo.getAnswer_yn(), qnavo.getA_title(), qnavo.getA_body(), qnavo.getReg_dt(), qnavo.getMdfy_dt() };
//		return jdbdtemplate.update(q, args);
		StringBuffer sql = new StringBuffer();

		sql.append("\n").append("INSERT INTO sg_qna ");
		sql.append("\n").append("(qna_id,q_title,q_body,uid,answer_yn,a_title,a_body,reg_dt,mdfy_dt");
		sql.append("\n").append(") ");
		sql.append("\n").append("VALUES (:qna_id,:q_title,:q_body,:uid,:answer_yn,:a_title,:a_body,:reg_dt,:mdfy_dt");
		sql.append("\n").append(")");

		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(qnavo);

		return namedParameterJdbcTemplate.update(sql.toString(), paramSource);

	}

	@Override
	public int updateQna(qnaVO qnavo) {
//		String q = "update sg_qna set " 
//				+ "q_title = ?  ," 
//				+ "q_body = ?  ," 
//				+ "answer_yn = ?  ,"
//				+ "a_title = ?  ,"
//				+ "a_body = ?,  "
//				+ "mdfy_dt = ?  "
//			    + "where qna_id = ?";
//		Object[] args = { qnavo.getQ_title(), qnavo.getQ_body(), qnavo.getAnswer_yn(), qnavo.getA_title(),
//				qnavo.getA_body(), qnavo.getMdfy_dt(), qnavo.getQna_id() };
//		return jdbdtemplate.update(q, args);

		StringBuffer sql = new StringBuffer();

		sql.append("\n").append("update sg_qna set ");
		sql.append("\n").append("q_title = :q_title , ");
		sql.append("\n").append("q_body = :q_body , ");
		sql.append("\n").append("answer_yn = :answer_yn , ");
		sql.append("\n").append("a_title = :a_title , ");
		sql.append("\n").append("a_body = :a_body, ");
		sql.append("\n").append("mdfy_dt = :mdfy_dt");
		sql.append("\n").append("where qna_id = :qna_id");

		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(qnavo);

		return namedParameterJdbcTemplate.update(sql.toString(), paramSource);
	}

	@Override
	public int deleteQna(qnaVO qnavo) {
//		String q = "delete from sg_qna where qna_id = ?" ;
//		Object[] args = {qnavo.getQna_id()};
//		return jdbdtemplate.update(q,args);

		StringBuffer sql = new StringBuffer();

		sql.append("\n").append("delete from sg_qna ");
		sql.append("\n").append("where qna_id = :qna_id");

		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(qnavo);

		return namedParameterJdbcTemplate.update(sql.toString(), paramSource);
	}

	@Override
	public int isExistByQnaId(qnaVO qna_id) {
//		String q = "select count(*) from sg_qna where qna_id = ?";
//		Object[] args = { qnavo.getQna_id() };
//		try {
//			return jdbdtemplate.queryForObject(q, args, Integer.class);
//		} catch (Exception e) {
//			return 0;
//		}
		StringBuffer sql = new StringBuffer();

		sql.append("\n").append("select ");
		sql.append("\n").append("count(*) ");
		sql.append("\n").append("from sg_qna");
		sql.append("\n").append("where qna_id = :qna_id");

		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(qna_id);

		try {
			return namedParameterJdbcTemplate.queryForObject(sql.toString(), paramSource, Integer.class);
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public List<searchVO> search(searchVO searchvo) {
		StringBuffer sql = new StringBuffer();

		sql.append("\n").append("select ");
		sql.append("\n").append("* ");
		sql.append("\n").append("from sg_qna");
		sql.append("\n").append("where 1=1");

		if (searchvo.getQna_id() != null && searchvo.getQna_id() != "") {
			sql.append("\n").append("and qna_id = :qna_id");
		}
		if (searchvo.getQ_title() != null && searchvo.getQ_title() != "") {
			if ("like".equals(searchvo.getType())) {
				sql.append("\n").append("and q_title like '%").append(searchvo.getQ_title()).append("%'");
			} else {
				sql.append("\n").append("and q_title = :q_title");
			}
		}
		if (searchvo.getQ_body() != null && searchvo.getQ_body() != "") {
			if ("like".equals(searchvo.getType())) {
				sql.append("\n").append("and q_body like '%").append(searchvo.getQ_body()).append("%'");
			} else {
				sql.append("\n").append("and q_body = :q_body");
			}
		}
		if (searchvo.getUid() != null && searchvo.getUid() != "") {
			sql.append("\n").append("and uid = :uid");
		}
		if (searchvo.getAnswer_yn() != null && searchvo.getAnswer_yn() != "") {
			sql.append("\n").append("and answer_yn = :answer_yn");
		}
		if (searchvo.getA_title() != null && searchvo.getA_title() != "") {
			if ("like".equals(searchvo.getType())) {
				sql.append("\n").append("and a_title like '%").append(searchvo.getA_title()).append("%'");
			} else {
				sql.append("\n").append("and a_title = :a_title");
			}
		}
		if (searchvo.getA_body() != null && searchvo.getA_body() != "") {
			if ("like".equals(searchvo.getType())) {
				sql.append("\n").append("and a_body like '%").append(searchvo.getA_body()).append("%'");
			} else {
				sql.append("\n").append("and a_body = :a_body");
			}
		}
		if (searchvo.getOrderby_key() != null && searchvo.getOrderby_key() != "") {
			sql.append("\n").append("order by ").append(searchvo.getOrderby_key());
			if (searchvo.getOrderby_rule() != null && searchvo.getOrderby_rule() != "") {
				sql.append(" ").append(searchvo.getOrderby_rule());
			}
		} else {
			sql.append("\n").append("order by mdfy_dt");
		}

		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(searchvo);

		RowMapper<searchVO> mapper = new BeanPropertyRowMapper<searchVO>(searchVO.class);
		return namedParameterJdbcTemplate.query(sql.toString(), paramSource, mapper);
	}

}
