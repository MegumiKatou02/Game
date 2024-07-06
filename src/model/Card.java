package model;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import model.entity.character.Character;
import model.entity.character.LiLy;
import model.entity.character.Mars;
import model.entity.character.Migami;
import view.ChooseCardNewBieView;

public class Card extends JLabel{
	
	private static final long serialVersionUID = 1L;
	private String nameCharcter;
	private int x, y, width, height;
	private Character character;
	
	public Card(String nameCharacter) {
		this.nameCharcter = nameCharacter;
		if(this.nameCharcter.equals("LiLy")) {
			character = new LiLy();
		}
		if(this.nameCharcter.equals("Mars")) {
			character = new Mars();
		}
		if(this.nameCharcter.equals("Migami")) {
			character = new Migami();
		}
		
		setBounds(0, 0, 677, 492);
	}
	
	public void MakeCard() {
		
	}
	
	public void MiniCard(JPanel panel, int x, int y) {
		// Frame
		JLabel frame = new JLabel();
		frame.setHorizontalAlignment(SwingConstants.CENTER);
		frame.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.setBounds(x, y, 150, 156);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
		frame.setBorder(border);
		
		panel.add(frame);
        // Name
        JLabel nameCard = new JLabel(character.getName());
        nameCard.setBackground(new Color(255, 255, 255));
        nameCard.setOpaque(true);
        nameCard.setHorizontalAlignment(SwingConstants.CENTER);
        nameCard.setFont(new Font("Tahoma", Font.PLAIN, 18));
        nameCard.setBorder(border);
        panel.add(nameCard);
        nameCard.setBounds(x, y, 150, 25);
        
        // Image
        JLabel imageCharacter = new JLabel();
        imageCharacter.setIcon(new ImageIcon(ChooseCardNewBieView.class.getResource("/image/ic.jpg")));
        imageCharacter.setHorizontalAlignment(SwingConstants.CENTER);
        imageCharacter.setFont(new Font("Tahoma", Font.PLAIN, 18));
        imageCharacter.setBounds(x, y + 25, 150, 100);
        panel.add(imageCharacter);
        
        JLabel index = new JLabel("");
        index.setFont(new Font("Tahoma", Font.PLAIN, 14));
        index.setBounds(x, y + 126, 150, 30);
        index.setBorder(border);
        index.setBackground(new Color(255, 255, 255));
        index.setOpaque(true);
        panel.add(index);
      
        JLabel HPIndex = new JLabel(character.getHP() + "");
        HPIndex.setFont(new Font("Tahoma", Font.PLAIN, 14));
        HPIndex.setBounds(10, 5, 64, 20);
        index.add(HPIndex);
      
        JLabel maxDamage = new JLabel(character.getRangeDamage().second + "");
        maxDamage.setHorizontalAlignment(SwingConstants.CENTER);
        maxDamage.setFont(new Font("Tahoma", Font.PLAIN, 14));
      	maxDamage.setBounds(80, 5, 64, 20);
      	index.add(maxDamage);
	}
}
