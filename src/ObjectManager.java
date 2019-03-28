import java.awt.Graphics;

public class ObjectManager {

	Rocketship rs;

	ObjectManager(Rocketship rocket) {
		this.rs = rocket;
	}

	void update() {
		rs.update();
	}

	void draw(Graphics g) {
		rs.draw(g);
	}
}
