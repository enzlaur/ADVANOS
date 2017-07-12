package parallel.OrnamentalProblemTest;

/**
 * Created by laurenztolentino on 07/12/2017.
 */
public class Counter
{
	private int value = 0;

	public synchronized void increment()
	{
		int temp = value;
		value = temp + 1;
		System.out.println("V: " + value);
	}
}
