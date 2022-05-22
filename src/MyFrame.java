
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * �O���t�B�b�N�X���ȒP�ɕ\������E�B���h�E�N���X
 * @author Cho Shinya
 *
 */
public class MyFrame extends Frame implements Runnable {
	BufferedImage im;
	/**
	 * fillRect ���ŗp����`��F
	 */
	Color col=Color.BLACK;
	/**
	 * �A�j���[�V�����p�̃X���b�h
	 */
	Thread t;
	public Color bgColor=new Color(255,255,255);
	/**
	 * �E�B���h�E���쐬���A�\������B
	 */
	public MyFrame() {
		super();
		setSize(400,400	);
		im=new BufferedImage(400, 400, BufferedImage.TYPE_INT_ARGB);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				System.exit(1);
			}
		});
		//autoSave();
	}
	public synchronized void saveImage(File dst) throws IOException {
		ImageIO.write(im, "png", dst);
	}
	/*public void autoSave() {
		final Object t=this;
		Runnable r = new Runnable() {
			public void run() {
				try {
					for (int i=1 ; i<=5; i++) {
						Thread.sleep(1000);
						String pathname = "screenshots"+File.separator+t.getClass().getSimpleName()+"_"+new TDate().toString("yyMMdd_hhmmss")+"_"+i+".png";
						saveImage(new File(pathname));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		new Thread(r).run();
	}*/
	/**
	 * �ŏ���paint���Ă΂ꂽ�Ƃ��ɁA�X���b�h�𓮂����ăA�j���[�V�����𐧌䂷��
	 */
	@Override
	public void paint(Graphics g) {
		g.drawImage(im, 0 ,0 , null);
		if (t==null) {
			t=new Thread(this);
			t.start();
		}
	}
	/**
	 * �l�p�`��`�悷��B�F��setColor �Ŏw��B
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
        public synchronized void fillRect(double x, double y, double w, double h) {
               fillRect((int) x, (int) y, (int) w, (int) h);
        }
	public synchronized void fillRect(int x,int y,int w, int h) {
		Graphics g=getImageGraphics();
		if (g!=null) {
			g.setColor(col);
			g.fillRect(x, y, w, h);
		}
		g=getGraphics();
		if (g!=null) {
			g.setColor(col);
			g.fillRect(x, y, w, h);
		}
	}
	public synchronized void clear() {
		Color s=col;
		col=bgColor;
		fillRect(0,0,getWidth(),getHeight());
		col=s;
	}
	public synchronized void fillOval(int x,int y,int w, int h) {
		Graphics g=getImageGraphics();
		if (g!=null) {
			g.setColor(col);
			g.fillOval(x, y, w, h);
		}
		g=getGraphics();
		if (g!=null) {
			g.setColor(col);
			g.fillOval(x, y, w, h);
		}
	}
	private Graphics getImageGraphics() {
		return im.getGraphics();
	}
	/**
	 * �`��F���w�肷��B
	 * @param red
	 * @param green
	 * @param blue
	 */
	public void setColor(int red, int green, int blue) {
		if (red<=0) red=0;
		if (red>255) red=255;
		if (green<=0) green=0;
		if (green>255) green=255;
		if (blue<=0) blue=0;
		if (blue>255) blue=255;
		col=new Color(red,green,blue);
	}
	/**
	 * ��莞�ԑ҂�
	 * @param time
	 */
	public void sleep(double time) {
		try {
			fillRect(0,0,0,0);// �_�~�[�F���ꂪ�Ȃ���XP�ōŌ�̎l�p�`�������
			Thread.sleep((int)(time*1000));

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/**
	 * �A�j���[�V�������s�����́A�w�K�҂�run���\�b�h���I�[�o���C�h����
	 */
	public void run() {
	}
	public synchronized void fillOval(double x, double y, double w, double h) {
		fillOval((int)x,(int)y,(int)w,(int)h);

	}
	public synchronized void drawString(String str, int x,int y, int size) {
		Graphics g=getImageGraphics();
		if (g!=null) {
			g.setColor(col);
			g.setFont(new Font("Monospaced",0,size));
			g.drawString(str, x, y);
		}
		//if (locked) return;
		g=getGraphics();
		if (g!=null) {
			g.setColor(col);
			g.setFont(new Font("Monospaced",0,size));
			g.drawString(str, x, y);
		}
	}

}
