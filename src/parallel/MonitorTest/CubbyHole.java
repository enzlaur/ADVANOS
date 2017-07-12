package parallel.MonitorTest;

/**
 * Created by laurenz on 12/07/2017.
 */
public class CubbyHole
{
	private int contents;
	private boolean available = false;

	public synchronized int get()
	{
		while( available == false )
		{
			try
			{
				wait();
			}
			catch ( InterruptedException e)
			{
				System.out.println("oh shit");
			}
		}
		available = false;
		notifyAll();
		return contents;
	}

	public synchronized void put(int value)
	{
		while ( available == true )
		{
			try
			{
				wait();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		contents = value;
		available = true;
		notifyAll();
	}

	static class prodTest
	{

	}
}
