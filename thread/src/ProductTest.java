

/**
 *  线程通信应用：生产者/消费者
 *
 */


class Clerk{
	private int productCount = 0;

	public synchronized void produceProduct() {
		if(productCount < 20){
			productCount++;
			System.out.println("生产者1开始生产第" + productCount + "个产品");
			notify();
		}else {
			// 等待消费者消费
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized void consumeProduct() {
		if (productCount > 0){
			System.out.println("消费者1开始消费第" + productCount + "个产品");
			productCount--;
			notify();
		}else {
			// 等待生产者生产
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Product extends Thread{
		private Clerk clerk;
	public Product(Clerk clerk){
		this.clerk = clerk;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "开始生产产品");

		while (true){
			try {
				sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			clerk.produceProduct();
		}

	}
}


class Consumer extends Thread{
	private Clerk clerk;
	public Consumer(Clerk clerk){
		this.clerk = clerk;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "开始消费产品");

		while (true){
			try {
				sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			clerk.consumeProduct();
		}
	}
}

public class ProductTest {
	public static void main(String[] args) {
		Clerk clerk = new Clerk();

		Product p1 = new Product(clerk);
		Consumer c1 = new Consumer(clerk);

		p1.setName("生产者1");
		c1.setName("消费者1");

		p1.start();
		c1.start();
	}

}