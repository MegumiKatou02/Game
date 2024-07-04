package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AboutGameView extends JPanel {

	private static final long serialVersionUID = 1L;

	public AboutGameView(CardLayout cardLayout, JPanel cardPanel) {
		setBounds(100, 100, 658, 492);
		setLayout(null);
		
		JLabel programmerLabel = new JLabel("programmer:");
		programmerLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		programmerLabel.setHorizontalAlignment(SwingConstants.LEFT);
		programmerLabel.setBounds(71, 25, 198, 78);
		add(programmerLabel);
		
		JLabel leDinhChinh = new JLabel("Lê Đình Chinh");
		leDinhChinh.setHorizontalAlignment(SwingConstants.CENTER);
		leDinhChinh.setFont(new Font("Tahoma", Font.PLAIN, 22));
		leDinhChinh.setBounds(115, 114, 198, 39);
		add(leDinhChinh);
		
		JLabel artistLabel = new JLabel("Artist:");
		artistLabel.setHorizontalAlignment(SwingConstants.LEFT);
		artistLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		artistLabel.setBounds(71, 164, 198, 78);
		add(artistLabel);
		
		JLabel nguyenMinhThu = new JLabel("Nguyễn Minh Thư");
		nguyenMinhThu.setHorizontalAlignment(SwingConstants.CENTER);
		nguyenMinhThu.setFont(new Font("Tahoma", Font.PLAIN, 22));
		nguyenMinhThu.setBounds(115, 253, 198, 39);
		add(nguyenMinhThu);
		
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
