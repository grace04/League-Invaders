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
		if (le == true) {
			x -= 15;
		}
		if (ri == true) {
			x += 15;
		}
		if (up == true) {
			y -= 15;
		}
		if (dw == true) {
			y += 15;
		}
	}

	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, 50, 50);
	}
}
