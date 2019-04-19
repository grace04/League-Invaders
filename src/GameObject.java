import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {

	int x;
	int y;
	int width;
	int height;
	boolean le;
	boolean ri;
	boolean up;
	boolean dw;
	boolean isAlive = true;
	Rectangle collisionBox;

	GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		collisionBox = new Rectangle(x, y, width, height);
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
		collisionBox.setBounds(x, y, width, height);
	}

	void draw(Graphics g) {
		g.fillRect(x, y, 50, 50);
	}
}
