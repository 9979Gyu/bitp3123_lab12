/**
 * 
 */
package exercise5.bytestream.data;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author yuqin
 *
 */
public class RainfallDataGenerator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//	1. Determine the target storage for the output
		String filename = "simpangAmpatRainfallData.txt";

		// Declare data
		String date[] = {"31/05/2023", "01/06/2023", "02/06/2023", 
				"03/06/2023", "04/06/2023", "05/06/2023"};
		double rate[] = {5.0, 0.0, 0.0, 4.0, 1.0, 0.0}; 

		try {
			
			//	2. Construct the object for the DataOutputStream
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename));

			for(int index = 0; index < date.length; index++) {
				
				//	3. Write the data into the output stream
				dos.writeUTF(date[index]);
				dos.writeDouble(rate[index]);
				
				//	4. Flush the output stream
				dos.flush();
				
			}
			
			//	5. Close the output stream
			dos.close();
			
			//	Indicates the data has been written to the file 			
			System.out.println("Rainfall data has been written to the file."); 

		}
		catch(IOException ex) {
			
			//	Display exception message
			System.out.println(ex.getMessage());
			
		}

		//	Indicates the creation of the data has ended
		System.out.println("Data creation process has ended.");

	}

}
