import java.awt.Graphics;

public class ObjectManager {

	Rocketship rs;

	ObjectManager(Rocketship rocket) {
		rs = new Rocketship(250, 700, 50, 50);
	}

	void update() {
		rs.update();
	}

	void draw(Graphics g) {
		rs.draw(g);
	}
}
