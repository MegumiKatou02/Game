package model;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class Loading extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public Loading(CardLayout cardLayout, JPanel cardPanel, String flag) {
		setBounds(100, 100, 658, 492);
		setLayout(null);
		
		JLabel loadingScreen = new JLabel("");
		loadingScreen.setIcon(new ImageIcon(Loading.class.getResource("/image/background.jpg")));
		loadingScreen.setBounds(0, 0, 658, 492);
		add(loadingScreen);
		
		cardPanel.remove(loadingScreen);
		cardPanel.add(loadingScreen, "loading");
		
		JLabel loadingSign = new JLabel("Loading...");
		loadingScreen.add(loadingSign);
		loadingSign.setFont(new Font("Tahoma", Font.PLAIN, 24));
		loadingSign.setForeground(new Color(255, 255, 255));
		loadingSign.setBounds(508, 394, 140, 51);
		
		
		
		cardLayout.show(cardPanel, "loading");
		
		Timer timer = new Timer(2000, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        cardLayout.show(cardPanel, flag);
		    }
		});
		timer.setRepeats(false);
		timer.start();
	}
}
