package parallel.OrnamentalProblemTest;

/**
 * Created by laurenztolentino on 07/12/2017.
 */
public class Gate extends Thread
{
	private Counter ctr;
	private int number;


	public Gate(Counter c, int number)
	{
		this.ctr = c;
		this.number = number;
	}

	public void run()
	{
		int value = 0;
		try
		{
			for(int i = 0; i < 10; i++)
			{
				System.out.print(number + ": ");
				ctr.increment();
				sleep(1000);
			}
		}
		catch ( InterruptedException e)
		{
			System.out.println("SHIIIIIT");
		}
	}

}
