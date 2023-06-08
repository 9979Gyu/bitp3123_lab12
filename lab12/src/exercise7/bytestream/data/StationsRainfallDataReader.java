/**
 * 
 */
package exercise6.bytestream.data;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author yuqin
 *
 */
public class StationsRainfallDataReader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

        //	1. Locate the source of the input stream
        String sourceFile = "stationsRainfallData.txt";
        System.out.println("Read data from " + sourceFile);
        
        try {

            //	2. Construct the object for the input stream
            DataInputStream dis = new DataInputStream(new FileInputStream(sourceFile));
            
            //	Declare variables
            int numStations = 0, numDistricts = 0;
            String formattedAverage;
            
            System.out.print("\nStation ID\tStation Name\t\t\tDistrict Name\t\t");
            
            //	3. Read the data from the input stream
            for (int i = 0; i < 6; i++) {
                String date = dis.readUTF();
                System.out.print(date + "\t");
            }
            
            System.out.print("Average\n");

            // Read and display the data
            while (dis.available() > 0) {
            	
                String stationId = dis.readUTF();
                String stationName = dis.readUTF();
                String districtName = dis.readUTF();

                System.out.print(stationId + "\t\t" + 
                stationName + "\t\t\t" + districtName + "\t\t");
                
                numStations ++;

                double rainfall = 0, totalRainfall = 0;
                
                for (int i = 0; i < 6; i++) {

                	rainfall = dis.readDouble();
                    totalRainfall += rainfall;
                    System.out.print(rainfall + "\t\t"); 
                    
                }
                
                //	get the returned value from computeAverage
                formattedAverage = computeAverage(totalRainfall, 6);
                
                System.out.print(formattedAverage + "\n");

            }
            
            //	indicate the number of stations and districts
            numDistricts = numStations/2;
            System.out.println("\nNumber of stations : " + numStations +
            		"\nNumber of districts : " + numDistricts);

            // 4. Close the DataInputStream
            dis.close();

        } catch (IOException ex) {
        	
            // Display exception message
            System.out.println(ex.getMessage());
            
        }
        
        // Indicate the program has ended
        System.out.println("\nProgram has ended.");
        
    }
	
	//	Method to compute and format the average of rainfall
	public static String computeAverage(double rainfallData, int counter) {
		
		//	Declare Variable
		double average = 0;
		
		average = rainfallData / counter;
		
		return String.format("%.2f", average);
	}
	
}
