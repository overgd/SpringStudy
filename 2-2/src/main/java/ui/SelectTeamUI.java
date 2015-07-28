package ui;

import java.util.List;

import dao.TeamDao;
import model.Team;

public class SelectTeamUI extends AbstractUI {

	private TeamDao teamDao;

	public TeamDao getTeamDao() {
		return teamDao;
	}

	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}

	@Override
	public void show() {

		showTeamList(this.teamDao.getTeamList());
		System.out.println("엔터를 누르시오.");
		getInputedString();
	}

	protected void showTeamList(List<Team> teamList) {
		System.out.println("-----------------------------------------");
		System.out.println("    ID       이름");
		for (Team team : teamList) {
			System.out.printf("%d %s \n", team.getId(), team.getName());
		}
	}
}
