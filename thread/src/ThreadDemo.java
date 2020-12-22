public class ThreadDemo {
	public static void main(String[] args){
		WindowRunnable window1 = new WindowRunnable();
		//Windows window2 = new Windows();
		//Windows window3 = new Windows();

		Thread t1 = new Thread(window1);
		Thread t2 = new Thread(window1);
		Thread t3 = new Thread(window1);
		t1.setName("窗口1");
		t2.setName("窗口2");
		t3.setName("窗口3");
		t1.start();
		t2.start();
		t3.start();
	}
}
class WindowRunnable implements Runnable{
	private  int ticket = 100;
	// 同步监视器
	Object obj = new Object();

	public void run() {
		while (true){
			//同步代码块
			synchronized (obj) {
				if (ticket > 0) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "::::::" + ticket);
					ticket--;
				} else {
					break;
				}
			}

		}
	}
}