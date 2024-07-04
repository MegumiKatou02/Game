package run;


import model.entity.Entity;
import model.entity.Player;
import view.GameMainView;

public class Main {

	public static void main(String[] args) {
		Entity t = new Player();
		t.GetData();
		System.out.println(t);
		GameMainView mainView = new GameMainView();
		mainView.setVisible(true);
	}
}