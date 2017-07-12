package Util;

/**
 * Created by laurenztolentino on 07/13/2017.
 */
public class OTableGenerator
{
	public static void main(String[] args)
	{
		IOMaster ioMaster = new IOMaster();
		int max = 10000000;
		int[] numlist = new int[max];

		for( int i = 0; i < max; i++ )
		{
			numlist[i] = (int)(Math.random() * 10);
		}

		try {
			ioMaster.writeNumListToFile(numlist);
		} catch (Exception e) {
			e.printStackTrace();
		}


//		System.out.print("int[] originalTable = {");
//		for(int i = 0; i < max; i++)
//		{
//			System.out.print( (int)(Math.random() * 10) );
//			if( i < max - 1 )
//			{
//				System.out.print( ", ");
//			}
//		}
//		System.out.print("};");
	}
}
