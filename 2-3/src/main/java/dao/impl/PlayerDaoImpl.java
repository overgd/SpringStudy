package dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dao.PlayerDao;
import model.Player;

public class PlayerDaoImpl extends JdbcDaoSupport implements PlayerDao {

	private SimpleJdbcInsert insertPlayer;
	private DeletePlayer deletePlayer;
	private PlayerListQuery playerListQuery;
	private PlayerQuery playerQuery;
	private UpdatePlayer updateQuery;

	protected void initDao() throws Exception {

		this.insertPlayer = new SimpleJdbcInsert(getDataSource()).withTableName("player");

		this.deletePlayer = new DeletePlayer(getDataSource());
		this.playerQuery = new PlayerQuery(getDataSource());
		this.playerListQuery = new PlayerListQuery(getDataSource());
		this.updateQuery = new UpdatePlayer(getDataSource());

		this.deletePlayer = new DeletePlayer(getDataSource());
	};

	@Override
	public List<Player> getPlayerList(Integer teamId) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.playerListQuery.execute(teamId); //결과 여러개
	}

	@Override
	public Player getPlayer(Integer id) throws DataAccessException {
		return this.playerQuery.findObject(id); //결과 한개
	}

	@Override
	public void deletePlayer(Player player) throws DataAccessException {

		this.deletePlayer.update(player.getId()); //변경

	}

	@Override
	public void updatePlayer(Player player) throws DataAccessException {

		this.updateQuery.update(player.getName(), player.getTeam().getId(), player.getId());

	}

	@Override
	public void insertPlayer(Player player) throws DataAccessException {

		Map<String, Object> params = new HashMap<String, Object>();

		params.put("name", player.getName());
		params.put("team_id", player.getTeam().getId());
		params.put("player_id", player.getId());

		this.insertPlayer.execute(params);

	}

}
