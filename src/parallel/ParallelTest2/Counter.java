package parallel.ParallelTest2;

import static Util.Prints.println;
import static Util.Prints.print;
/**
 * Created by laurenztolentino on 07/13/2017.
 */
public class Counter extends Thread
{
	// must contain only a portion of the original problem
	private int[] originalTable;
	private int[] countTable = new int[10];
	private CountStorage countStorage;

	public Counter(int[] originalTable, CountStorage countStorage)
	{
		this.originalTable 	= originalTable;
		this.countTable 	= populateTable();
		this.countStorage 	= countStorage;
	}

	public int[] populateTable() {
		for (int i = 0; i < 10; i++) {
			countTable[i] = 0;
		}
		return countTable;
	}

	public static void printTable(int[] table)
	{
		println("");
		for(int i = 0; i < table.length; i++)
		{
			print(table[i] + " ");
		}

		println("");
	}


//	public void run()
//	{
//		try
//		{
//			long startTime = System.currentTimeMillis();
//			for(int i = 0; i < originalTable.length; i++ )
//			{
//				countTable[originalTable[i]]++;
//			}
//			printTable( countTable );
//			long endTime   = System.currentTimeMillis();
//			long totalTime = endTime - startTime;
//			System.out.println("Time: " + totalTime);
//		}
//		catch ( Exception e)
//		{
//
//		}
//	}

	public void run()
	{
		try
		{
			long startTime = System.currentTimeMillis();
			for(int i = 0; i < originalTable.length; i++ )
			{
				countTable[originalTable[i]]++;
			}
			long endTime   = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			System.out.println("Time: " + totalTime);
			countStorage.put(countTable);
		}
		catch ( Exception e)
		{

		}
	}

	public synchronized int[] getCountTable() {
		return countTable;
	}
}
