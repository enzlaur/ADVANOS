package Util;

import java.io.*;

import static Util.Prints.println;
import static Util.Prints.print;

/**
 * Created by laurenztolentino on 07/13/2017.
 */
public class IOMaster {
	String fileAddress = "";
	String fileName = "n10m.txt";

	public IOMaster() {
		System.out.println("Launching IOMaster to read/write files");
	}

	public int[] readFileToNumList() throws Exception
	{
		int[] numList = new int[10000000];
		int content;
		BufferedReader br;
		int lineNumber = 0;
		try
		{
			br = new BufferedReader( new FileReader( fileName ) );
			while ( lineNumber < 10000000)
			{

				numList[lineNumber] = Integer.parseInt(br.readLine());
				lineNumber++;

			}
			println("\n Done reading from file.");
		}
		catch ( FileNotFoundException e)
		{
			e.printStackTrace();
		}

		return numList;
	}

	public void writeNumListToFile(int[] numlist) throws Exception
	{
		String completeFileName = fileAddress + "/" + fileName;
		PrintWriter writer = new PrintWriter(fileName, "UTF-8");
//		// Write the result to file
//		writer.println(toPrint);
		for(int n: numlist)
		{
			writer.println(n);
		}
		// Close the printer
		writer.close();
	}

	public static class testThis
	{
		public static void main(String[] args)
		{
			IOMaster ioMaster = new IOMaster();
			int[] k25;
			try {
				k25 = ioMaster.readFileToNumList();

				for(int i = 0; i < k25.length; i++)
				{
					print(k25[i] + " ");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}


		}
	}
}
