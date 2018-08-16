package mymain;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class IsGameOver {

	DDongManager ddm;
	Bate bate;
	Timer timer;
	ExplosionManager exp;
	int hit;

	public IsGameOver() {
		// TODO Auto-generated constructor stub
		super();
		hit = 3;
	}

	public IsGameOver(DDongManager ddm, Bate bate, Timer timer, ExplosionManager exp) {
		this();

		this.ddm = ddm;
		this.bate = bate;
		this.timer = timer;
		this.exp = exp;
	}

	public boolean isGameOver() {
		List<DDong> ddong_list = ddm.ddong_list;
		System.out.println(ddong_list.size() + " " + ddm.maxDDongSize);
		for (int i = 0; i < ddong_list.size(); i++) {

			if (ddong_list.get(i).pos.intersects(bate.pos)) {
				hit--;
				exp.make_explosion(ddong_list.get(i).x + ddong_list.get(i).pos.width,
						ddong_list.get(i).y + ddong_list.get(i).pos.height);
				ddong_list.remove(i);
				exp.move();

				if (hit == 0) {
					this.timer.stop();
					return true;
				}
			}
		}
		return false;

	}

	public void collision_bullet_and_ddong() {
		for (int i = 0; i < bate.bulletManager.bullet_list.size(); i++) {
			Bullet bullet = bate.bulletManager.bullet_list.get(i);

			for (int k = 0; k < ddm.ddong_list.size(); k++) {
				DDong ddong = ddm.ddong_list.get(k);
				if (bullet.pos.intersects(ddong.pos)) {
					exp.make_explosion(bullet.pos.x + MyImages.img_bullet.getWidth(null) / 2, bullet.pos.y);
					ddm.ddong_list.remove(k);
					bate.bulletManager.bullet_list.remove(i);
				}
			}
		}
	}

	public void initGame() {

		ddm.ddong_list.removeAll(ddm.ddong_list);

		// ddm.ddong_list.r;
		ddm.count = 0;
		ddm.level = 1;
		hit = 3;
		bate.init_bate();

	}

	public void draw(Graphics g) {
		g.drawString("Level: " + ddm.level, MyConst.GamePan.GAMEPAN_W * 7 / 10, MyConst.GamePan.GAMEPAN_H * 1 / 15);
		g.drawString("Score: " + ddm.count, MyConst.GamePan.GAMEPAN_W * 1 / 20, MyConst.GamePan.GAMEPAN_H * 1 / 15);
		g.drawString("YourLife: " + hit, MyConst.GamePan.GAMEPAN_W * 1 / 20, MyConst.GamePan.GAMEPAN_H * 3 / 15);
	}

}
