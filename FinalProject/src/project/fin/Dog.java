package project.fin;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Dog extends Character{

	public Dog(float x, float y, int speed, int barX, int barY, int height) {
		super(x, y, speed, barX, barY, height);
		// TODO Auto-generated constructor stub
		this.pack = new dogPackage();
		
		this.status=new String("PUPPY");
		this.att1=new String("HEALTH");
		this.att2=new String("INTELLIGENCE");
		this.att3=new String("MOOD");
		
		this.obj = new ImageIcon("dogImage/smallMeat.png").getImage();
		
		ImgPool = new ArrayList<Image>();
		
		//These are just some images that i use to build my moving baby
		ImgPool.add(new ImageIcon("dogImage/smallDogRight.png").getImage());
		ImgPool.add(new ImageIcon("dogImage/smallDogRight.png").getImage());
		ImgPool.add(new ImageIcon("dogImage/smallDogRight.png").getImage());
		ImgPool.add(new ImageIcon("dogImage/smallDogRight.png").getImage());
		ImgPool.add(new ImageIcon("dogImage/smallDog.png").getImage());
		ImgPool.add(new ImageIcon("dogImage/smallDog.png").getImage());
		ImgPool.add(new ImageIcon("dogImage/smallDog.png").getImage());
		ImgPool.add(new ImageIcon("dogImage/smallDog.png").getImage());
		
		ImgPool.add(new ImageIcon("dogImage/mediumDogRight.png").getImage());
		ImgPool.add(new ImageIcon("dogImage/mediumDogRight.png").getImage());
		ImgPool.add(new ImageIcon("dogImage/mediumDogRight.png").getImage());
		ImgPool.add(new ImageIcon("dogImage/mediumDogRight.png").getImage());
		ImgPool.add(new ImageIcon("dogImage/mediumDog.png").getImage());
		ImgPool.add(new ImageIcon("dogImage/mediumDog.png").getImage());
		ImgPool.add(new ImageIcon("dogImage/mediumDog.png").getImage());
		ImgPool.add(new ImageIcon("dogImage/mediumDog.png").getImage());
		
		ImgPool.add(new ImageIcon("dogImage/corgiRight.png").getImage());
		ImgPool.add(new ImageIcon("dogImage/corgiRight.png").getImage());
		ImgPool.add(new ImageIcon("dogImage/corgiRight.png").getImage());
		ImgPool.add(new ImageIcon("dogImage/corgiRight.png").getImage());
		ImgPool.add(new ImageIcon("dogImage/corgi.png").getImage());
		ImgPool.add(new ImageIcon("dogImage/corgi.png").getImage());
		ImgPool.add(new ImageIcon("dogImage/corgi.png").getImage());
		ImgPool.add(new ImageIcon("dogImage/corgi.png").getImage());
		
		iconPool = new ArrayList<Image>();
		iconPool.add(new ImageIcon("dogImage/Heart_30.png").getImage());
		iconPool.add(new ImageIcon("dogImage/idea_30.png").getImage());
		iconPool.add(new ImageIcon("dogImage/smiley_30.png").getImage());
		iconPool.add(new ImageIcon("dogImage/Heart_30.png").getImage());
		iconPool.add(new ImageIcon("dogImage/cute30.png").getImage());
		iconPool.add(new ImageIcon("dogImage/idea_30.png").getImage());
		iconPool.add(new ImageIcon("dogImage/loyalty30.png").getImage());
		iconPool.add(new ImageIcon("dogImage/cuteness30.png").getImage());
		iconPool.add(new ImageIcon("dogImage/Heart_30.png").getImage());
		
		this.current = ImgPool.get(0);
		this.Current = 0;
		this.begin = 0;
		this.end = 4;
		this.direction = 1;
	}

	@Override
	public void LevelUp() {
		// TODO Auto-generated method stub
		System.out.println("Leveled Up");
		this.setState(this.getState() + 1);
		this.setCurrentStateAtt(this.getCurrentStateAtt() + 3);
		if (this.state==2) {
			this.status=new String ("DOGGIE");
			this.att2=new String("ATTRACTIVE");
			this.att3=new String("INTELLIGENCE");
		}
		else if (this.state==3) {
			this.status=new String ("CORGI");
			this.att1=new String ("LOYALTY");
			this.att2=new String ("CUTENESS");
			this.att3=new String ("HEALTH");
		}
		this.startImage+=8;
		this.endImage+=8;
		this.begin=this.startImage;
		this.end=this.endImage;
		this.Current=this.startImage;
		this.current=this.ImgPool.get(Current);
		for (ProgressBar p : bars) {
			p.reset();
		}
	}

	@Override
	public boolean check(int index) {
		// TODO Auto-generated method stub
		if (this.state==1) {
			return this.pack.QuestionPool1.get(index).getAlready();
		}
		else if (this.state==2) {
			return this.pack.QuestionPool2.get(index).getAlready();
		}
		else {
			return this.pack.QuestionPool3.get(index).getAlready();
		}
	}

}
