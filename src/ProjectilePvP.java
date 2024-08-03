import javax.swing.JFrame;

public class ProjectilePvP {
	JFrame frame = new JFrame();
	public static final int WIDTH = 800;
	public static final int HEIGHT = 500;
	GamePanel gp;

	public ProjectilePvP() {
		gp = new GamePanel();
		frame.addKeyListener(gp);
	}

	public static void main(String[] args) {
		ProjectilePvP p = new ProjectilePvP();
		p.setup();
	}

	void setup() {
		frame.add(gp);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
