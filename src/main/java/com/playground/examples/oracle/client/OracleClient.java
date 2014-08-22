package com.playground.examples.oracle.client;

import java.sql.Types;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class OracleClient {

	private final static String getScheduleEventByCridAndImiSql = "? ? ?";

	private JdbcTemplate jdbcTemplate;

	/**
	 * Default constructor
	 */
	public OracleClient() {
	}

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Map<String, Object> getScheduleEventByCridAndImi(final String crid, final String imi, final String country) {
		final String[] args = new String[] {crid, imi, country};
		final int[] argTypes = new int[] {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
		return jdbcTemplate.queryForMap(getScheduleEventByCridAndImiSql, args, argTypes);
	}

	public List<Map<String, Object>> getVersion() {
		final String sql = "SELECT * FROM V$VERSION";
		return jdbcTemplate.queryForList(sql);
	}
}
