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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOverPanel extends JPanel implements ActionListener{
	private Font title;
	private Font Buttons;
	private Font Button1;
	private Image img;
	public musicPlay overMusic;
	public GameOverPanel(String img) {
		overMusic = new musicPlay();
		this.img = new ImageIcon(img).getImage();
		Dimension size = new Dimension(1200, 500);
		this.setPreferredSize(size);
		this.setMaximumSize(size);
		this.setMinimumSize(size);
		this.setSize(size);
		this.setLayout(null);
		try {
			title = Font.createFont(Font.TRUETYPE_FONT, new File("text/Button.ttf")).deriveFont(80f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("text/Button.ttf")));
		}
		catch(IOException | FontFormatException e) {
			
		}
		
		try {
			Buttons = Font.createFont(Font.TRUETYPE_FONT, new File("text/Button.ttf")).deriveFont(25f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("text/Button.ttf")));
		}
		catch(IOException | FontFormatException e) {
			
		}
		
		Button1 = Buttons.deriveFont(Font.BOLD);
		
		//Label1
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setText("Storyline");
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel.setFont(title);
		lblNewLabel.setBounds(300, 30, 570, 150);
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setIconTextGap(0);
		this.add(lblNewLabel);
		
		//Label2
		JLabel label = new JLabel();
		label.setText("Completed!");
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(title);
		label.setBounds(310,100,570,150);
		label.setForeground(Color.ORANGE);
		this.add(label);
		
		//Button1
		JButton button = new JButton();
		button.setText("MAIN MENU");
		button.setFont(Button1);
		button.setFocusable(true);
		button.setBounds(350, 300, 180, 31);
		button.setBackground(new Color(255, 238, 88));
		button.setForeground(Color.BLACK);
		button.addActionListener(this);
		this.add(button);
		
		//Button2
		JButton button2 = new JButton();
		button2.setText("QUIT");
		button2.setFont(Button1);
		button2.setFocusable(true);
		button2.setBounds(650, 300, 180, 31);
		button2.setBackground(new Color(255, 238, 88));
		button2.setForeground(Color.BLACK);
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				overMusic.stopMusic();
				Main.frame.setVisible(false);
				Main.frame.dispose();
			}
			
		});
		this.add(button2);
		
		this.setSize(1200, 500);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//JOptionPane.showMessageDialog(this, "Action Event telah diaktifkan!");
		overMusic.stopMusic();
		Main.frame.setContentPane(PanelPool.MainMenu);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.img, 0, 0, null);
	}
}
