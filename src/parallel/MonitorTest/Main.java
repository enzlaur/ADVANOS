package parallel.MonitorTest;

/**
 * Created by laurenz on 12/07/2017.
 */
public class Main
{

	public static void main(String[] args)
	{
		CubbyHole c = new CubbyHole();
		Producer p1 = new Producer(c, 1);
		Consumer c1 = new Consumer(c, 1);

		p1.start();
		c1.start();
	}
}
