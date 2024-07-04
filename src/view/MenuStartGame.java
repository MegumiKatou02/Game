package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class MenuStartGame extends JPanel {

    private static final long serialVersionUID = 1L;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public MenuStartGame() {
    	setLayout(null);
        setBounds(0, 0, 677, 492);
        
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.setBounds(0, 0, 677, 492);
        add(cardPanel);
        
        JPanel mainMenuPanel = new JPanel();
        mainMenuPanel.setLayout(null);
        
        JLabel titleGame = new JLabel("SlashBlood");
        titleGame.setFont(new Font("Tahoma", Font.PLAIN, 53));
        titleGame.setHorizontalAlignment(SwingConstants.CENTER);
        titleGame.setBounds(172, 11, 344, 94);
        mainMenuPanel.add(titleGame);

        JButton startGameButton = new JButton("Start Game");
        startGameButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        startGameButton.setBounds(241, 116, 204, 57);
        mainMenuPanel.add(startGameButton);

        JButton settingGameButton = new JButton("Setting");
        settingGameButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        settingGameButton.setBounds(241, 200, 204, 57);
        mainMenuPanel.add(settingGameButton);

        JButton aboutGameButton = new JButton("About Game");
        aboutGameButton.addActionListener(new ActionListener() {
        	
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "aboutGameView");
                System.out.println("Switched to About Game View");
            }
        });
        aboutGameButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        aboutGameButton.setBounds(241, 281, 204, 57);
        mainMenuPanel.add(aboutGameButton);

        JButton exitGameButton = new JButton("Exit");
        exitGameButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
        exitGameButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        exitGameButton.setBounds(241, 365, 204, 57);
        mainMenuPanel.add(exitGameButton);

        // Thêm mainMenuPanel và các panel khác vào cardPanel
        cardPanel.add(mainMenuPanel, "mainMenu");
        
        AboutGameView aboutGameView = new AboutGameView(cardLayout, cardPanel);
        cardPanel.add(aboutGameView, "aboutGameView");
        
        // Hiển thị mainMenuPanel mặc định
        cardLayout.show(cardPanel, "mainMenu");
    }
}
