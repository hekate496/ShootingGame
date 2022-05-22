
public class RandomEnemy extends Enemy {
	public RandomEnemy(double x, double y, double vx, double vy) {
		super(x, y, vx, vy);
		life=2;
	}
	public void draw(MyFrame f) {
		f.setColor(193, 137, 235);
		f.fillRect(x, y, 10, 20);
		f.fillRect(x+20, y, 10, 20);
		f.fillRect(x+10, y+20, 10, 10);
	}
	public void move() {
		super.move();
		vx=Math.random()*(10+GameWorld.stage*3)-(10+GameWorld.stage*3)*Math.random();
	}

}
