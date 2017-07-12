package parallel.ParallelTest2;

import Util.IOMaster;
import static Util.Prints.*;
import java.util.Arrays;

/**
 * Created by laurenztolentino on 07/13/2017.
 */
public class Conductor
{
	public static void main(String[] args) throws Exception
	{
		IOMaster ioMaster = new IOMaster();
		CountStorage countStorage = new CountStorage();
		int[] originalTable = ioMaster.readFileToNumList();
		int[] ot1 = Arrays.copyOfRange(originalTable, 0, originalTable.length/2);
		int[] ot2 = Arrays.copyOfRange(originalTable, (originalTable.length/2), originalTable.length);
		Counter c1 = new Counter(ot1, countStorage);
		Counter c2 = new Counter(ot2, countStorage);
		c1.start();
		c2.start();


	}
}
