import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {

	Rocketship rs;
	GameObject go;
	ArrayList<Projectile> pro = new ArrayList<Projectile>();
	ArrayList<Alien> ali = new ArrayList<Alien>();
	long enemyTimer = 0;
	int enemySpawnTime = 500;
	int kill = 0;

	ObjectManager(Rocketship rocket) {
		this.rs = rocket;
	}

	void update() {
		rs.update();
		purgeObjects();
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
			addAlien(new Alien(new Random().nextInt(LeagueInvaders.WI), 0, 50, 50));
			enemyTimer = System.currentTimeMillis();
		}
	}

	void checkCollision() {
		for(Alien al : ali) {
			if(rs.collisionBox.intersects(al.collisionBox)) {
				rs.isAlive = false;
			}
			for(Projectile pr : pro) {
				if(pr.collisionBox.intersects(al.collisionBox)) {
					al.isAlive = false;
					pr.isAlive = false;
				}
			}
		}
	}
	
	void purgeObjects() {
		for(int i=0; i<pro.size(); i++) {
			if(pro.get(i).isAlive==false) {
				pro.remove(i);
			}
		}
		
		for(int i=0; i<ali.size(); i++) {
			if(ali.get(i).isAlive==false) {
				ali.remove(i);
				kill++;
			}
		}
	}
}
