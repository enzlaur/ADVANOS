package parallel.ParallelTest;


/**
 * Created by laurenztolentino on 07/13/2017.
 */
public class LeftPointer extends Thread
{
	private int[] originalTable;
	private CounterTable counterTable;
	private int num;

	public LeftPointer(int[] originalTable, CounterTable counterTable, int num)
	{
		this.originalTable = originalTable;
		this.counterTable = counterTable;
		this.num = num;
	}

	public void run()
	{
		try
		{
			for( int i = 0; i < originalTable.length; i++ )
			{
				int temp = originalTable[i];
				counterTable.increment(temp);
//				int leftPos = counterTable.getLeftPos();
//				int index = originalTable[leftPos];
//				counterTable.increment(index);
				counterTable.updateLeftPos();
				sleep(0);
			}
//			if( counterTable.getLeftPos() >= counterTable.getRightPos() )
//			{
//				printTable( counterTable.getCountTable() );
//			}
		}
		catch ( InterruptedException e)
		{}

	}

//	public static void printTable(int[] table)
//	{
//		println("");
//		for(int i = 0; i < table.length; i++)
//		{
//			print(table[i] + " ");
//		}
//
//		println("");
//	}

	public static void println(Object obj)
	{
		System.out.println("" + obj.toString());
	}

	public static void print(Object obj)
	{
		System.out.print("" + obj.toString());
	}
}
