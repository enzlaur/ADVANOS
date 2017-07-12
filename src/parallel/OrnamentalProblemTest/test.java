package parallel.OrnamentalProblemTest;

/**
 * Created by laurenz on 12/07/2017.
 */
public class test
{
	public static void main(String[] args)
	{
		Gate west, east;
		Counter c = new Counter();

		west = new Gate(c, 0);
		east = new Gate(c, 1);
		west.start();
		east.start();
	}

}
