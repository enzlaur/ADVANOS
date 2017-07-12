package sequential;

import Util.IOMaster;
import Util.Numlist;


/**
 * Created by laurenz on 03/07/2017.
 */
public class Counting
{
	int[] _numList;
	int _max;
	boolean _printContents = true;

	public Counting()
	{}

	public Counting(boolean _printContents)
	{
		this._printContents = _printContents;
	}

	/**
	 * Main sorting algorithm goes here.
	 * @param numList
	 * @return
	 */
	public int[] sort(int[] numList)
	{
		println("Running counting sort");
		/* Fnd the min and max numbers that will be used to determine the range
		 * of the count table */
		int[] temp 	= findMinAndMax(numList);
		int min 	= temp[0];
		int max 	= temp[1];
		int offset 	= max - min; // used in initial counting
		/* initialize countTable to be used as the list for telling
		you how many times the number x appeared in the original list (numList) */
		int[] countTable = new int[max + 1];
		/* initialize count table content to contain 0s at the start */
		countTable = initializeArraytable(countTable);
		/* update global variables to be used for printing purposes only */
		_numList 	= numList;
		_max 		= max;
		// final sorted list variable
		int[] sortedList = new int[numList.length];

		/* perform initial counting (the actual frequency count of each element inside the original list)*/
		initialCountStep(countTable, numList);
//		/* performs table adjustments */
//		incrementTableStep(countTable);
//		/* shifting step */
//		shiftCountToTheRightStep(countTable);
//
//		/* perform actual placing */
//		for(int i = 0; i < numList.length; i++)
//		{
////			sortedList[countTable[numList[i]]] = countTable[numList[i]];
//			sortedList[countTable[numList[i]]] = numList[i];
//			countTable[numList[i]] = countTable[numList[i]] + 1;
//		}
//		printFinalTable( sortedList );
		return sortedList;
	}

	public int[] initialCountStep(int[] countTable, int[] numList)
	{
		for( int i = 0; i < numList.length; i++ )
		{
			countTable[numList[i]]++;
		}
		printContents(countTable, _numList, _max);
		return countTable;
	}

	public int[] incrementTableStep(int[] countTable)
	{
		/* add numbers in the table to the right accumulatively */
		for(int i = 0; i < countTable.length; i++)
		{
			if(i > 0)
			{
				countTable[i] = countTable[i-1] + countTable[i];
			}
		}
		printContents(countTable, _numList, _max);
		return countTable;
	}

	public int[] shiftCountToTheRightStep(int[] countTable)
	{
		for( int i = countTable.length - 1; i >=0; i-- )
		{
			if(i > 0)
			{
				countTable[i] = countTable[i-1];
			} else
			{
				countTable[0] = 0;
			}
		}
		printContents(countTable, _numList, _max);
		return countTable;
	}

	public void printContents(int[] countTable, int[] numList, int max)
	{
		if( _printContents = true)
		{
			/**/
			println("Current Count Table Contents");
			/* table header */
			for(int i = 0; i < max+1; i++)
			{
				print(i + " ");
			}
			println("");
			for(int i = 0; i < max+1; i++ )
			{
				print("--");
			}
			println("");
			for( int num : countTable )
			{
				print(num + " ");
			}
			println("");
		}

	}

	public void printFinalTable(int[] sortedList)
	{
		println("Final Table (sorted): ");
		for(int n : sortedList)
		{
			print(n + " ");
		}
	}


	public int[] initializeArraytable(int[] countTable)
	{
		for( int i = 0; i < countTable.length; i++ )
		{
			countTable[i] = 0;
		}
		return countTable;
	}

	/**
	 * Finds the smallest value and the largest value in the given list.
	 * @param numList
	 * List provided by the user.
	 * @return
	 * An array wherein:
	 * Index 0 = Smallest value
	 * Index 1 = Largest value
	 */
	int[] findMinAndMax(int[] numList)
	{
		int currMin = -99;
		int currMax = 9999;
		int[] result = {0,0};
		for(int num : numList)
		{
			if( currMin < 0 && currMax > 1000)
			{
				currMin = num;
				currMax = num;
			}
			else
			{
				if( num < currMin )
				{
					currMin = num;
				}
				if( num > currMax )
				{
					currMax = num;
				}
			}
		}
		result[0] = currMin;
		result[1] = currMax;
		return result;
	}

	static void println(Object obj)
	{
		System.out.println(obj.toString() + "");
	}

	static void print(Object obj)
	{
		System.out.print(obj.toString() + "");
	}
	/**
	 * Does nothing except for testing.
	 */
	static class Test
	{

		static int numList[] = {1,1,1,1,1,1,2,3,3,4,6,7,3,2};

		public static void main(String[] args) throws Exception
		{
			IOMaster ioMaster = new IOMaster();
			Counting ct = new Counting(true);

			numList = ioMaster.readFileToNumList();

//			println("Original List: ");
//			for(int n : numList)
//			{
//				print(n + " ");
//			}
			long startTime = System.currentTimeMillis();
			ct.sort(numList);
			long endTime   = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			System.out.println("Time: " + totalTime);
		}
	}
}
