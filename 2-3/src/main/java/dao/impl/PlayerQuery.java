package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import model.Player;
import model.Team;

public class PlayerQuery extends MappingSqlQuery<Player> {

	private static String SQL_PLAYER_QUERY = "select player.player_id, player.name as playerName, team.team_id, team.name as teamName from player, team where player.team_id = team.team_id and player_id = ?";

	public PlayerQuery(DataSource ds) {
		super(ds, SQL_PLAYER_QUERY);
		super.declareParameter(new SqlParameter("player_id", Types.INTEGER));
		compile();
	}

	@Override
	protected Player mapRow(ResultSet arg0, int arg1) throws SQLException {

		Player player = new Player();
		player.setId(arg0.getInt("player_id"));
		player.setName(arg0.getString("playerName"));

		Team team = new Team();
		team.setId(arg0.getInt("team_id"));
		team.setName(arg0.getString("teamName"));
		player.setTeam(team);
		
		return player;
	}

}
