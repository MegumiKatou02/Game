package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;

public class AboutGameView extends JPanel {

	private static final long serialVersionUID = 1L;

	public AboutGameView(CardLayout cardLayout, JPanel cardPanel) {
		setBounds(100, 100, 658, 492);
		setLayout(null);
		
		JLabel bg = new JLabel();
		bg.setIcon(new ImageIcon(AboutGameView.class.getResource("/image/bg1.png")));
		bg.setBounds(0, -35, 658, 492);
		
		
		JLabel thankLabel = new JLabel("Sản phẩm của Esdeath Studio");
		thankLabel.setForeground(new Color(255, 255, 255));
		thankLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		thankLabel.setHorizontalAlignment(SwingConstants.LEFT);
		thankLabel.setBounds(173, 28, 306, 43);
		add(thankLabel);
//		
//		JLabel leDinhChinh = new JLabel("Lê Đình Chinh (Megumi)");
//		leDinhChinh.setHorizontalAlignment(SwingConstants.LEFT);
//		leDinhChinh.setFont(new Font("Tahoma", Font.PLAIN, 22));
//		leDinhChinh.setBounds(115, 114, 389, 39);
//		add(leDinhChinh);
//		
//		JLabel artistLabel = new JLabel("Artist:");
//		artistLabel.setHorizontalAlignment(SwingConstants.LEFT);
//		artistLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
//		artistLabel.setBounds(71, 164, 198, 78);
//		add(artistLabel);
//		
//		JLabel nguyenMinhThu = new JLabel("Nguyễn Minh Thư (Ritsu)");
//		nguyenMinhThu.setHorizontalAlignment(SwingConstants.LEFT);
//		nguyenMinhThu.setFont(new Font("Tahoma", Font.PLAIN, 22));
//		nguyenMinhThu.setBounds(115, 253, 405, 39);
//		add(nguyenMinhThu);
//		
		JButton backButton = new JButton("<");
		backButton.setBounds(598, 399, 50, 32);
		add(backButton);
		
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "mainMenu");
			}
		});
		
		add(bg);
	}
}
