/**
 * 
 */
package exercise5.bytestream.data;

import java.io.DataInputStream;
import java.io.FileInputStream;

/**
 * @author yuqin
 *
 */
public class RainfallDataProcessor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//	1. Locate the source of the input stream
		String sourceFile = "simpangAmpatRainfallData.txt";
		System.out.println("Read data from " + sourceFile); 
		
		//	2. Construct the object for the input stream
		try (DataInputStream dis = new DataInputStream(
				new FileInputStream(sourceFile))) {
		
			//	Declare variables
			double rate = 0, totalRate = 0; 
			int counter = 0;
			String date;
			
			System.out.println("\nDate\t\tRainfall");
				
			while(dis.available() > 0) {
				
				//	3. Read the data from the input stream
				date = dis.readUTF();
				rate = dis.readDouble();
				System.out.println(date + "\t" + rate);
				
				counter ++;
				totalRate += rate;
			}
			
			//	compute and display the average of the rainfall
			double average = totalRate/counter;
			String formattedAverage = String.format("%.2f", average);
			System.out.println("\nAverage of the rainfall : " + formattedAverage);
			
			//	4. Close the
			dis.close();
			
		} 
		catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		System.out.println("\nProgram has ended.");
		
	}

}
