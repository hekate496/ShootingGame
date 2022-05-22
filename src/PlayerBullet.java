
public class PlayerBullet extends Character {
	public PlayerBullet(double x, double y, double vx, double vy) {
		//Characterクラスのコンストラクタ呼び出し
		super(x, y, vx, vy);
	}
	public void draw(MyFrame f) {
		f.setColor(255, 246, 127);
		f.fillRect(x+10, y, 10, 10);
		f.setColor(255, 241, 0);
		f.fillRect(x+13, y+3, 4, 4);
	}

}
