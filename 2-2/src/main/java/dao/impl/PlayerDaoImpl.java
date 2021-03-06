package dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dao.PlayerDao;
import model.Player;

public class PlayerDaoImpl extends JdbcDaoSupport implements PlayerDao {

	private SimpleJdbcInsert insertPlayer;
	protected void initDao() throws Exception {
		
		this.insertPlayer = new SimpleJdbcInsert(getDataSource()).withTableName("player");
		
	}; 
	
	@Override
	public void insertPlayer(Player player) throws DataAccessException {

		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("name", player.getName());
		params.put("team_id", player.getTeam().getId());
		params.put("player_id", player.getId());
		
		this.insertPlayer.execute(params);
		
	}

}
