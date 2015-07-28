package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dao.TeamDao;
import model.Team;

public class TeamDaoImpl extends JdbcDaoSupport implements TeamDao {

	@Override
	public List<Team> getTeamList() throws DataAccessException {

		RowMapper<Team> rowMapper = new TeamRowMapper();

		return getJdbcTemplate().query("select team_id, name from team", rowMapper);
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
