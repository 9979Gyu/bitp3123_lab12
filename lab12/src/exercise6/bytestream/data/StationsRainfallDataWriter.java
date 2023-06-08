/**
 * 
 */
package exercise6.bytestream.data;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author yuqin
 *
 */
public class StationsRainfallDataWriter {
 
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// 1. Determine the target storage for the output
        String filename = "stationsRainfallData.txt";

        // Declare variables
        String date[] = {"01/06/2023", "02/06/2023", "03/06/2023",
                "04/06/2023", "05/06/2023", "06/06/2023"};

        double rainfallData[][] = {
                // Alor Gajah
                {2.0, 0.0, 0.0, 0.0, 0.0, 37.0},
                {0.0, 0.0, 4.0, 1.0, 0.0, 6.0},

                // Jasin
                {13.0, 0.0, 0.0, 1.0, 1.0, 69.0},
                {6.0, 0.0, 0.0, 21.5, 0.0, 39.0},

                // Melaka Tengah
                {37.0, 0.0, 0.0, 3.0, 0.0, 43.0},
                {20.0, 0.0, 0.0, 3.5, 0.0, 42.5}
        };

        String stationDetails[][] = {
                // Alor Gajah
                {"2222002", "Durian Tunggal", "Alor Gajah"},
                {"2421003", "Simpang Ampat", "Alor Gajah"},

                // Jasin
                {"2125002", "Telok Rimba", "Jasin"},
                {"2225044", "Chohong", "Jasin"},

                // Melaka Tengah
                {"2223023", "Sg. Duyong", "Melaka Tengah"},
                {"2222006", "Cheng(Taman Merdeka)", "Melaka Tengah"},
        };

        try {

            // 2. Construct the object for DataOutputStream
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename));

            // 3. Write the data into the output stream
            for (String dateValue : date) {
            	
                dos.writeUTF(dateValue);
                
            }

            // Write the data
            for (int row = 0; row < rainfallData.length; row++) {
            	
                dos.writeUTF(stationDetails[row][0]); // Station ID
                dos.writeUTF(stationDetails[row][1]); // Station Name
                dos.writeUTF(stationDetails[row][2]); // District Name
                
                for (int column = 0; column < rainfallData[row].length; column++) {
                	
                    dos.writeDouble(rainfallData[row][column]);
                    
                }
                
                //	4. Flush the output stream
                dos.flush();
                
            }

            // 5. Close the DataOutputStream
            dos.close();

            // Indicate that the data has been written to the file
            System.out.println("Rainfall data has been written to the file.");

        } catch (IOException ex) {
        	
            // Display exception message
            System.out.println(ex.getMessage());
            
        }

	}
}
