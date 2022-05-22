import java.util.Vector;

public class GameFrame extends MyFrame {
	public void run() {
		GameWorld.player=new Player(100, 300, 0, 0);
		addKeyListener(GameWorld.player);
		GameWorld.stage=0;
		GameWorld.score=0;
		while(true) {
			GameWorld.player.x=100;
			GameWorld.player.y=300;
			GameWorld.playerBullets=new Vector<PlayerBullet>();
			GameWorld.enemies=new Vector<Enemy>();
			GameWorld.enemies.add(new EnemyBase(100,50,GameWorld.stage*3,0));
			GameWorld.enterPressed=false;
			GameWorld.RkeyPressed=false;
			while(true) {
				clear();
				if(GameWorld.stage==0) {
					setColor(0,0,0);
					drawString("Press Enter key", 80, 180, 25);
					drawString("to start game", 92, 210, 25);
					if(GameWorld.enterPressed) {
						GameWorld.stage++;
						break;
					}
				}
				if(GameWorld.stage>0) {
					setColor(0,0,0);
					drawString("Stage = "+GameWorld.stage, 30, 50, 15);
					drawString("Score = "+GameWorld.score, 270, 370, 15);
					GameWorld.player.draw(this);
					GameWorld.player.move();
					movePlayerBullets();
					moveEnemies();
					checkPlayerAndEnemies();
					checkPlayerBulletsAndEnemies();
				}
				if(GameWorld.enemies.size()==0) {
					setColor(0,0,0);
					drawString("Clear!", 130, 150, 40);
					drawString("press Enter key to go Next", 50, 185, 20);
					drawString("press E key to End", 80, 210, 20);
					if(GameWorld.enterPressed) {
						GameWorld.stage++;
						break;
					}
					if(GameWorld.EkeyPressed) {
						GameWorld.stage=0;
						GameWorld.score=0;
						GameWorld.EkeyPressed=false;
						break;
					}
				}else if(GameWorld.player.y<0) {
					setColor(0,0,0);
					drawString("Game Ovar",90, 150, 40);
					drawString("press R key to Retry", 80, 185, 20);
					drawString("press E key to End", 80, 210, 20);
					if(GameWorld.RkeyPressed) {
						GameWorld.score=0;
						break;
					}
					if(GameWorld.EkeyPressed) {
						GameWorld.stage=0;
						GameWorld.score=0;
						GameWorld.EkeyPressed=false;
						break;
					}
				}
				sleep(0.03);
			}
		}

	}
	public void movePlayerBullets() {
		int i=0;
		while(i<GameWorld.playerBullets.size()) {
			PlayerBullet b=GameWorld.playerBullets.get(i);
			b.draw(this);
			b.move();
			if(b.y<0) {
				GameWorld.playerBullets.remove(i);
			}else {
				i++;
			}
		}
	}
	public void moveEnemies() {
		for(int i=0; i<GameWorld.enemies.size(); i++) {
			Enemy e=GameWorld.enemies.get(i);
			e.draw(this);
			e.move();
		}
		int i=0;
		while(i<GameWorld.enemies.size()) {
			Enemy e=GameWorld.enemies.get(i);
			if(e.y>400) {
				GameWorld.enemies.remove(i);
			}else {
				i++;
			}
		}
	}
	public void checkPlayerAndEnemies() {
		for(int i=0; i<GameWorld.enemies.size(); i++) {
			Enemy e=GameWorld.enemies.get(i);
			if(checkHit(GameWorld.player, e, 23, 25)) {
				System.out.print("You are dead.\n");
				GameWorld.player.y=-1000;
			}
		}
	}
	public void checkPlayerBulletsAndEnemies() {
		int i=0;
		while(i<GameWorld.playerBullets.size()) {
			PlayerBullet b=GameWorld.playerBullets.get(i);
			int j=0;
			int hits=0;
			while(j<GameWorld.enemies.size()) {
				Enemy e=GameWorld.enemies.get(j);
				if(checkHit(e, b, 30, 30)) {
					System.out.println("hit!");
					hits++;
					e.life--;
				}
				if(e.life<=0) {
					GameWorld.score+=e.score;
					GameWorld.enemies.remove(j);
				}else {
					j++;
				}
			}
			if(hits>0) {
				GameWorld.playerBullets.remove(i);
			}else {
				i++;
			}
		}
	}
	public boolean checkHit(Character a, Character b, int s, int t) {
		if(Math.abs(a.x-b.x)<=s && Math.abs(a.y-b.y)<=t) {
			return true;
		}else {
			return false;
		}
	}
}
