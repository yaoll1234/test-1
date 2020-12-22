/**
 * 多窗口售票
 */
public class WindowDemo {
	public static void main(String[] args){
		Windows window1 = new Windows();
		Windows window2 = new Windows();
		Windows window3 = new Windows();


		window1.setName("窗口1");
		window2.setName("窗口2");
		window3.setName("窗口3");

		window1.start();
		window2.start();
		window3.start();
	}
}


class Windows extends Thread{
	private static int ticket = 100;

	@Override
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

// 懒汉式线程安全解决
class Bank{
	private Bank(){

	}
	private static Bank instance = null;


	/**
	 * // 方式一 效率低
	 * public Bank getInstance(){
	 *
	 * 		synchronized (Bank.class) {
	 * 			if(instance == null){
	 * 				instance = new Bank();
	 *                        }
	 * 			return instance;
	 * 	  }
	 * 	}
	 *
	 */

	public static Bank getInstance(){

		if(instance == null){

			synchronized (Bank.class) {
				if(instance == null){

					instance = new Bank();
				}
			}
		}
		return instance;
	}

}