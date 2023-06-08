/**
 * 
 */
package exercise7.bytestream.data;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

/**
 * @author yuqin
 *
 */
public class RainfallDataReader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//	1. Identify the source
		String sourceFile = "rainfallData.txt";
		
		try {
			
			//	2. Construct the Reader object
			BufferedReader buffReader
			   = new BufferedReader(new FileReader(sourceFile));
			
			//	Declare variables
			double total = 0, average = 0;
			int counter = 0;
			
			//	3. Read the data
			String line = buffReader.readLine();
			
			while (line != null) {
				
                System.out.println(line);
                
                //	split line by \t
                String[] parts = line.split("\t");

                if (parts.length == 2) {
                	
                	//	parse the value
                    double intensity = Double.parseDouble(parts[1]);
                    
                    total += intensity;
                    counter++;
                    
                }
                
                line = buffReader.readLine();
                
            }

			//	compute and display the average
            if (counter > 0) {
            	
                average = total / counter;
                String formattedAverage = String.format("%.2f", average);
                System.out.println("\nAverage of the rainfall: " + formattedAverage);
                
            }

            // 4. Close the object
            buffReader.close();
			
		} 
		catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		System.out.println("\nProgram End.");

	}

}
