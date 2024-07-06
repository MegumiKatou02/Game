package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;

public class GameMainView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public GameMainView() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(GameMainView.class.getResource("/image/ic.jpg")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 677, 492);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Arcane Worlds - Etherite");
        
        contentPane = new JPanel(new BorderLayout()); // Sử dụng BorderLayout
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        MenuStartGame menu = new MenuStartGame(); // jPanel
        contentPane.add(menu, BorderLayout.CENTER); // Thêm vào giữa BorderLayout
    }
}
