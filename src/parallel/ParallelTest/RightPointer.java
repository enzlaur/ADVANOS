package parallel.ParallelTest;

/**
 * Created by laurenztolentino on 07/13/2017.
 */
public class RightPointer extends Thread
{
	private int[] originalTable;
	private CounterTable counterTable;
	private int num;

	public RightPointer(int[] originalTable, CounterTable counterTable, int num)
	{
		this.originalTable = originalTable;
		this.counterTable = counterTable;
		this.num = num;
	}

	public void run()
	{
		try
		{
			for(int i = 0; i < originalTable.length; i++ )
			{
				int temp = originalTable[i];
				counterTable.increment(temp);
//				int  rightPos = counterTable.getRightPos();
//				int index = originalTable[rightPos];
////				println("rightPos: " + rightPos);
//				counterTable.increment( index );
				counterTable.updateRightPos();
				sleep(0);
			}
			if( counterTable.getLeftPos() >= counterTable.getRightPos() )
			{
				printTable( counterTable.getCountTable() );
			}
		}
		catch ( InterruptedException e)
		{}

	}

	public static void printTable(int[] table)
	{
		println("");
		for(int i = 0; i < table.length; i++)
		{
			print(i + " ");
		}
		println("");
		for(int i = 0; i < table.length; i++)
		{
			print(table[i] + " ");
		}
		println("");
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - Pointer.getStartTime();
		System.out.println("Time: " + totalTime);
	}

	public static void println(Object obj)
	{
		System.out.println("" + obj.toString());
	}

	public static void print(Object obj)
	{
		System.out.print("" + obj.toString());
	}
}
