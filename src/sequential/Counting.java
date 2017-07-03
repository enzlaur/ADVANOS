package sequential;

/**
 * Created by laurenz on 03/07/2017.
 */
public class Counting
{

	/**
	 * Main sorting algorithm goes here.
	 * @param numList
	 * @return
	 */
	int[] sort(int[] numList)
	{
		println("Running counting sort");
		// Read the
		int[] temp = findMinAndMax(numList);
		int min = temp[0]; int max = temp[1]; int offset = max - min;
		int[] countTable = new int[offset];
		// initialize count table content to contain 0s at the start
		countTable = initializeArraytable(countTable);
		// perform counting
		for( int i = 0; i < offset; i++ )
		{
			println(numList[i]);
			++countTable[numList[i]];
		}
		for( int num : countTable )
		{
			print(num + " ");
		}
		return null;
	}

	int[] initializeArraytable(int[] countTable)
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
		static int numList[] = { 4,2,3,7,5 };

		public static void main(String[] args)
		{
			Counting ct = new Counting();
			ct.sort(numList);
			System.out.println("Hello");
		}
	}
}
