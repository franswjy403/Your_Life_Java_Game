package project.fin;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class objectSpawned {
	private Image img;
	private int x;
	private int y;
	private int speed;
	private boolean touch;
	
	public objectSpawned(int x, int y, int speed, Image img) {
		this.img = img;
		this.x=x;
		this.y=y;
		this.speed=speed;
		this.touch=false;
	}
	public void fly() {
		this.y-=speed;
	}
	public boolean isOutside() {
		if (this.y<=-60)return true;
		else return false;
	}
	public void draw(Graphics g) {
		if (!this.touch)
		g.drawImage(this.img, x, y, null);
		else speed=0;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setTouch(boolean touch) {
		this.touch = touch;
		this.y+=20;
	}
}
