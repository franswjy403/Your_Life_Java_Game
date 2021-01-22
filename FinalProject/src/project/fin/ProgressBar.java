package project.fin;

import java.awt.Color;
import java.awt.Graphics;

public class ProgressBar {
	private int x, y, width, height, baseLength;
	private Color color;
	public ProgressBar(int x, int y, int width, int height, Color color) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.color=color;
		this.baseLength=width;
	}
	public void draw (Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}
	public void update(int alt) {
		if (this.width+alt>190)return;
		else if (this.width+alt<0)return;
		this.width+=alt;
	}
	public void reset() {
		this.width=baseLength;
	}
	public int getWidth() {
		return this.width;
	}
}
