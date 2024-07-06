package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import model.Loading;
import model.Player;
import model.entity.character.Character;
import view.GameInView;
import view.MenuStartGame;
import view.NewbieScreenView;

public class MenuStartGameController implements ActionListener
{
	private MenuStartGame menuStartGame;
	
	public MenuStartGameController(MenuStartGame menuStartGame) {
		this.menuStartGame = menuStartGame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Player player = new Player();
		System.out.println(player);
		
		GameInView gameIn = new GameInView(player, menuStartGame.cardLayout, menuStartGame.cardPanel);
		
		menuStartGame.cardPanel.add(gameIn, "gameIn");
		
		if(!player.getName().trim().equals("NULL")){
			new Loading(menuStartGame.cardLayout, menuStartGame.cardPanel, "gameIn");
//			menuStartGame.cardLayout.show(menuStartGame.cardPanel, "gameIn");
		}
		else {
			JPanel newbie = new NewbieScreenView(menuStartGame.cardLayout, menuStartGame.cardPanel, gameIn);
			menuStartGame.cardPanel.add(newbie, "newbie");
			menuStartGame.cardLayout.show(menuStartGame.cardPanel, "newbie");
		}
	}
}