
public class Character {
	double x,y,vx,vy;
	public Character(double x, double y, double vx, double vy) {
		//�R���X�g���N�^
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
	}
	public void move() {
		//move���\�b�h
		x+=vx;
		y+=vy;
	}
	public void draw(MyFrame f) {
		//draw���\�b�h
		f.setColor(0, 128, 0);
		f.fillRect(x, y, 30, 30);
	}

}
