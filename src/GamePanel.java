import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	
	Timer timer;
	GameObject go;

	GamePanel(){
		timer = new Timer(1000/60, this);
		go = new GameObject(10, 10, 480, 780);
	}
	
	void startGame() {
		timer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		go.update();
		repaint();
	}
	
    @Override
    public void paintComponent(Graphics g){
    	go.draw(g);
    }
    
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char kp = (char) e.getKeyChar();
		if(kp=='a') {
			System.out.println("a");
			go.le = true;
		}
		else if(kp=='d') {
			System.out.println("d");
			go.ri = true;
		}
		else if(kp=='w') {
			System.out.println("w");
			go.up = true;
		}
		else if(kp=='s') {
			System.out.println("s");
			go.dw = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
