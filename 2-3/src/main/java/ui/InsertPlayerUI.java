package ui;

import org.apache.commons.lang3.StringUtils;

import dao.PlayerDao;
import dao.TeamDao;
import model.Player;
import model.Team;

public class InsertPlayerUI extends AbstractUI {

	private TeamDao teamDao;
	private PlayerDao playerDao;

	public TeamDao getTeamDao() {
		return teamDao;
	}

	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}

	public PlayerDao getPlayerDao() {
		return playerDao;
	}

	public void setPlayerDao(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}

	@Override
	public void show() {

		final String playerName = "선수이름";
		showMenu(playerName);
		String name = getInputedString();

		if (StringUtils.isEmpty(name)) {
			return;
		} else if (Utility.isSmallLength(name, playerName, 128)) {
			Player player = new Player();
			player.setName(name);
			showTeamField(player);
		} else {
			show();
		}
	}

	protected void showTeamField(Player player) {
		final String teamId = "팀번호";
		showMenu(teamId);
		String id = getInputedString();
		if (StringUtils.isEmpty(id)) {
			return;
		} else if (Utility.isNumeric(id, teamId)) {
			Team team = this.teamDao.getTeam(Integer.valueOf(id));
			if (team == null) { // 검색된 팀이 없으면
				System.out.printf("입력한 %s의 팀은 없습니다.\n", id);
				showTeamField(player); // 현재 메서드 재실행
			} else {
				player.setTeam(team);
				showPlayerId(player, team);
			}
		}
	}

	protected void showPlayerId(Player player, Team team) {

		final String playerId = "선수ID";
		showMenu(playerId);
		String id = getInputedString();
		if(StringUtils.isEmpty(id)) {
			return;
		}else if(Utility.isNumeric(id, playerId)) {
			player.setId(Integer.valueOf(id));
			playerDao.insertPlayer(player);
			System.out.printf("%s 팀에 %s 를 등록했습니다.", team.getName(), player.getName());
		}
		
	}

	protected void showMenu(String wanted) {
		System.out.println("-----------------------------------");
		System.out.println("");
		System.out.printf("%s을(를) 입력하고 엔터를 누르세요.\n", wanted);
		System.out.println("아무것도 입력하지 않고 엔터를 누르면,");
		System.out.println("메뉴로 돌아갑니다.");
	}

}
