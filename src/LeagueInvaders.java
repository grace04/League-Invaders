import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {

	public static void main(String[] args) {
		LeagueInvaders legin = new LeagueInvaders();
		legin.setup();
	}

	JFrame frame;
	final int WI = 500;
	final int HE = 800;
	GamePanel gp;

	LeagueInvaders() {
		frame = new JFrame();
		gp = new GamePanel();
	}

	public void setup() {
		frame.add(gp);
		frame.addKeyListener(gp);
		frame.getContentPane().setPreferredSize(new Dimension(WI, HE));
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gp.startGame();
	}
}
