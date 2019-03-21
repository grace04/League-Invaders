import java.awt.Graphics;

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

	GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
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
		g.fillRect(x, y, 50, 50);
	}
}
