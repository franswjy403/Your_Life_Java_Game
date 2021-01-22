package project.fin;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {
	public static JFrame frame;
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				frame = new JFrame ("Your Life");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(1200, 500);
				frame.setFocusable(true);
				ImageIcon image = new ImageIcon("mainMenuItem/Logo.png");
				frame.setIconImage(image.getImage());
				new PanelPool();
				frame.setContentPane(PanelPool.MainMenu);
				frame.pack();
				frame.setVisible(true);
				frame.setResizable(false);
				frame.setLayout(null);
			}
		});
	}
}
