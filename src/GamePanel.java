import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Monkey bmonk = new Monkey(0, 225, 50 ,50, 1, Color.blue);
	Monkey rmonk = new Monkey(750, 225, 50, 50, -1, Color.red);
	ObjectManager obj = new ObjectManager(bmonk, rmonk);
	Font baseFont = new Font("Arial", Font.PLAIN, 24);
	Font titleFont = new Font("Arial", Font.PLAIN, 48);
	Timer frameDraw;
	public GamePanel() {
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, MonkeyMassacre.WIDTH, MonkeyMassacre.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.white);
		g.drawString("  Monkey Massacre", 0, 100);
		g.setFont(baseFont);
		g.drawString(" -- Press SPACE for Instructions", 0, 300);
		g.drawString(" -- Press ENTER to Start", 0, 400);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, MonkeyMassacre.WIDTH, MonkeyMassacre.HEIGHT);
		obj.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, MonkeyMassacre.WIDTH, MonkeyMassacre.HEIGHT);
		g.setFont(titleFont);	
		g.setColor(Color.white);
		g.drawString("  GAME OVER", 0, 100);
		g.setFont(baseFont);
		g.drawString("  Winner: "+"Monkey Won the Game!", 0, 300);
		g.drawString(" -- Press ENTER to go to Home Screen", 0, 400);
		}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {
				currentState = MENU;
			} else {
				currentState++;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_Z) {
			obj.addProjectile(bmonk.getProjectile());
		}
		if(e.getKeyCode() == KeyEvent.VK_M) {
			obj.addProjectile(rmonk.getProjectile());
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

}
