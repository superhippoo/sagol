package com.sagol.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sagol.dto.requestVO;
import com.sagol.dto.searchVO;

@Repository
public class requestDaoImple implements requestDao {

//	@Autowired
//	private JdbcTemplate jdbdtemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate; 

	@Override
	public List<requestVO> selectRequestList(requestVO requestvo) {

//		String q = "select * from sg_request";
//		return jdbdtemplate.query(q, new BeanPropertyRowMapper<requestVO>(requestVO.class));
		StringBuffer sql = new StringBuffer();

		sql.append("\n").append("select ");
		sql.append("\n").append("* ");
		sql.append("\n").append("from sg_request ");
		
		if (requestvo.getOrderby_key() != null && requestvo.getOrderby_key() != "") {
			sql.append("\n").append("order by ").append(requestvo.getOrderby_key());
			if (requestvo.getOrderby_rule() != null && requestvo.getOrderby_rule() != "") {
				sql.append(" ").append(requestvo.getOrderby_rule());
			}
		} else {
			sql.append("\n").append("order by mdfy_dt");
		}

		RowMapper<requestVO> mapper = new BeanPropertyRowMapper<requestVO>(requestVO.class);
		return namedParameterJdbcTemplate.query(sql.toString(), mapper);

	}

	@Override
	public List<requestVO> selectRequestListByUid(requestVO requestvo) {
//		String q = "select * from sg_request " 
//				+ "where uid = ?" ;
//		Object[] args = { requestvo.getUid()};
//		return jdbdtemplate.query(q, args, new BeanPropertyRowMapper<requestVO>(requestVO.class));
		StringBuffer sql = new StringBuffer();
		
		sql.append("\n").append("select ");
		sql.append("\n").append("* ");
		sql.append("\n").append("from sg_request ");
		sql.append("\n").append("where uid = :uid");
		
		if (requestvo.getOrderby_key() != null && requestvo.getOrderby_key() != "") {
			sql.append("\n").append("order by ").append(requestvo.getOrderby_key());
			if (requestvo.getOrderby_rule() != null && requestvo.getOrderby_rule() != "") {
				sql.append(" ").append(requestvo.getOrderby_rule());
			}
		} else {
			sql.append("\n").append("order by mdfy_dt");
		}
		
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(requestvo);

		RowMapper<requestVO> mapper = new BeanPropertyRowMapper<requestVO>(requestVO.class);
		return namedParameterJdbcTemplate.query(sql.toString(),paramSource, mapper);
	}
	
	@Override
	public List<requestVO> selectRequestListByCompleteYn(requestVO requestvo) {
//		String q = "select * from sg_request " 
//				+ "where complete_yn = ?" ;
//		Object[] args = { requestvo.getComplete_yn()};
//		return jdbdtemplate.query(q, args, new BeanPropertyRowMapper<requestVO>(requestVO.class));
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("\n").append("select ");
		sql.append("\n").append("* ");
		sql.append("\n").append("from sg_request ");
		sql.append("\n").append("where complete_yn = :complete_yn");
		
		if (requestvo.getOrderby_key() != null && requestvo.getOrderby_key() != "") {
			sql.append("\n").append("order by ").append(requestvo.getOrderby_key());
			if (requestvo.getOrderby_rule() != null && requestvo.getOrderby_rule() != "") {
				sql.append(" ").append(requestvo.getOrderby_rule());
			}
		} else {
			sql.append("\n").append("order by mdfy_dt");
		}
		
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(requestvo);

		RowMapper<requestVO> mapper = new BeanPropertyRowMapper<requestVO>(requestVO.class);
		return namedParameterJdbcTemplate.query(sql.toString(),paramSource, mapper);
	}
	
	@Override
	public List<requestVO> selectRequestListByReqCd(requestVO requestvo) {
//		String q = "select * from sg_request " 
//				+ "where req_cd = ?" ;
//		Object[] args = { requestvo.getReq_cd()};
//		return jdbdtemplate.query(q, args, new BeanPropertyRowMapper<requestVO>(requestVO.class));
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("\n").append("select ");
		sql.append("\n").append("* ");
		sql.append("\n").append("from sg_request ");
		sql.append("\n").append("where req_cd = :req_cd");
		
		if (requestvo.getOrderby_key() != null && requestvo.getOrderby_key() != "") {
			sql.append("\n").append("order by ").append(requestvo.getOrderby_key());
			if (requestvo.getOrderby_rule() != null && requestvo.getOrderby_rule() != "") {
				sql.append(" ").append(requestvo.getOrderby_rule());
			}
		} else {
			sql.append("\n").append("order by mdfy_dt");
		}
		
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(requestvo);

		RowMapper<requestVO> mapper = new BeanPropertyRowMapper<requestVO>(requestVO.class);
		return namedParameterJdbcTemplate.query(sql.toString(),paramSource, mapper);
	}
	

	@Override
	public requestVO selectRequest(requestVO requestvo) {
//		String q = "select * from sg_request where req_id = ? " ;
//		Object[] args = { requestvo.getReq_id()};
//		try {
//			return jdbdtemplate.queryForObject(q, args, new BeanPropertyRowMapper<requestVO>(requestVO.class));
//		} catch (Exception e) {
//			return null;
//		}
		StringBuffer sql = new StringBuffer();
		
		sql.append("\n").append("select ");
		sql.append("\n").append("* ");
		sql.append("\n").append("from sg_request");
		sql.append("\n").append("where req_id = :req_id");

		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(requestvo);
		RowMapper<requestVO> mapper = new BeanPropertyRowMapper<requestVO>(requestVO.class);
		try {
			return namedParameterJdbcTemplate.queryForObject(sql.toString(), paramSource, mapper);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int insertRequest(requestVO requestvo) {
//		String q = "  INSERT INTO sg_request VALUES(?,?,?,?,?,?,?,?)";
//		Object[] args = { requestvo.getReq_id(),requestvo.getReq_cd(), requestvo.getTitle(), requestvo.getBody(), requestvo.getUid(),
//				requestvo.getComplete_yn(), requestvo.getReg_dt(), requestvo.getMdfy_dt() };
//		return jdbdtemplate.update(q, args);
		StringBuffer sql = new StringBuffer();
		
		sql.append("\n").append("INSERT INTO sg_request ");
		sql.append("\n").append("(req_id,req_cd,title,body,uid,complete_yn,reg_dt,mdfy_dt");
		sql.append("\n").append(") ");
		sql.append("\n").append("VALUES (:req_id,:req_cd,:title,:body,:uid,:complete_yn,:reg_dt,:mdfy_dt");
		sql.append("\n").append(")");
		
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(requestvo);
		
		return namedParameterJdbcTemplate.update(sql.toString(), paramSource);
	}

	@Override
	public int updateRequest(requestVO requestvo) {
//		String q = "update sg_request set "
//				+ "req_cd = ?  ,"
//				+ "title = ?  ," 
//				+ "body = ?  ," 
//				+ "complete_yn = ?  ,"
//				+ "mdfy_dt = ?  "
//			    + "where req_id = ?";
//		Object[] args = {requestvo.getReq_cd(),requestvo.getTitle(),requestvo.getBody(),requestvo.getComplete_yn(),requestvo.getMdfy_dt(),requestvo.getReq_id()};
//		return jdbdtemplate.update(q, args);
		StringBuffer sql = new StringBuffer();

		sql.append("\n").append("update sg_request set ");
		sql.append("\n").append("req_cd = :req_cd , ");
		sql.append("\n").append("title = :title , ");
		sql.append("\n").append("body = :body , ");
		sql.append("\n").append("complete_yn = :complete_yn, ");
		sql.append("\n").append("mdfy_dt = :mdfy_dt");
		sql.append("\n").append("where req_id = :req_id");
		
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(requestvo);
		
		return namedParameterJdbcTemplate.update(sql.toString(), paramSource);
	}

	@Override
	public int deleteRequest(requestVO requestvo) {
//		String q = "delete from sg_request where req_id = ?" ;
//		Object[] args = {requestvo.getReq_id()};
//		return jdbdtemplate.update(q,args);
		
		StringBuffer sql = new StringBuffer();

		sql.append("\n").append("delete from sg_request ");
		sql.append("\n").append("where req_id = :req_id");

		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(requestvo);

		return namedParameterJdbcTemplate.update(sql.toString(), paramSource);
	}

	@Override
	public int isExistByReqId(requestVO requestvo) {
//		String q = "select count(*) from sg_request where req_id = ?";
//		Object[] args = { requestvo.getReq_id() };
//		try {
//			return jdbdtemplate.queryForObject(q, args, Integer.class);
//		} catch (Exception e) {
//			return 0;
//		}
		StringBuffer sql = new StringBuffer();
		
		sql.append("\n").append("select ");
		sql.append("\n").append("count(*) ");
		sql.append("\n").append("from sg_request");
		sql.append("\n").append("where req_id = :req_id");

		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(requestvo);

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
		sql.append("\n").append("from sg_request");
		sql.append("\n").append("where 1=1");

		if (searchvo.getReq_id() != null && searchvo.getReq_id() != "") {
			sql.append("\n").append("and req_id = :req_id");			
		}
		if (searchvo.getReq_cd() != null && searchvo.getReq_cd() != "") {
			sql.append("\n").append("and req_cd = :req_cd");
		}
		if (searchvo.getTitle() != null && searchvo.getTitle() != "") {
			if ("like".equals(searchvo.getType())) {
				sql.append("\n").append("and title like '%").append(searchvo.getTitle()).append("%'");
			} else {
				sql.append("\n").append("and title = :title");
			}
		}
		if (searchvo.getBody() != null && searchvo.getBody() != "") {
			if ("like".equals(searchvo.getType())) {
				sql.append("\n").append("and body like '%").append(searchvo.getBody()).append("%'");
			} else {
				sql.append("\n").append("and body = :body");
			}		}
		if (searchvo.getUid() != null && searchvo.getUid() != "") {
			sql.append("\n").append("and uid = :uid");
		}
		if (searchvo.getComplete_yn() != null && searchvo.getComplete_yn() != "") {
			sql.append("\n").append("and complete_yn = :complete_yn");
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
