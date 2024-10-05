import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Projectile extends GameObject {
	
	int facing;
	int whichmonkey;
	static BufferedImage img; 
	
	static {
		
		try {
			img = ImageIO.read(new File("src/image-removebg-preview.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Projectile(int x, int y, int width, int height, int speed, int facing, int whichmonkey) {
		super(x, y, width, height);
		this.speed = speed;
		this.facing = facing;
		this.whichmonkey = whichmonkey;
		
	}

	public void update() {
		
		if (facing == 0) {
			y-=speed;
		}
		if(facing == 1) {
			x+=speed;
		}
		if(facing == 2) {
			y+=speed;
		}
		if(facing == 3) {
			x-=speed;
		}
		
		
		
		if (x < 0) {
			isActive = false;
		}
		if(x>800) {
			isActive = false;
		}
		if (y < 0) {
			isActive = false;
		}
		if(y>500) {
			isActive = false;
		}
		super.update();
	}

	public void draw(Graphics g) {

		g.setColor(Color.BLUE);
		g.drawImage(img,x, y, width, height, null);
		
		//g.setColor(Color.yellow);
		//g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);
	}
	
}
