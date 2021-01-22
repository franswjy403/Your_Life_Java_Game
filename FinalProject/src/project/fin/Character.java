package project.fin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import project.fin.QuestionPackage.answer;

public abstract class Character {
	float x, y;
	int speed;
	protected List <ProgressBar> bars;
	protected List <Image> ImgPool;
	public List <Image> iconPool;
	protected int Current;
	protected Image current;
	protected int direction;
	protected int begin;
	protected int end;
	protected int state;
	protected int CurrentStateAtt;
	protected int startImage;
	protected int endImage;	
	protected String status;
	protected String att1, att2, att3;
	protected Package pack;
	protected Image obj;
	public Character(float x, float y, int speed, int barX, int barY, int height) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		
		this.CurrentStateAtt=0;
		this.startImage=0;
		this.endImage=4;
		
		this.setState(1);
		
		this.bars = new ArrayList<ProgressBar>();
		bars.add(new ProgressBar(barX, barY, 80, height, Color.RED));
		bars.add(new ProgressBar(barX, barY+60, 80, height, Color.YELLOW));
		bars.add(new ProgressBar(barX, barY+120, 80, height, Color.CYAN));
	}
	
	public void MoveRight() {
		if (this.direction!=1) {
				this.Current=this.startImage;
				this.begin=this.startImage;
				this.end=this.endImage;
				this.current=this.ImgPool.get(Current);
			}
			if (x+speed>1100) {
				this.Current=this.startImage;
				return;
			}
			this.x+=speed;
			if (this.Current+1==this.end) {
				this.current = this.ImgPool.get(Current);
				this.Current=this.begin;
				this.current=this.ImgPool.get(Current);
			}
			else {
				this.Current++;
				this.current = this.ImgPool.get(Current);
			}
	}
	
	public void MoveLeft() {
		if (this.direction!=2) {
			this.Current=this.startImage+4;
			this.begin=this.startImage+4;
			this.end=this.endImage+4;
			this.current=this.ImgPool.get(Current);
		}
		if (x-speed<100) {
			this.Current=this.startImage+4;
			return;
		}
		this.x-=speed;
		if (this.Current+1==this.end) {
			this.current = this.ImgPool.get(Current);
			this.Current=this.begin;
			this.current=this.ImgPool.get(Current);
		}
		else {
			this.Current++;
			this.current = this.ImgPool.get(Current);
		}
	}
	
	public void draw(Graphics g) {
		g.drawImage(this.current, (int)this.x, (int)this.y, null);
		for (ProgressBar p : bars) {
			p.draw(g);
		}
	}
	
	public void updateBars(answer a) {
		int index1 = a.getPointA().getIndex(); int value1 = a.getPointA().getPoint();
		int index2 = a.getPointB().getIndex(); int value2 = a.getPointB().getPoint();
		int index3 = a.getPointC().getIndex(); int value3 = a.getPointC().getPoint();
		bars.get(index1).update(value1);
		bars.get(index2).update(value2);
		bars.get(index3).update(value3);
	}
	
	public int getBarsLength(int ind) {
		return bars.get(ind).getWidth();
	}
	
	public abstract void LevelUp();
	
	public abstract boolean check(int index); 
	
	public void setDirection(int dir) {
		this.direction=dir;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getCurrentStateAtt() {
		return CurrentStateAtt;
	}

	public void setCurrentStateAtt(int currentStateAtt) {
		CurrentStateAtt = currentStateAtt;
	}
	public String getAtt1() {
		return att1;
	}
	public String getAtt2() {
		return att2;
	}
	public String getAtt3() {
		return att3;
	}
	public String getStatus() {
		return status;
	}
	public Image getObj() {
		return obj;
	}
}
