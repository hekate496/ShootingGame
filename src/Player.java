import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends Character implements KeyListener {
	public Player(double x, double y, double vx, double vy) {
		//Characterクラスのコンストラクタ呼び出し
		super(x, y, vx, vy);
	}
	
	public void draw(MyFrame f) {
		f.setColor(199, 0, 68);
		f.fillRect(x, y+20, 30, 10);
		f.setColor(125, 0, 0);
		f.fillRect(x+10, y, 10, 30);
	}
	
	public void move() {
		super.move();
		if(x<0)x=0;
		if(x>370)x=370;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//キーボードが押されたときの処理
		if(e.getKeyCode()==KeyEvent.VK_A) {
			vx=-5;
		}
		if(e.getKeyCode()==KeyEvent.VK_D) {
			vx=5;
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			GameWorld.playerBullets.add(new PlayerBullet(x,y,0,-15));
			System.out.println("num of bullets="+GameWorld.playerBullets.size());
		}
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			System.out.println("Enter key is pressed");
			GameWorld.enterPressed=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_R) {
			System.out.println("R key is pressed");
			GameWorld.RkeyPressed=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_E) {
			System.out.println("E key is pressed");
			GameWorld.EkeyPressed=true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//キーボードが話されたときの処理
		if(e.getKeyCode()==KeyEvent.VK_A) {
			vx=0;
		}
		if(e.getKeyCode()==KeyEvent.VK_D) {
			vx=0;
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		//
		
	}

}
