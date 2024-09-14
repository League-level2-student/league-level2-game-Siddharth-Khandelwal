import java.awt.Color;
import java.awt.Graphics;

public class Monkey extends GameObject{
boolean up = false;
boolean down = false;
boolean right = false;
boolean left = false;
	Color c;
	int whichmonkey;
	public Monkey(int x, int y, int width, int height, int whichmonkey, Color c) {
		super(x, y, width, height);
		speed = 5;
		this.whichmonkey = whichmonkey;
		this.c = c;
	}
	public Projectile getProjectile() {
		if(whichmonkey == 1) {
			return new Projectile(x + width, y+height/2, 10, 10, whichmonkey*10);
		}else {
			return new Projectile(x, y+height/2, 10, 10, whichmonkey*10);	
		}
	}
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(c);
		g.fillRect(x, y, width, height);
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
}
}
