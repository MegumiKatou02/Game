package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import model.Loading;
import model.Player;
import model.entity.character.Character;

public class NewbieScreenView extends JPanel {

	private static final long serialVersionUID = 1L;

	public NewbieScreenView(CardLayout cardLayout, JPanel cardPanel, GameInView gameIn) {
		setBounds(100, 100, 658, 492);
		setLayout(null);

		JLabel labelT = new JLabel("");
		labelT.setFont(new Font("Tahoma", Font.PLAIN, 19));
		labelT.setHorizontalAlignment(SwingConstants.CENTER);
		labelT.setBounds(21, 69, 627, 61);
		add(labelT);
		
		JLabel nameLabel = new JLabel("");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		nameLabel.setBounds(21, 129, 627, 69);
		add(nameLabel);
		
		JLabel error = new JLabel("");
		error.setForeground(Color.white);
		error.setHorizontalAlignment(SwingConstants.CENTER);
		error.setFont(new Font("Tahoma", Font.PLAIN, 18));
		error.setBounds(255, 280, 180, 33);
		add(error);
		
		JButton backButton = new JButton("<");
		backButton.setBounds(598, 399, 50, 32);
		add(backButton);
		
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "mainMenu");
			}
		});
		
		setBackground(Color.black);
		labelT.setForeground(Color.white);
		nameLabel.setForeground(Color.white);
		String message = "Xin chào, tôi biết bạn là người mới";
		String message1 = "Xin hãy cho tôi biết tên của bạn ...?";
		
		JTextField inputName = new JTextField();
		inputName.setVisible(false);
		inputName.setFocusable(false);
		
		// original: 100
        typeWriter(labelT, message, 30, () -> {
        	typeWriter(nameLabel, message1, 30, ()->{
        		inputName.setVisible(true);
        		inputName.setFocusable(true);
        		inputName.requestFocus(); 
        	});
        });
        
        inputName.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				if(code == KeyEvent.VK_ENTER) {
					if(inputName.getText().trim().isEmpty()) {
						error.setBackground(Color.white);
						error.setForeground(Color.red);
						error.setText("Nhập không hợp lệ");
					}
					else {
						cardPanel.remove(gameIn);
						Player player = new Player();
						player.setName(inputName.getText());
						
//						cardPanel.add(new GameInView(player,cardLayout, cardPanel), "gameIn");
						gameIn.getPlayer().setName(inputName.getText());
						
						cardPanel.add(new ChooseCardNewBieView(cardLayout, cardPanel), "chooseNewBie");
						
						new Loading(cardLayout, cardPanel, "chooseNewBie"); // loading then show
//						cardLayout.show(cardPanel, "gameIn");
						
						cardPanel.revalidate();
		                cardPanel.repaint();
					}
				}
			}
		});
        inputName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		inputName.setBounds(282, 240, 113, 33);
		add(inputName);
		inputName.setColumns(10);
	}
	
	public void typeWriter(JLabel label, String message, int delay, Runnable onComplete) {
	    Timer timer = new Timer(delay, null);
	    timer.setInitialDelay(0);  // Khởi động ngay lập tức

	    timer.addActionListener(e -> {
	        if (label.getText().length() < message.length()) {
	            // Thêm một ký tự từ message vào label
	            label.setText(message.substring(0, label.getText().length() + 1));
	        } else {
	            // Kết thúc Timer khi đã hiện đủ nội dung
	            timer.stop();
	            if (onComplete != null) {
	                onComplete.run(); // Thực hiện hành động tiếp theo
	            }
	        }
	    });

	    timer.start();
	}

}