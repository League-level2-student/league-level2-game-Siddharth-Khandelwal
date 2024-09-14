import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ObjectManager implements ActionListener{
Monkey b;
Monkey r;
ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	
public ObjectManager(Monkey bl, Monkey re) {
	b = bl;
	r = re;
}
void addProjectile(Projectile p) {
	projectiles.add(p);
}
void draw(Graphics g) {
	b.draw(g);
	r.draw(g);
	for(Projectile p : projectiles) {
		p.draw(g);
	}
}
@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
public void update() {
	// TODO Auto-generated method stub
	b.update();
	r.update();
	for(Projectile p : projectiles) {
		p.update();
	}
}

}
