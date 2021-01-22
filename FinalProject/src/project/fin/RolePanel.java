package project.fin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RolePanel extends JPanel{
	private Font Minecraftory, Buttons;
	private JLabel currentName;
	private Image img;
	private List <Image> Character;
	private List <JButton> roles;
	private int numberRole;
	public RolePanel(String img) {
		
		this.img = new ImageIcon(img).getImage();
		Dimension size = new Dimension(1200, 500);
		this.setPreferredSize(size);
		this.setMaximumSize(size);
		this.setMinimumSize(size);
		this.setSize(size);
		this.setLayout(null);
		
		this.Character = new ArrayList <Image>();
		this.Character.add(new ImageIcon("CharacterImage/human.png").getImage());
		this.Character.add(new ImageIcon("CharacterImage/zeusFix.png").getImage());
		this.Character.add(new ImageIcon("CharacterImage/corgiFix.png").getImage());
		this.Character.add(new ImageIcon("CharacterImage/devil.png").getImage());
		
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
		currentName=new JLabel();
		currentName.setText("ROLE : "+PanelPool.MainMenu.getCurrentRole());
		currentName.setHorizontalAlignment(JLabel.LEFT);
		currentName.setFont(Minecraftory.deriveFont(20f));
		currentName.setBounds(80, 12, 570, 50);
		currentName.setForeground(Color.ORANGE);
		currentName.setIconTextGap(10);
		this.add(currentName);
		
		this.roles = new ArrayList <JButton> ();
		
		JButton role1 = new JGradientButtonSimple("", new Color (250, 243, 14),new Color(255, 187, 0));
		role1.setText("Human");
		role1.setFocusable(false);
		role1.setFocusPainted(false);
		role1.setBackground(new Color(255, 238, 88));
		role1.setForeground(Color.BLACK);
		role1.setFont(Buttons);
		role1.setBounds(200, 350, 109, 31);
		role1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PanelPool.MainMenu.setCurrentRole("Human");
				currentName.setText("ROLE : "+PanelPool.MainMenu.getCurrentRole());
			}
			
		});
		this.roles.add(role1);
		
		JButton role2 = new JGradientButtonSimple("", new Color (250, 243, 14),new Color(255, 187, 0));
		role2.setText("God");
		role2.setFocusable(false);
		role2.setFocusPainted(false);
		role2.setBackground(new Color(255, 238, 88));
		role2.setForeground(Color.BLACK);
		role2.setFont(Buttons);
		role2.setBounds(450, 350, 109, 31);
		role2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PanelPool.MainMenu.setCurrentRole("God");
				currentName.setText("ROLE : "+PanelPool.MainMenu.getCurrentRole());
			}
			
		});
		this.roles.add(role2);
		
		JButton role3 = new JGradientButtonSimple("", new Color (250, 243, 14),new Color(255, 187, 0));
		role3.setText("Dog");
		role3.setFocusable(false);
		role3.setFocusPainted(false);
		role3.setBackground(new Color(255, 238, 88));
		role3.setForeground(Color.BLACK);
		role3.setFont(Buttons);
		role3.setBounds(700, 350, 109, 31);
		role3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PanelPool.MainMenu.setCurrentRole("Dog");
				currentName.setText("ROLE : "+PanelPool.MainMenu.getCurrentRole());
			}
			
		});
		this.roles.add(role3);
		
		JButton role4 = new JGradientButtonSimple("", new Color (250, 243, 14),new Color(255, 187, 0));
		role4.setText("Devil");
		role4.setFocusable(false);
		role4.setFocusPainted(false);
		role4.setBackground(new Color(255, 238, 88));
		role4.setForeground(Color.BLACK);
		role4.setFont(Buttons);
		role4.setBounds(950, 350, 109, 31);
		role4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PanelPool.MainMenu.setCurrentRole("Devil");
				currentName.setText("ROLE : "+PanelPool.MainMenu.getCurrentRole());
			}
			
		});
		this.roles.add(role4);
		
		JButton Button4 = new JGradientButtonSimple("", new Color (204, 0, 0),new Color(128, 0, 0));
		Button4.setText("Back");
		Button4.setFocusable(false);
		Button4.setFocusPainted(false);
		Button4.setBackground(new Color(244, 67, 54));
		Button4.setForeground(Color.WHITE);
		Button4.setFont(Buttons);
		Button4.setBounds(900, 430, 100, 31);
		Button4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Main.frame.setContentPane(PanelPool.MainMenu);
			}
			
		});
		this.add(Button4);
		unlock();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.img, 0, 0, null);
		int x=200;
		for (Image a : Character) {
			g.drawImage(a, x, 170, null);
			x+=240;
		}
	}
	
	public void unlock() {
		if (this.numberRole<this.roles.size()) {
			this.add(this.roles.get(this.numberRole));
			this.numberRole++;
		}
	}
}
