package ui;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import dao.PlayerDao;
import dao.impl.UpdatePlayer;
import model.Player;
import model.Team;

public class SelectPlayerUI extends AbstractUITemplate {

	private PlayerDao playerDao;
	private DeletePlayerUI deletePlayerUi;
	private UpdatePlayerUI updatePlayerUi;

	public UpdatePlayerUI getUpdatePlayerUi() {
		return updatePlayerUi;
	}

	public void setUpdatePlayerUi(UpdatePlayerUI updatePlayerUi) {
		this.updatePlayerUi = updatePlayerUi;
	}

	public PlayerDao getPlayerDao() {
		return playerDao;
	}

	public void setPlayerDao(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}

	public DeletePlayerUI getDeletePlayerUi() {
		return deletePlayerUi;
	}

	public void setDeletePlayerUi(DeletePlayerUI deletePlayerUi) {
		this.deletePlayerUi = deletePlayerUi;
	}

	@Override
	protected void showMenu() {

		System.out.println("----------------------------------");
		System.out.println("");
		System.out.println("1. 선수 갱신");
		System.out.println("2. 선수 삭제");
		System.out.println("3. 메뉴로 돌아가기");
		System.out.println("");
		System.out.println("번호를 입력하고 엔터를 누르세요.");

	}

	@Override
	protected int getMaxMenuNumber() {

		return 3;
	}

	@Override
	protected int getMinMenuNumber() {

		return 1;
	}

	@Override
	protected void execute(int number) {

		switch (number) {
		case 1:
			updatePlayerUi.show();
			break;

		case 2:
			deletePlayerUi.show();
			break;

		default:
			return;
		}
	}

	protected Integer getTeamId() {

		System.out.println("팀의 ID를 입력하고, 엔터를 누르세요.");

		String teamId = getInputedString();

		if (StringUtils.isNotEmpty(teamId) && StringUtils.isNumeric(teamId)) {

			return Integer.valueOf(teamId);
		}
		return getTeamId();
	}

	protected void showPlayerList(List<Player> playerList) {

		System.out.println("------------------------------------------");
		if (playerList.isEmpty()) {
			Player player = playerList.get(0);
			System.out.printf("팀이름 : " + player.getTeam().getName());
		}
		for (Player player : playerList) {// 선수번호, 선수이름 출력
			System.out.printf("%d %s \n", player.getId(), player.getName());
		}
	}

	public void show() {
		Integer teamId = getTeamId();
		showPlayerList(this.playerDao.getPlayerList(teamId));
		System.out.println("엔터키를 누르시오");
		getInputedString();
		super.show();
	}

}
