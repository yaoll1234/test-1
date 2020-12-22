

/**
 * 线程通信实例：两个线程交替打印数字1-100
 */

public class CommunicationTest {
	public static void main(String[] args) {
		Number number = new Number();
		Thread t1 = new Thread(number);
		Thread t2 = new Thread(number);

		t1.setName("线程1");
		t2.setName("线程2");

		t1.start();
		t2.start();
	}
}
class Number implements Runnable{
	private int num = 1;

	@Override
	public void run() {
		while (true){

			synchronized (this) {
				notify();
				if(num <= 100){
					System.out.println(Thread.currentThread().getName() + ":::::::" + num);
					num++;

					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else {
					break;
				}
			}
		}
	}
}