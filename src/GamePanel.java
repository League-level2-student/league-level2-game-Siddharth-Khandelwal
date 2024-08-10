import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font baseFont = new Font("Arial", Font.PLAIN, 24);
	Font titleFont = new Font("Arial", Font.PLAIN, 48);

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
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, MonkeyMassacre.WIDTH, MonkeyMassacre.HEIGHT);
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
		repaint();// DELETE ME!
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
