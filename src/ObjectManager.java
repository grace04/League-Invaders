import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {

	Rocketship rs;
	LeagueInvaders li;
	GameObject go;
	ArrayList<Projectile> pro = new ArrayList<Projectile>();
	ArrayList<Alien> ali = new ArrayList<Alien>();
	long enemyTimer = 0;
	int enemySpawnTime;

	ObjectManager(Rocketship rocket) {
		this.rs = rocket;
	}

	void update() {
		rs.update();
		for (Projectile pr : pro) {
			pr.update();
		}
		for (Alien al : ali) {
			al.update();
		}
	}

	void draw(Graphics g) {
		rs.draw(g);
		for (Projectile pr : pro) {
			pr.draw(g);
		}
		for (Alien al : ali) {
			al.draw(g);
		}
	}

	void addProjectile(Projectile proj) {
		pro.add(proj);
	}

	void addAlien(Alien alie) {
		ali.add(alie);
	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Alien(new Random().nextInt(li.WI), 0, 50, 50));
			enemyTimer = System.currentTimeMillis();
		}
	}

	void purgeObjects() {
		if (go.isAlive == false) {

		}
	}
}
