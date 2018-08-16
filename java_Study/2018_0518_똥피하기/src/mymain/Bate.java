package mymain;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Bate extends Item {
	int jump_interval;
	boolean jump;
	int x, y;
	int width;
	int height;
	int key_state;
	int draw_x;
	int draw_y;

	double space = 0.3;

	BulletManager bulletManager;

	public Bate(BulletManager bulletManager) {
		// TODO Auto-generated constructor stub

		width = MyImages.img_me.getWidth(null);
		height = MyImages.img_me.getHeight(null);
		x = (int) (MyConst.GamePan.GAMEPAN_W * 0.5);
		y = MyConst.GamePan.GAMEPAN_H - height;

		this.pos.x = x + (int) (width * 0.25);
		this.pos.y = y + (int) (height * 0.25);

		this.pos.width = (int) (width * 0.5);
		this.pos.height = (int) (height * 0.5);

		jump_interval = 480;
		jump = false;

		this.bulletManager = bulletManager;

	}

	public void init_bate() {

		x = (int) (MyConst.GamePan.GAMEPAN_W * 0.5);
		y = MyConst.GamePan.GAMEPAN_H - MyImages.img_me.getHeight(null);

		this.pos.x = x + (int) (width * 0.25);
		this.pos.y = y + (int) (height * 0.25);
	}

	@Override
	public boolean move() {
		// TODO Auto-generated method stub

		if ((key_state & MyConst.Key.LEFT) == MyConst.Key.LEFT)
			if (x <= 0) {
				this.pos.x = x + (int) (width * 0.25);
				this.x = 0;
			} else {
				this.pos.x -= 5;
				this.x -= 5;
			}
		if ((key_state & MyConst.Key.RIGHT) == MyConst.Key.RIGHT)
			if (x >= MyConst.GamePan.GAMEPAN_W - MyImages.img_me.getWidth(null)) {
				x = MyConst.GamePan.GAMEPAN_W - MyImages.img_me.getWidth(null);
				this.pos.x = x + (int) (width * 0.25);
			} else {
				this.pos.x += 5;
				x += 5;
			}
		if (((key_state & MyConst.Key.UP) == MyConst.Key.UP) && !jump) {
			jump = true;
			System.out.println(jump);
		}

		if ((key_state & MyConst.Key.FIRE) == MyConst.Key.FIRE) {
			System.out.println("--Fire--");
			bulletManager.make_bullet(x + width / 2, y);
		}

		// jump
		if (jump) {
			System.out.println(this.y);
			if (this.y >= jump_interval) {
				this.y -= 5;
				this.pos.y -= 5;
			} else {
				jump = false;

			}
		} else if (!jump && (this.y < MyConst.GamePan.GAMEPAN_H - height)) {
			this.y += 5;
			this.pos.y += 5;
		}
		return false;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub

		g.drawImage(MyImages.img_me, x, y, null);
		// g.drawRect(this.pos.x, this.pos.y, this.pos.width, this.pos.height);
		// this.pos.width+ rect_space_x, this.pos.height + rect_space_y);

	}

	public int getKey_state() {
		return key_state;
	}

	public void setKey_state(int key_state) {
		this.key_state = key_state;
	}

}
