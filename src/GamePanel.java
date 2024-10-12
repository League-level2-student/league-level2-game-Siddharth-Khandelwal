import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Monkey bmonk = new Monkey(0, 210, 80, 80, 1, Color.blue, 1, 0);
	Monkey rmonk = new Monkey(720, 210, 80, 80, 2, Color.red, 3, 0);
	ObjectManager obj = new ObjectManager(bmonk, rmonk);
	Font baseFont = new Font("Arial", Font.PLAIN, 24);
	Font titleFont = new Font("Arial", Font.PLAIN, 48);
	Timer frameDraw;
	static String winningmonk;
static BufferedImage img; 
	
	static {
		
		try {
			img = ImageIO.read(new File("src/jungle.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public GamePanel() {
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
	}
	void updateMenuState() {

	}

	void updateGameState() {
		obj.update();
		if(bmonk.isActive == false) {
			currentState = END;
		}
		if(rmonk.isActive == false) {
			currentState = END;
		}
	}

	void updateEndState() {

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
		g.drawImage(img,0, 0,MonkeyMassacre.WIDTH, MonkeyMassacre.HEIGHT, null);
		obj.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, MonkeyMassacre.WIDTH, MonkeyMassacre.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.white);
		g.drawString("  GAME OVER", 0, 100);
		g.setFont(baseFont);
		g.drawString("  Winner: " +winningmonk+ " Monkey Won the Game!", 0, 300);
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
				bmonk = new Monkey(0, 210, 75, 75, 1, Color.blue, 1, 0);
				rmonk = new Monkey(720, 210, 75, 75, 2, Color.red, 3, 0);
				obj = new ObjectManager(bmonk, rmonk);
				currentState = MENU;
			} else {
				currentState++;
			}

		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE && currentState == MENU) {
			String[] options =  {"Blue", "Red", "Instructions"};	
			int pressed = JOptionPane.showOptionDialog ( null, "Pick Red or Blue for Controls. Click Instructions for Instructions", "Instructions and Controls", 
					JOptionPane.OK_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, options, null )  ;  


			if(pressed == 0) {
				JOptionPane.showMessageDialog(null, "To move blue monkey, use W to move up, A to move left, S to move down, and D to move right. To throw a banana press Z.");
			}else if (pressed == 1) {
				JOptionPane.showMessageDialog(null, "To move red monkey, use I to move up, J to move left, K to move down, and L to move right. To throw a banana press M.");
			}else if(pressed == 2) {
				JOptionPane.showMessageDialog(null, "First monkey to hit the other monkey with a banana wins!");
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_W) {
			bmonk.up = true;
			bmonk.facing = 0;
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			bmonk.left = true;
			bmonk.facing = 3;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			bmonk.down = true;
			bmonk.facing = 2;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			bmonk.right = true;
			bmonk.facing = 1;
		}
		if (e.getKeyCode() == KeyEvent.VK_I) {
			rmonk.up = true;
			rmonk.facing = 0;
		}
		if (e.getKeyCode() == KeyEvent.VK_J) {
			rmonk.left = true;
			rmonk.facing = 3;
		}
		if (e.getKeyCode() == KeyEvent.VK_K) {
			rmonk.down = true;
			rmonk.facing = 2;
		}
		if (e.getKeyCode() == KeyEvent.VK_L) {
			rmonk.right = true;
			rmonk.facing = 1;
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyCode() == KeyEvent.VK_W) {
			bmonk.up = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			bmonk.left = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			bmonk.down = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			bmonk.right = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_I) {
			rmonk.up = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_J) {
			rmonk.left = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_K) {
			rmonk.down = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_L) {
			rmonk.right = false;
		}
		if (e.getExtendedKeyCode() == KeyEvent.VK_Z) {
			obj.addProjectile(bmonk.getProjectile());
		}
		if (e.getExtendedKeyCode() == KeyEvent.VK_M) {
			obj.addProjectile(rmonk.getProjectile());
		}
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
//		if (e.getExtendedKeyCode() == KeyEvent.VK_Z) {
//			obj.addProjectile(bmonk.getProjectile());
//		}
//		if (e.getExtendedKeyCode() == KeyEvent.VK_M) {
//			obj.addProjectile(rmonk.getProjectile());
//		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint();
		// TODO Auto-generated method stub
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();
		} else if (currentState == END) {
			updateEndState();

		}

	
	}

}
