import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {

	int speed;

	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 5;
		// TODO Auto-generated constructor stub
	}

	void update() {
		super.update();
		if (le == true) {
			x -= 5;
		}
		if (ri == true) {
			x += 5;
		}
		if (up == true) {
			y -= 5;
		}
		if (dw == true) {
			y += 5;
		}
	}

	void draw(Graphics g) {
		g.drawImage(GamePanel.rocketImg, x, y, width, height, null);
	}
}
