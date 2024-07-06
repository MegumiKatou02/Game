package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controller.MenuStartGameController;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;

public class MenuStartGame extends JPanel {

    private static final long serialVersionUID = 1L;
    public CardLayout cardLayout;
    public JPanel cardPanel;

    public MenuStartGame() {
    	setLayout(null);
        setBounds(0, 0, 677, 492);
        
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.setBounds(0, 0, 677, 492);
        add(cardPanel);
        
        JPanel mainMenuPanel = new JPanel();
        mainMenuPanel.setLayout(null);
        
        JLabel bg = new JLabel();
        bg.setIcon(new ImageIcon(MenuStartGame.class.getResource("/image/background.jpg")));
        bg.setBounds(0, 0, 677, 492);
        
        JLabel titleGame1 = new JLabel("Arcane Worlds");
        titleGame1.setForeground(new Color(255, 255, 255));
        titleGame1.setFont(new Font("Britannic Bold", Font.PLAIN, 57));
        titleGame1.setHorizontalAlignment(SwingConstants.CENTER);
        titleGame1.setBounds(210, 50, 433, 94);
        bg.add(titleGame1);

        JButton startGameButton = new JButton("Start Game");
        startGameButton.setBackground(new Color(242, 242, 242));
        startGameButton.setFocusable(false);
        startGameButton.addActionListener(new MenuStartGameController(this));
        startGameButton.setFont(new Font("VNI-Hobo", Font.PLAIN, 18));
        startGameButton.setBounds(10, 116, 204, 57);
        bg.add(startGameButton);

        JButton settingGameButton = new JButton("Setting");
        settingGameButton.setBackground(new Color(242, 242, 242));
        settingGameButton.setFocusable(false);
        settingGameButton.setFont(new Font("VNI-Hobo", Font.PLAIN, 18));
        settingGameButton.setBounds(10, 198, 204, 57);
        bg.add(settingGameButton);

        JButton aboutGameButton = new JButton("About Game");
        aboutGameButton.setBackground(new Color(242, 242, 242));
        aboutGameButton.setFocusable(false);
        aboutGameButton.addActionListener(new ActionListener() {
        	
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "aboutGameView");
            }
        });
        aboutGameButton.setFont(new Font("VNI-Hobo", Font.PLAIN, 18));
        aboutGameButton.setBounds(10, 280, 204, 57);
        bg.add(aboutGameButton);

        JButton exitGameButton = new JButton("Exit");
        exitGameButton.setBackground(new Color(242, 242, 242));
        exitGameButton.setFocusable(false);
        exitGameButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
        exitGameButton.setFont(new Font("VNI-Hobo", Font.PLAIN, 18));
        exitGameButton.setBounds(10, 366, 204, 57);
        bg.add(exitGameButton);
        
        JLabel youtubeIcon = new JLabel("New label");
        youtubeIcon.setIcon(new ImageIcon(MenuStartGame.class.getResource("/image/youtube.png")));
        youtubeIcon.setBounds(10, 68, 32, 32);
        bg.add(youtubeIcon);
        
        JLabel facebookIcon = new JLabel("New label");
        facebookIcon.setIcon(new ImageIcon(MenuStartGame.class.getResource("/image/facebook.png")));
        facebookIcon.setBounds(53, 68, 32, 32);
        bg.add(facebookIcon);
        
        JLabel discordIcon = new JLabel("New label");
        discordIcon.setIcon(new ImageIcon(MenuStartGame.class.getResource("/image/discord_icon.jpg")));
        discordIcon.setBounds(97, 68, 32, 32);
        bg.add(discordIcon);
        
        mainMenuPanel.add(bg);
        
        // Thêm mainMenuPanel và các panel khác vào cardPanel
        cardPanel.add(mainMenuPanel, "mainMenu");
        
        JLabel titleGame2 = new JLabel("Etherite");
        titleGame2.setForeground(new Color(255, 255, 255));
        titleGame2.setHorizontalAlignment(SwingConstants.CENTER);
        titleGame2.setFont(new Font("Britannic Bold", Font.PLAIN, 53));
        titleGame2.setBounds(210, 166, 433, 94);
        bg.add(titleGame2);
        
        AboutGameView aboutGameView = new AboutGameView(cardLayout, cardPanel);
        cardPanel.add(aboutGameView, "aboutGameView");
        
        // Hiển thị mainMenuPanel mặc định
        cardLayout.show(cardPanel, "mainMenu");
    }
}
