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
        
        //	Declare variables
        int counter = 0;
        
        try {

            //	2. Construct the object for the input stream
            DataInputStream dis = new DataInputStream(new FileInputStream(sourceFile));
            
            //	Declare variable
            String formattedAverage;
            
            System.out.print("\n\nStation ID\tStation Name\t\tDistrict Name\t");
            
            //	3. Read the data from the input stream
            for (int i = 0; i < 6; i++) {
                String date = dis.readUTF();
                System.out.printf("%-10s\t", date);
            }
            
            System.out.print("Average");
            
            // Read the data
            while (dis.available() > 0) {
            	
            	counter ++;
            	
                String stationId = dis.readUTF();
                System.out.printf("\n%-10s\t", stationId);
                
                String stationName = dis.readUTF();
                System.out.printf("%-20s\t", stationName);
                
                String districtName = dis.readUTF();
                System.out.printf("%-10s\t", districtName);

                double rainfall = 0, totalRainfall = 0;
                
            	for (int column = 0; column < 6; column ++) {

                	rainfall = dis.readDouble();             	
                	System.out.printf("%-10.2f\t", rainfall);
                    totalRainfall += rainfall;
                  
                }
            	

                //	get the returned value from computeAverage
                formattedAverage = computeAverage(totalRainfall, 6);
                
                System.out.printf("%-30s\n", formattedAverage);

            }
            
           
            //	indicate the number of stations and districts
            System.out.println("\n\nNumber of stations : " + counter +
            		"\nNumber of districts : " + counter/2);

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