import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {
	public Projectile(int x, int y, int width, int height, int speed) {
		super(x, y, width, height);
		this.speed = speed;
	}

	public void update() {
		x += speed;
		if (x < 0) {
			isActive = false;
		}
		if(x>800) {
			isActive = false;
		}
		super.update();
	}

	public void draw(Graphics g) {

		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
}
