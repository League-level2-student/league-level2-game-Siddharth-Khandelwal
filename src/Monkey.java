import java.awt.Color;
import java.awt.Graphics;

public class Monkey extends GameObject{
boolean up = false;
boolean down = false;
boolean right = false;
boolean left = false;
int facing;
	Color c;
	int whichmonkey;
	public Monkey(int x, int y, int width, int height, int whichmonkey, Color c, int facing) {
		super(x, y, width, height);
		speed = 5;
		this.whichmonkey = whichmonkey;
		this.c = c;
		this.facing = facing;
	}
	public Projectile getProjectile() {

			return new Projectile(x + width/2 -5, y + height/2 -5, 10, 10, 10, facing, whichmonkey);
		
		
		
	}
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(c);
		g.fillRect(x, y, width, height);
		g.setColor(Color.yellow);
		g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);
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
	super.update();
}
}
