package parallel.MonitorTest;

/**
 * Created by laurenz on 12/07/2017.
 */
class Consumer extends Thread {
	private CubbyHole cubbyhole;
	private int number;

	public Consumer(CubbyHole c, int number) {
		cubbyhole = c;
		this.number = number;
	}

	public void run() {
		int value = 0;
		for (int i = 0; i < 10; i++) {
			value = cubbyhole.get();
			System.out.println("Consumer #" + this.number + " got: " + value);
		}
	}
}
