import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {
	
	int facing;
	int whichmonkey;
	
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
		g.fillRect(x, y, width, height);
		
		g.setColor(Color.yellow);
		g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);
	}
}
