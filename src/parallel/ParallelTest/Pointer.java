package parallel.ParallelTest;


import Util.IOMaster;

import java.util.Arrays;

/**
 * Created by laurenztolentino on 07/12/2017.
 */
public class Pointer
{
	static long startTime = 0;

	public static void main(String[] args) throws Exception
	{
		IOMaster ioMaster = new IOMaster();
		int[] originalTable = ioMaster.readFileToNumList();
		LeftPointer lp;
		RightPointer rp;
		CounterTable counterTable = new CounterTable(originalTable);

		int[] ot1 = Arrays.copyOfRange(originalTable, 0, (originalTable.length)/2);
		int[] ot2 = Arrays.copyOfRange(originalTable, (originalTable.length)/2, originalTable.length);

		lp = new LeftPointer(ot1, counterTable, 0);
		rp = new RightPointer(ot2, counterTable, 1);
		startTime = System.currentTimeMillis();
		lp.start();
		rp.start();
	}

	public static long getStartTime() {
		return startTime;
	}

	public static void printTable(int[] table)
	{
		for(int i = 0; i < table.length; i++)
		{
			print(table[i] + " ");
		}
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
