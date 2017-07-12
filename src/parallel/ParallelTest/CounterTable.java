package parallel.ParallelTest;

/**
 * Created by laurenztolentino on 07/12/2017.
 */
public class CounterTable
{
	int[] countTable = new int[10];
	int leftPos = 0;
	int rightPos;

	public CounterTable(int[] originalTable)
	{
		this.countTable = populateTable();
		this.rightPos = originalTable.length - 1;
	}

	public int[] populateTable()
	{
		for(int i = 0; i <= rightPos; i++)
		{
			countTable[i] = 0;
		}
		return countTable;
	}


	public void increment(int index)
	{
		int temp = countTable[index];
		countTable[index] = temp + 1;
//		println("Incremented: " + index + " to " + countTable[index]);
	}

	public void updateLeftPos()
	{
		leftPos++;
	}

	public void updateRightPos()
	{
		rightPos--;
	}

	public static void println(Object obj)
	{
		System.out.println("" + obj.toString());
	}

	public static void print(Object obj)
	{
		System.out.print("" + obj.toString());
	}


	public int[] getCountTable() {
		return countTable;
	}

	public int getLeftPos() {
		return leftPos;
	}

	public int getRightPos() {
		return rightPos;
	}

}
