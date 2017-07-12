package parallel.ParallelTest2;

import static Util.Prints.print;
import static Util.Prints.println;

/**
 * Created by laurenztolentino on 07/13/2017.
 */
public class CountStorage
{
	int[] countTable = new int[10];
	int total = 0;

	public CountStorage()
	{
		this.countTable = populateTable();
	}

	public int[] populateTable() {
		for (int i = 0; i < 10; i++) {
			countTable[i] = 0;
		}
		return countTable;
	}

	public void put(int[] newTable)
	{
		this.countTable = addTwoTables(countTable, newTable);
		int temp = total;
		total = temp + 1;
		if(total > 1)
			printTable( this.countTable );
	}

	public int[] addTwoTables(int[] countTable, int[] newTable)
	{
		for(int i = 0; i < 10; i++ )
		{
			countTable[i] = countTable[i] + newTable[i];
		}
		return countTable;
	}

	public synchronized void get()
	{

	}

	public synchronized void getTables()
	{
		for( int i = 0; i < countTable.length; i++ )
		{

		}
	}

	public synchronized void setTables()
	{

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

}
