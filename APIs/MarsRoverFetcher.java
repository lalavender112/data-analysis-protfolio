//@author: Melissa Chen
//@date: 2025 July 26
//@purpose: Lab 10; fetch Mars rover photo data from NASA's API, save it as JSON, and search for the image URL within that file

package labs.example.APIs;  // fix package to match folder path

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.HTTP;

import java.net.URI; // add this for new URL construction

public class MarsRoverFetcher {

    // NASA API key for authentication
    private static final String API_KEY = "9ocGo6KkwVjSemuihx2KAlrFITgFYegjdKCDshHa";
    // Endpoint URL to fetch photos from the Mars rover photos
    private static final String API_URL = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&camera=rhaz&api_key=" + API_KEY;
    // Output file path where the JSON response will be saved
    private static final String OUTPUT_FILE = "src/labs/example/APIs/json/nasa.json";

    public static void main(String[] args) {
        try {
            fetchAndSaveJson(); //Fetch data from NASA API and save it as a local JSON file
            searchForImageUrl("mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01000/opgs/edr/rcam/RRB_486265291EDR_F0481570RHAZ00323M_.JPG");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage()); // Print any errors that occur during the process
        }
    }

    private static void fetchAndSaveJson() throws IOException {
        URI uri = URI.create(API_URL); // Create URI from the API string
        URL url = uri.toURL();  

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET"); // Open HTTP connection and set request method to GET

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream())); // Read the response line by lin
        File outputFolder = new File("src/labs/example/APIs/json");
        if (!outputFolder.exists()) {
            outputFolder.mkdirs();
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE));

        String line;
        while ((line = reader.readLine()) != null) { // Write the response to the JSON file
            writer.write(line);
            writer.newLine();
        }

        writer.close(); // Close resources and disconnect HTTP connection
        reader.close();
        connection.disconnect();

        System.out.println("JSON response saved to nasa.json");
    }

    //searches the JSON file for a line that contains the image URL substring
    private static void searchForImageUrl(String targetUrlPart) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(OUTPUT_FILE));
        String line;
        int lineNumber = 1;
        boolean found = false;

        // Read the file line by line and look for the target URL part
        while ((line = reader.readLine()) != null) {
            if (line.contains(targetUrlPart)) {
                System.out.println("\nNASA API Endpoint ---> Mars Rover Photos");
                System.out.println("Camera ---> Front Hazard Avoidance Camera");
                System.out.println("Found on line ---> " + lineNumber);
                found = true;
                break;
            }
            lineNumber++;
        }
        reader.close();

        // If the URL substring was not found in the file
        if (!found) {
            System.out.println("Image URL pattern not found in the JSON.");
        }
    }
}
