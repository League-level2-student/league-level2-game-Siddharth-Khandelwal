import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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

	private void purgeObjects() {
		for (int j = 0; j < projectiles.size(); j++) {
			if(projectiles.get(j).isActive == false) {
				projectiles.remove(j);
				j--;
			}
		}
		
		
		
		
	if(r.isActive == false) {
		JOptionPane.showMessageDialog(null, "Blue won!");
		
	}
	if(b.isActive == false) {
		JOptionPane.showMessageDialog(null, "Red won!");
		
	}
	}
	public void update() {
		// TODO Auto-generated method stub
		b.update();
		r.update();
		for(Projectile p : projectiles) {
			p.update();
		}
		checkCollison();
		purgeObjects();
	}
	void checkCollison() {
		for(Projectile p : projectiles) {
			if(p.whichmonkey == 1) {
				if(p.collisionBox.intersects(r.collisionBox)) {
					System.out.println("red done been hit");
					p.isActive = false;
					r.timesHit++;
					if(r.timesHit == 5) {      
						GamePanel.winningmonk = "Blue";
						r.isActive = false;
						r.timesHit = 0;
						b.timesHit = 0;
					}
					
				}
			}
			if(p.whichmonkey == 2) {
				if(p.collisionBox.intersects(b.collisionBox)) {
					System.out.println("blue done been hit");
					p.isActive = false;
					b.timesHit++;
					if(b.timesHit == 5) {
						GamePanel.winningmonk = "Red";
						b.isActive = false;
						b.timesHit = 0;
						r.timesHit = 0;
					}
					
				}
			}
		}
	}
}
