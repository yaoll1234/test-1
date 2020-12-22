/**
 * 实现runable接口
 * 	创建实现了runnable接口的类
 * 	实现接口中的run方法
 * 	创建实现类的对象
 * 	将此对象作为参数传递到thread类的构造方法中，创建thread类对象
 * 	通过thread类对象调用start（）
 */
public class WindowDemo1 {
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

	public void run() {
		while (true){
			if (ticket > 0){
				System.out.println(Thread.currentThread().getName() + "::::::" + ticket);
				ticket--;
			}else {
				break;
			}

		}
	}
}