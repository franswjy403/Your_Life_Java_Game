package project.fin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.*;

public class MainMenuPanel extends JPanel{
	private Image img;
	private Font Buttons;
	private Font Minecraftory;
	public musicPlay mainMenuMusic;
	private String currentRole;
	public MainMenuPanel(String img) {
		
		this.img = new ImageIcon(img).getImage();
		Dimension size = new Dimension(1200, 500);
		this.setPreferredSize(size);
		this.setMaximumSize(size);
		this.setMinimumSize(size);
		this.setSize(size);
		this.setLayout(null);
		try {
			Minecraftory = Font.createFont(Font.TRUETYPE_FONT, new File("text/Early Gameboy.ttf")).deriveFont(50f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("text/Early Gameboy.ttf")));
		}
		catch(IOException | FontFormatException e) {
			
		}
		
		try {
			Buttons = Font.createFont(Font.TRUETYPE_FONT, new File("text/OSD Mono.ttf")).deriveFont(20f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("text/OSD Mono.ttf")));
		}
		catch(IOException | FontFormatException e) {
			
		}
		
		this.currentRole="Human";
		
		this.mainMenuMusic = new musicPlay();
		mainMenuMusic.playMusic("music/MainMenu.wav");
		mainMenuMusic.musicLoop();
		
		ImageIcon Img = new ImageIcon("mainMenuItem/Logo.png");
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setText("YOUR LIFE");
		lblNewLabel.setIcon(Img);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel.setFont(Minecraftory);
		lblNewLabel.setBounds(275, 12, 570, 150);
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setIconTextGap(0);
		this.add(lblNewLabel);
		
		JButton Button1 = new JGradientButtonSimple("PLAY", new Color (250, 243, 14),new Color(255, 187, 0));
		Button1.setText("PLAY");
		Button1.setFocusable(false);
		Button1.setFocusPainted(false);
		Button1.setBackground(new Color(255, 238, 88));
		Button1.setForeground(Color.BLACK);
		Button1.setFont(Buttons);
		Button1.setBounds(506, 190, 109, 31);
		Button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainMenuMusic.stopMusic();
				Main.frame.setContentPane(PanelPool.InstructPage);
			}
			
		});
		this.add(Button1);
		
		
		
		JButton Button2 = new JGradientButtonSimple("ROLE", new Color (250, 243, 14),new Color(255, 187, 0));
		Button2.setText("ROLE");
		Button2.setFocusable(false);
		Button2.setFocusPainted(false);
		Button2.setBackground(new Color(255, 238, 88));
		Button2.setForeground(Color.BLACK);
		Button2.setFont(Buttons);
		Button2.setBounds(506, 242, 109, 31);
		Button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Main.frame.setContentPane(PanelPool.RolePage);
			}
			
		});
		this.add(Button2);
		
		JButton Button3 = new JGradientButtonSimple("EXIT", new Color (250, 243, 14),new Color(255, 187, 0));
		Button3.setText("EXIT");
		Button3.setFocusable(false);
		Button3.setFocusPainted(false);
		Button3.setBackground(new Color(255, 238, 88));
		Button3.setForeground(Color.BLACK);
		Button3.setFont(Buttons);
		Button3.setBounds(506, 294, 109, 31);
		Button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainMenuMusic.stopMusic();
				Main.frame.setVisible(false);
				Main.frame.dispose();
			}
			
		});
		this.add(Button3);
		
		JButton Button4 = new JGradientButtonSimple("", new Color (204, 0, 0),new Color(128, 0, 0));
		Button4.setText("Achievements");
		Button4.setFocusable(false);
		Button4.setFocusPainted(false);
		Button4.setBackground(new Color(244, 67, 54));
		Button4.setForeground(Color.WHITE);
		Button4.setFont(Buttons);
		Button4.setBounds(900, 400, 200, 31);
		//Button4.addActionListener(new ActionToDo (PanelPool.PlayPage, 5, mainMenuMusic));
		this.add(Button4);
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.img, 0, 0, null);
	}

	public String getCurrentRole() {
		return currentRole;
	}
	public void setCurrentRole(String currentRole) {
		this.currentRole = currentRole;
	}
}
