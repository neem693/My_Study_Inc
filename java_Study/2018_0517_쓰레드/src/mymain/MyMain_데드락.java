package mymain;

class MyRunnable3 implements Runnable {
	Object syncObj = new Object();

	int money = 10000;

	public void run() {
		String name = Thread.currentThread().getName();

		while (true) {

			synchronized (syncObj) {
				//진입과 동시에
				//자원이 있으면 잠들어있는 쓰레드를 깨운다.
				//notify();
				System.out.printf("--[%s] 먼저 --\n", name);

				try {
					syncObj.wait();
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}

public class MyMain_데드락 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyRunnable3 runnable = new MyRunnable3();
		Thread t1 = new Thread(runnable, "형님");
		Thread t2 = new Thread(runnable, "아우");

		t1.start();
		t2.start();

	}

}
