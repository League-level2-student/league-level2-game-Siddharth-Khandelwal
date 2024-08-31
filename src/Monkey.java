import java.awt.Color;
import java.awt.Graphics;

public class Monkey extends GameObject{
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
}
