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
	
	GameObject(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	void update() {
		if(le==true) {
			x -= 15;
		}
		else if(le==false) {
			x -= 0;
		}
		if(ri==true) {
			x += 15;
		}
		else if(ri==false) {
			x += 0;
		}
		if(up==true) {
			y -= 15;
		}
		else if(up==false) {
			y -= 0;
		}
		if(dw==true) {
			y += 15;
		}
		else if(dw==false) {
			y += 0;
		}
	}
	
	void draw(Graphics g) {
		g.fillRect(x, y, 50, 50);
	}
}
