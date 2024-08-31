import java.awt.Dimension;

import javax.swing.JFrame;

public class MonkeyMassacre {
	JFrame frame = new JFrame();
	public static final int WIDTH = 800;
	public static final int HEIGHT = 500;
	GamePanel gp;

	public MonkeyMassacre() {
		gp = new GamePanel();
		frame.addKeyListener(gp);
	}

	public static void main(String[] args) {
		MonkeyMassacre p = new MonkeyMassacre();
		p.setup();
	}

	void setup() {
		frame.add(gp);
		gp.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}
}
