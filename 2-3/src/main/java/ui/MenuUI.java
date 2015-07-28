package ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MenuUI extends AbstractUITemplate {

	private SelectTeamUI selectTeamUi;
	private InsertPlayerUI insertPlayerUi;
	private SelectPlayerUI selectPlayerUi;

	public void setSelectPlayerUi(SelectPlayerUI selectPlayerUi) {
		this.selectPlayerUi = selectPlayerUi;
	}

	public void setInsertPlayerUi(InsertPlayerUI insertPlayerUi) {
		this.insertPlayerUi = insertPlayerUi;
	}

	public void setSelectTeamUi(SelectTeamUI selectTeamUi) {
		this.selectTeamUi = selectTeamUi;
	}

	protected void showMenu() {

		System.out.println("-------------------------------------");
		System.out.println("");
		System.out.println("1. 종료");
		System.out.println("2. 팀 목록");
		System.out.println("3. 선수 추가");
		System.out.println("4. 선수 목록");

		System.out.println("번호를 입력 후 엔터키를 누르시오.");

	}

	protected int getMaxMenuNumber() {
		return 4;
	}

	protected int getMinMenuNumber() {
		return 1;
	}

	protected void execute(int number) {

		switch (number) {
		case 1:
			System.out.println("종료되었습니다.");
			System.exit(0);
			break;

		case 2:
			this.selectTeamUi.show();
			break;

		case 3:
			this.insertPlayerUi.show();
			break;

		case 4:
			this.selectPlayerUi.show();
			break;

		default:
			break;
		}
	}

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		MenuUI menuUi = (MenuUI) ctx.getBean("menuUi");

		while (true) {

			menuUi.show();
		}

	}

}
