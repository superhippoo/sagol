package com.sagol.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sagol.dto.scheduleVO;
import com.sagol.dto.searchVO;

@Repository
public class scheduleDaoImple implements scheduleDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate; 


	@Override
	public List<scheduleVO> selectScheduleList(scheduleVO schedulevo) {
	    StringBuffer sql = new StringBuffer();
		
		sql.append("\n").append("select ");
		sql.append("\n").append("* ");
		sql.append("\n").append("from sg_schedule ");
		if (schedulevo.getOrderby_key() != null && schedulevo.getOrderby_key() != "") {
			sql.append("\n").append("order by ").append(schedulevo.getOrderby_key());	
			if (schedulevo.getOrderby_rule() != null && schedulevo.getOrderby_rule() != "") {
				sql.append(" ").append(schedulevo.getOrderby_rule());	
			}
		}else {
			sql.append("\n").append("order by mdfy_dt");
		}
		
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(schedulevo);

		RowMapper<scheduleVO> mapper = new BeanPropertyRowMapper<scheduleVO>(scheduleVO.class);
		return namedParameterJdbcTemplate.query(sql.toString(),paramSource, mapper);
	}


	@Override
	public List<scheduleVO> selectScheduleListByClubId(scheduleVO schedulevo) {
		StringBuffer sql = new StringBuffer();
		
		sql.append("\n").append("select ");
		sql.append("\n").append("* ");
		sql.append("\n").append("from sg_schedule ");
		sql.append("\n").append("where club_id = :club_id");
		if (schedulevo.getOrderby_key() != null && schedulevo.getOrderby_key() != "") {
			sql.append("\n").append("order by ").append(schedulevo.getOrderby_key());	
			if (schedulevo.getOrderby_rule() != null && schedulevo.getOrderby_rule() != "") {
				sql.append(" ").append(schedulevo.getOrderby_rule());	
			}
		}else {
			sql.append("\n").append("order by mdfy_dt");
		}
		
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(schedulevo);

		RowMapper<scheduleVO> mapper = new BeanPropertyRowMapper<scheduleVO>(scheduleVO.class);
		return namedParameterJdbcTemplate.query(sql.toString(),paramSource, mapper);
	}


	@Override
	public scheduleVO selectSchedule(scheduleVO schedulevo) {
		StringBuffer sql = new StringBuffer();
		
		sql.append("\n").append("select ");
		sql.append("\n").append("* ");
		sql.append("\n").append("from sg_schedule");
		sql.append("\n").append("where schedule_id = :schedule_id ");
		sql.append("\n").append("and club_id = :club_id ");

		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(schedulevo);
		RowMapper<scheduleVO> mapper = new BeanPropertyRowMapper<scheduleVO>(scheduleVO.class);
		try {
			return namedParameterJdbcTemplate.queryForObject(sql.toString(), paramSource, mapper);
		} catch (Exception e) {
			return null;
		}
	}


	@Override
	public List<scheduleVO> selectScheduleListByClubIdList(List<String> list) {
		StringBuffer sql = new StringBuffer();
		
		sql.append("\n").append("select ");
		sql.append("\n").append("* ");
		sql.append("\n").append("from sg_schedule ");
		sql.append("\n").append("where club_id in (:list)");
	    sql.append("\n").append("order by mdfy_dt");
	    
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("list",list);
		RowMapper<scheduleVO> mapper = new BeanPropertyRowMapper<scheduleVO>(scheduleVO.class);
		return namedParameterJdbcTemplate.query(sql.toString(),param, mapper);
	}


	@Override
	public int insertSchedule(scheduleVO shedulevo) {
		StringBuffer sql = new StringBuffer();
		
		sql.append("\n").append("INSERT INTO sg_schedule ");
		sql.append("\n").append("(schedule_id,club_id,description,act_dt,reg_dt,mdfy_dt");
		sql.append("\n").append(") ");
		sql.append("\n").append("VALUES (:schedule_id,:club_id,:description,:act_dt,:reg_dt,:mdfy_dt");
		sql.append("\n").append(")");
		
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(shedulevo);
		
		return namedParameterJdbcTemplate.update(sql.toString(), paramSource);
	}


	@Override
	public int updateSchedule(scheduleVO shedulevo) {
		StringBuffer sql = new StringBuffer();

		sql.append("\n").append("update sg_schedule set ");
		sql.append("\n").append("description = :description , ");
		sql.append("\n").append("act_dt = :act_dt , ");
		sql.append("\n").append("mdfy_dt = :mdfy_dt");
		sql.append("\n").append("where schedule_id = :schedule_id");
		sql.append("\n").append("and club_id = :club_id");

		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(shedulevo);
		
		return namedParameterJdbcTemplate.update(sql.toString(), paramSource);
	}


	@Override
	public int deleteSchedule(scheduleVO schedulevo) {
		StringBuffer sql = new StringBuffer();

		sql.append("\n").append("delete from sg_schedule ");
		sql.append("\n").append("where schedule_id = :schedule_id");
		sql.append("\n").append("and club_id = :club_id");
		
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(schedulevo);

		return namedParameterJdbcTemplate.update(sql.toString(), paramSource);
	}


	@Override
	public int isExistByScheduleId(scheduleVO shedulevo) {
		StringBuffer sql = new StringBuffer();
		
		sql.append("\n").append("select ");
		sql.append("\n").append("count(*) ");
		sql.append("\n").append("from sg_schedule");
		sql.append("\n").append("where schedule_id = :schedule_id");

		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(shedulevo);

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
		sql.append("\n").append("from sg_schedule");
		sql.append("\n").append("where 1=1");

		if (searchvo.getClub_id() !=null && searchvo.getClub_id() != "") {
			sql.append("\n").append("and club_id = :club_id");
		}
		
		if (searchvo.getAct_dt() !=null) {
			sql.append("\n").append("and act_dt = :act_dt");
		}
		if (searchvo.getDescription() !=null && searchvo.getDescription() != "") {
			if ("like".equals(searchvo.getType())) {
				sql.append("\n").append("and description like '%").append(searchvo.getDescription()).append("%'");
			} else {
				sql.append("\n").append("and description = :description");
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


	@Override
	public int deleteScheduleByClubId(scheduleVO schedulevo) {
		StringBuffer sql = new StringBuffer();

		sql.append("\n").append("delete from sg_schedule ");
		sql.append("\n").append("where club_id = :club_id");
		
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(schedulevo);

		return namedParameterJdbcTemplate.update(sql.toString(), paramSource);
	}

}
