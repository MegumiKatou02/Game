package view;

import javax.swing.JPanel;

import model.Player;
import model.entity.character.Character;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.Color;

public class GameInView extends JPanel{

	private static final long serialVersionUID = 1L;
	private Player player;
	private CardLayout cardLayout;
	private JPanel cardPanel;
	
	public Player getPlayer() {
		return player;
	}
	
	public GameInView(Player player, CardLayout cardLayout, JPanel cardPanel) {
		this.player = player;
		setBounds(100, 100, 658, 492);
		
		JLabel mainLabel = new JLabel();
		mainLabel.setBounds(0, -37, 658, 529);
		mainLabel.setIcon(new ImageIcon(GameInView.class.getResource("/image/cutting.png")));
		setBounds(100, 100, 658, 492);
		setLayout(null);
		
		JLabel name = new JLabel(player.getName());
		name.setForeground(new Color(255, 0, 0));
		name.setFont(new Font("Tahoma", Font.PLAIN, 18));
		name.setBounds(82, 0, 167, 34);
		add(name);
		
		JButton avatar = new JButton("");
		avatar.setIcon(new ImageIcon(GameInView.class.getResource("/image/t.jpg")));
		avatar.setBounds(0, 0, 72, 64);
		add(avatar);
		
//		JLabel skin = new JLabel("New label");
//		skin.setIcon(new ImageIcon(GameInView.class.getResource("/image/skin/skin.png")));
//		skin.setBounds(81, 238, 95, 164);
//		add(skin);
		
//		JLabel choiceBoard = new JLabel("");
//		choiceBoard.setIcon(new ImageIcon(GameInView.class.getResource("/image/white.png")));
//		choiceBoard.setBounds(466 - 55, 116, 180 + 55, 340);
//		mainLabel.add(choiceBoard);
		
//		JLabel lblNewLabel = new JLabel("New label");
//		lblNewLabel.setBounds(125, 74, 225, 330);
//		add(lblNewLabel);
		
		add(mainLabel);
	}
}