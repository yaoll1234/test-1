/**
 * 方式一：多线程创建继承thread
 * 1.创建继承thread的子类
 * 2。重写run方法
 * 3.创建thread类的子类对象
 * 4.通过此对象调用start方法，创建一个对象即一个线程
 *
 * 多个对象即多个线程
 */
 class MyThread extends Thread {
	@Override
	public void run() {
		for (int i = 0; i <100 ; i++) {
			if(i % 2 == 0){
				System.out.println(Thread.currentThread().getName()+":::::" + i);
			}
		}
	}
}

public class ThreadTest{
	public static void main(String[] args){
		MyThread myThread = new MyThread();

		//1、启动当前线程 2、调用当前线程的run()
		// start方法只能调用一次
		myThread.start();

		final Thread thread1 = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i <100 ; i++) {
					if(i % 2 != 0){
						System.out.println(Thread.currentThread().getName() + "######" + i+ "#######" );
					}
				}
			}
		};
		thread1.start();

		// 如下操作main方法中执行
		for (int i = 0; i <100 ; i++) {
			if(i % 2 != 0){
				System.out.println(Thread.currentThread().getName() +"**********" + i+ "**********" );
			}
		}
	}
}