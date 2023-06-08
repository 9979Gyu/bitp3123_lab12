/**
 * 
 */
package exercise7.bytestream.data;

import java.io.PrintWriter;
import java.io.IOException;

/**
 * @author yuqin
 *
 */
public class RainfallDataWriter { 

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//	1. Determine the target storage for the output
		String filename = "rainfallData.txt";

		// Declare data
		String date[] = {"31/05/2023", "01/06/2023", "02/06/2023", 
				"03/06/2023", "04/06/2023", "05/06/2023"};
		double intensity[] = {5.0, 0.0, 0.0, 4.0, 1.0, 0.0}; 
		
		try {
			
			//	2. Construct Writer object
			PrintWriter printWriter = new PrintWriter(filename);
			
			String title = "Simpang Ampat Rainfall Data\n\nDate\t\tRainfall\n";
			printWriter.write(title);
			
			for(int index = 0; index < date.length; index ++) {
				 
				//	3. Print the data
				printWriter.print(date[index] + "\t");
				printWriter.print(intensity[index] + "\n");
				
				//	4. Flush the output stream
				printWriter.flush();
				
			}
			
			//	5. Close the output stream
			printWriter.close();
			
		} 
		catch (IOException e) {
			
			e.printStackTrace();
			
		}

		System.out.println("Data creation process has ended.");
	}

}
