import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	Timer timer;
	// GameObject go;
	Rocketship rs = new Rocketship(250, 700, 50, 50);
	ObjectManager om = new ObjectManager(rs);
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont;
	Font regFont;
    public static BufferedImage alienImg;
    public static BufferedImage rocketImg;
    public static BufferedImage bulletImg;
    public static BufferedImage spaceImg;

	GamePanel() {
		timer = new Timer(1000 / 60, this);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		regFont = new Font("Arial", Font.PLAIN, 24);
		// go = new GameObject(10, 10, 480, 780);
		 try {
             alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
             rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
             bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
             spaceImg = ImageIO.read(this.getClass().getResourceAsStream("space.png"));
     } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
     }
	}

	void startGame() {
		timer.start();
	}

	void updateMenuState() {
	}

	void updateGameState() {
		om.update();
		om.manageEnemies();
		om.checkCollision();
		if(rs.isAlive==false) {
			currentState = END_STATE;
		}
	}

	void updateEndState() {
		
	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 500, 800);
		g.setColor(Color.YELLOW);
		g.setFont(titleFont);
		g.drawString("LEAGUE INVADERS", 25, 200);
		g.setFont(regFont);
		g.drawString("Press ENTER to start", 120, 350);
		g.drawString("Press SPACE for instructions", 85, 500);
	}

	void drawGameState(Graphics g) {
		g.drawImage(spaceImg, 0, 0, LeagueInvaders.WI, LeagueInvaders.HE, null);
		om.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, 500, 800);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("Game Over", 125, 200);
		g.setFont(regFont);
		g.drawString("You killed " + om.kill + " enemies", 140, 350);
		g.drawString("Press ENTER to restart", 120, 500);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char kp = (char) e.getKeyChar();
		int kc = (int) e.getKeyCode();
		if (kp == 10) {
			if (currentState == MENU_STATE) {
				currentState = GAME_STATE;
			} else if (currentState == GAME_STATE) {
				currentState = END_STATE;
			} else if (currentState == END_STATE) {
				currentState = MENU_STATE;
				rs.isAlive = true;
				om = new ObjectManager(rs);
			}
		}

		if (kp == 'a') {
			rs.le = true;
		}
		if (kp == 'd') {
			rs.ri = true;
		}
		if (kp == 'w') {
			rs.up = true;
		}
		if (kp == 's') {
			rs.dw = true;
		}
		if (kp == 'k') {
			om.addProjectile(new Projectile(rs.x + 21, rs.y, 10, 10));
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		char kr = (char) e.getKeyChar();

		if (kr == 'a') {
			rs.le = false;
		}
		if (kr == 'd') {
			rs.ri = false;
		}
		if (kr == 'w') {
			rs.up = false;
		}
		if (kr == 's') {
			rs.dw = false;
		}

	}
}
