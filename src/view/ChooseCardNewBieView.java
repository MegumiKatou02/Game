package view;

import java.awt.CardLayout;

import javax.swing.JPanel;

import model.Card;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;

public class ChooseCardNewBieView extends JPanel {

	private static final long serialVersionUID = 1L;

	public ChooseCardNewBieView(CardLayout cardLayout, JPanel cardPanel) {
        setBounds(0, 0, 677, 492);
        setLayout(null);
        
        Card lilyCard = new Card("LiLy");
        lilyCard.MiniCard(this, 69, 100);
        add(lilyCard);
        
        Card mars = new Card("Mars");
        mars.MiniCard(this, 250, 100);
        add(mars);
        
        Card Migami = new Card("Migami");
        Migami.MiniCard(this, 431, 100);
        add(Migami);
        
        JButton lilyButton = new JButton("LiLy");
        lilyButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
        lilyButton.setBounds(91, 329, 107, 30);
        add(lilyButton);
        
        JButton marsButton = new JButton("Mars");
        marsButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
        marsButton.setBounds(272, 329, 107, 30);
        add(marsButton);
        
        JButton migamiButton = new JButton("Migami");
        migamiButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
        migamiButton.setBounds(453, 329, 107, 30);
        add(migamiButton);
        
        JLabel titleToChoose = new JLabel("Chọn nhân vật khởi đầu");
        titleToChoose.setFont(new Font("Tahoma", Font.PLAIN, 21));
        titleToChoose.setHorizontalAlignment(SwingConstants.CENTER);
        titleToChoose.setBounds(91, 27, 469, 49);
        add(titleToChoose);
        
        JButton backButton = new JButton("<");
		backButton.setBounds(598, 399, 50, 32);
		add(backButton);
		
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "mainMenu");
			}
		});
        
	}
}