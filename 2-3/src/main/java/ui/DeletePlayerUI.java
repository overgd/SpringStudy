package ui;

import org.apache.commons.lang3.StringUtils;

import dao.PlayerDao;
import model.Player;

public class DeletePlayerUI extends AbstractUI {

	private PlayerDao playerDao;

	public PlayerDao getPlayerDao() {
		return playerDao;
	}

	public void setPlayerDao(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}

	protected void showMenu() {
		System.out.println("--------------------------------");
		System.out.println("");
		System.out.println("선수ID를 입력하고, 엔터를 누르세요");
		System.out.println("아무것도 입력하지 않고 엔터를 누르면, ");
		System.out.println("메뉴로 돌아갑니다.");
	}

	@Override
	public void show() {
		showMenu();
		String id = getInputedString();
		if (StringUtils.isEmpty(id)) {
			return;
		} else if (Utility.isNumeric(id, "선수ID")) {
			Player player = this.playerDao.getPlayer(Integer.valueOf(id));
			if (player == null) {
				System.out.printf("입력한 %s번호의 선수는 없습니다.", id);
				show();
			} else {
				this.playerDao.deletePlayer(player);
				System.out.printf("입력한 %s번호의 선수가 삭제되었습니다.", id);
			}

		} else {
			show();
		}
	}

}
