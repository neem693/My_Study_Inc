package mymain;

class MyRunnable implements Runnable {
	Object syncObj = new Object();

	public void run() {
		String name = Thread.currentThread().getName();

		while (true) {

			synchronized (syncObj) {

				syncObj.notify();//

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

public class MyMain_공정 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyRunnable runnable = new MyRunnable();
		Thread t1 = new Thread(runnable, "형님");
		Thread t2 = new Thread(runnable, "아우");

		t1.start();
		t2.start();

	}

}
