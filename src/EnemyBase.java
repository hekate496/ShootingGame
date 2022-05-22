
public class EnemyBase extends Enemy {
	public EnemyBase(double x, double y, double vx, double vy) {
		super(x, y, vx, vy);
		life=20;
		score=10;
	}
	public void draw(MyFrame f) {
		f.setColor(0, 128, 0);
		f.fillRect(x, y, 32, 32);
		f.setColor(200, 200, 200);
		f.fillRect(x-16, y+8, 64, 16);
	}
	public void move() {
		super.move();
		if(x>320)vx=-GameWorld.stage*3;
		if(x<80)vx=GameWorld.stage*3;

		if(GameWorld.stage==1) {
			if(Math.random()<GameWorld.stage*0.005) {
				GameWorld.enemies.add(new StraightEnemy(x,y,0,5));
			}
		}
		if(GameWorld.stage==2) {
			if(Math.random()<GameWorld.stage*0.005) {
				GameWorld.enemies.add(new StraightEnemy(x,y,0,5));
			}
			if(Math.random()<GameWorld.stage*0.005) {
				GameWorld.enemies.add(new RandomEnemy(x,y,0,4));
			}
		}
		if(GameWorld.stage==3) {
			if(Math.random()<GameWorld.stage*0.005) {
				GameWorld.enemies.add(new StraightEnemy(x,y,0,5));
			}
			if(Math.random()<GameWorld.stage*0.005) {
				GameWorld.enemies.add(new RandomEnemy(x,y,0,4));
			}
			if(Math.random()<GameWorld.stage*0.005) {
				GameWorld.enemies.add(new DropEnemy(x,y,0,2));
			}
		}

		if(GameWorld.stage>3) {
			if(Math.random()<GameWorld.stage*0.004) {
				GameWorld.enemies.add(new StraightEnemy(x,y,0,3+GameWorld.stage*0.5));
			}
			if(Math.random()<GameWorld.stage*0.003) {
				GameWorld.enemies.add(new RandomEnemy(x,y,0,2+GameWorld.stage*0.3));
			}
			if(Math.random()<GameWorld.stage*0.003) {
				GameWorld.enemies.add(new DropEnemy(x,y,0,GameWorld.stage*0.3));
			}
			if(Math.random()<GameWorld.stage*0.003) {
				GameWorld.enemies.add(new CurveEnemy(x,y,0,1+GameWorld.stage*0.5));
			}
		}
	}
}
