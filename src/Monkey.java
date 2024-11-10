import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Monkey extends GameObject{
volatile boolean up = false;
volatile boolean down = false;
volatile boolean right = false;
volatile boolean left = false;
int facing;
int timesHit = 0;
	Color c;
	int whichmonkey;
static BufferedImage imgb; 
	static BufferedImage imgr;
	static {
		
		try {
			imgb = ImageIO.read(new File("src/bluemonkey.png"));
			imgr = ImageIO.read(new File("src/redmonkey.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Monkey(int x, int y, int width, int height, int whichmonkey, Color c, int facing, int timeHit) {
		super(x, y, width, height);
		collisionBox.setBounds(x + width/10, y+height/10, width-width/5, height-height/5);
		speed = 5;
		this.whichmonkey = whichmonkey;
		this.c = c;
		this.facing = facing;
	}
	public Projectile getProjectile() {
		
			return new Projectile(x + width/2 -20, y + height/2 -20, 25, 35, 10, facing, whichmonkey);
		
		
		
	}
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		//g.setColor(c);
		//g.fillRect(x, y, width, height);
		g.setColor(c);
		if(whichmonkey == 1) {
			g.drawImage(imgb,x, y, width, height, null);
		}
		else {
			g.drawImage(imgr,x, y, width, height, null);	
		}
		//g.drawRect(collisionBox.x , collisionBox.y , collisionBox.width  , collisionBox.height );
	}

public void update() {
	if (up && y > 0) {
		y -= speed;
		
	}
	if (down && y < 500 - 50) {
		y += speed;
	
	}
	if (left && x > 0) {
		x -= speed;
		
	}
	if (right && x < 800 - 50) {
		x += speed;
		
	}
	collisionBox.setBounds(x + width/10, y+height/10, width-width/5, height-height/5);
}
}
