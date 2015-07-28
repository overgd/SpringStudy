package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import dao.TeamDao;
import dao.impl.TeamDaoImpl.TeamRowMapper;
import model.Team;

public class TeamDaoImpl extends NamedParameterJdbcDaoSupport implements TeamDao { // 조건
																					// 검색이기
																					// 때문에
																					// NamedParameterJdbcDaoSupport
																					// 이다.

	@Override
	public List<Team> getTeamList() throws DataAccessException {

		RowMapper<Team> rowMapper = new TeamRowMapper();

		return getJdbcTemplate().query("select team_id, name from team", rowMapper);
	}

	@Override
	public Team getTeam(Integer teamId) throws DataAccessException { // 특정팀만
																			// 검색하는
																			// 메서드
		final String sql = "select team_id, name from team where team_id = :teamId";
		SqlParameterSource paramSrc = new MapSqlParameterSource("teamId", teamId);
		return getNamedParameterJdbcTemplate().query(sql, paramSrc, new TeamResultSetExtractor());

	}

	protected class TeamResultSetExtractor implements ResultSetExtractor<Team> {

		@Override
		public Team extractData(ResultSet arg0) throws SQLException, DataAccessException {

			if (arg0.next()) { // 검색 결과가 있는 경우

				Team team = new Team();
				team.setId(arg0.getInt("team_id"));
				team.setName(arg0.getString("name"));
				return team;
				
			} else {
				return null;
			}
		}

	}

	protected class TeamRowMapper implements RowMapper<Team> {

		@Override
		public Team mapRow(ResultSet arg0, int arg1) throws SQLException {

			Team team = new Team();
			team.setId(arg0.getInt("team_id"));
			team.setName(arg0.getString("name"));

			return team;
		}

	}

}
