package labs.example.fileOperations;

import java.io.*;
import java.util.*;

public class Logger {

    // File path constants
    private static final String LOG_PATH = "src/labs/example/fileOperations/logs/";
    private static final String LOG_FILE_PATH = LOG_PATH + "api_error.log";

    public static void main(String[] args) {
        try {
            // Lab 1 reads the file twices for different purposes (closes before reopening)
            BufferedReader file1 = openErrorLog(); // Open file and get BufferedReader
            getCountOfErrorTypes(file1);           // Count log levels
            file1.close();

            // Re-open and count memory-related messages
            BufferedReader file2 = openErrorLog();
            getMemoryLimitExceededCount(file2);  
            file2.close();

            // Lab 2

            // 1: Disk space errors and IP addresses
            BufferedReader errorLog = openErrorLog();
            getDiskSpaceErrorsWithIPAddress(errorLog);
            errorLog.close();

            // 2: Use overloaded method to open HTTP access log
            BufferedReader accessLog = openErrorLog("http_access_log");

            // 3: Count unique GMT offsets
            getGMTOffset(accessLog);
            accessLog.close();

            // 4: Count HTTP code classes (2xx, 3xx, 4xx, 5xx)
            accessLog = openErrorLog("http_access_log");
            getHTTPCodes(accessLog);
            accessLog.close();

            // 5: Count response sizes >3900 
            accessLog = openErrorLog("http_access_log");
            getResponseSizes(accessLog);
            accessLog.close();

            // 6: Print the HTTP verbs only once
            accessLog = openErrorLog("http_access_log");
            groupHTTPMethodsAndEndPoints(accessLog);
            accessLog.close();

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    //Opens api_error.log file.
    public static BufferedReader openErrorLog() throws FileNotFoundException {
        return new BufferedReader(new FileReader(LOG_FILE_PATH));
    }

    //Overloaded method to open http_access.log file.
    public static BufferedReader openErrorLog(String filename) throws FileNotFoundException {
        if (!"http_access_log".equals(filename)) {
            throw new IllegalArgumentException("Invalid file name.");
        }
        return new BufferedReader(new FileReader(LOG_PATH + "http_access.log"));
    }

    //  Count log types [ERROR], [WARN], [INFO], [DEBUG]
    public static void getCountOfErrorTypes(BufferedReader reader) throws IOException {
        int errorCount = 0, warnCount = 0, infoCount = 0, debugCount = 0;
        String line;

        while ((line = reader.readLine()) != null) {
            if (line.contains("[ERROR]")) errorCount++;
            if (line.contains("[WARN]")) warnCount++;
            if (line.contains("[INFO]")) infoCount++;
            if (line.contains("[DEBUG]")) debugCount++;
        }

        System.out.println("Log Level Counts:");
        System.out.println("ERROR: " + errorCount);
        System.out.println("WARN: " + warnCount);
        System.out.println("INFO: " + infoCount);
        System.out.println("DEBUG: " + debugCount);
        System.out.println();
    }

    // Count memory limit exceeded errors and show endpoints
    private static void getMemoryLimitExceededCount(BufferedReader reader) throws IOException {
        ArrayList<String> endpoints = new ArrayList<>();
        int count = 0;
        String line;

        while ((line = reader.readLine()) != null) {
            if (line.toLowerCase().contains("memory limit exceeded")) {
                count++;
                int pipeIndex = line.indexOf("| Endpoint:"); // Extract the endpoint (text after "| Endpoint:")
                if (pipeIndex != -1) {
                    String endpoint = line.substring(pipeIndex + 11).trim();
                    endpoints.add(endpoint);
                }
            }
        }
        //shows result
        System.out.println("Memory Limit Exceeded Count: " + count);
        System.out.println("Affected Endpoints:");
        for (String endpoint : endpoints) {
            System.out.println(" - " + endpoint);
        }
    }

    //Finds and prints disk space errors in api_error.log with line numbers and IPs

    private static void getDiskSpaceErrorsWithIPAddress(BufferedReader reader) throws IOException {
        String line; // Stores each log line as it's read
        int lineNumber = 0;

        while ((line = reader.readLine()) != null) {
            lineNumber++; //read file line by line
            if (line.contains("Disk space")) {
                int ipStart = line.indexOf("]") + 2; //marks the start of the IP address (two indexes behind ])
                int ipEnd = line.indexOf(" -", ipStart); //marks ending
                String ip;
                    if (ipStart != -1 && ipEnd != -1) {  
                        ip = line.substring(ipStart, ipEnd); // Extract IP if positions are valid    
                    } else {
                    ip = "UNKNOWN"; // Default value if positions are invalid
                    }
                System.out.println("Disk space error on line " + lineNumber + " for IP Address: " + ip);
            }
        }
    }

    //Part 2, 3
    private static void getGMTOffset(BufferedReader reader) throws IOException {
        String line;
        List<String> offsets = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
    
        while ((line = reader.readLine()) != null) {
            int offsetIndex = line.indexOf("+"); // Find the position of '+' which indicates start of GMT offset
            if (offsetIndex != -1 && offsetIndex + 5 < line.length()) { 
                // check if '+' was found and if there are at least 5 characters after '+' to safely extract offset (like +0000)
                String offset = line.substring(offsetIndex, offsetIndex + 5);
                
                // Check if offset already exists
                int index = offsets.indexOf(offset);
                if (index == -1) {
                    offsets.add(offset);
                    counts.add(1);
                } else {
                    counts.set(index, counts.get(index) + 1);
                }
            }
        }
    
        System.out.println("GMT Offsets:");
        for (int i = 0; i < offsets.size(); i++) {
            System.out.println(offsets.get(i) + ": " + counts.get(i));
        }
    }

    // Counts how many 2xx, 3xx, 4xx, and 5xx codes appear in http_access.log
    private static void getHTTPCodes(BufferedReader reader) throws IOException {
        String line;
        int count2xx = 0, count3xx = 0, count4xx = 0, count5xx = 0; 

        while ((line = reader.readLine()) != null) { //read file line by line
            String[] parts = line.split("\""); //split string into arrays wherever a " appears
            if (parts.length > 2) { //ensures that the array has at least three elements (the 2xx codes exist after the second ")
                String[] afterQuote = parts[2].trim().split(" "); //retrieves the third element of the array and remove any leading/trailing whietspace, then the resulting string is split into another array using a space as the delimiter
                if (afterQuote.length > 0) {
                    try {
                        int code = Integer.parseInt(afterQuote[0]);
                        if (code >= 200 && code < 300) count2xx++; //counting the number of each codes
                        else if (code >= 300 && code < 400) count3xx++;
                        else if (code >= 400 && code < 500) count4xx++;
                        else if (code >= 500 && code < 600) count5xx++;
                    } catch (NumberFormatException ignored) {}
                }
            }
        }

        System.out.println("HTTP Status Code Counts:");
        System.out.println("2xx Errors: " + count2xx);
        System.out.println("3xx Errors: " + count3xx);
        System.out.println("4xx Errors: " + count4xx);
        System.out.println("5xx Errors: " + count5xx);
    }

    // Counts how many response sizes are greater than 3900 in http_access.log
  
    private static void getResponseSizes(BufferedReader reader) throws IOException {
        String line;
        int count = 0;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\""); //each line is split into parts using "
            if (parts.length > 2) { //if the array has >2 elements
                String[] afterQuote = parts[2].trim().split(" "); //the third element is trimmed of leading/trailing whitespace and split into an array using a space as the delimiter
                if (afterQuote.length > 1) {
                    try {
                        int size = Integer.parseInt(afterQuote[1]); //chekcs the second element of the array created above
                        if (size > 3900) count++;
                    } catch (NumberFormatException ignored) {}
                }
            }
        }

        System.out.println("Responses > 3900 bytes: " + count);
    }

    // Identifies and prints all unique HTTP methods in http_access.log
  
    private static void groupHTTPMethodsAndEndPoints(BufferedReader reader) throws IOException {
        String line;
        Set<String> methods = new HashSet<>();

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\"");
            if (parts.length > 1) {
                String[] methodParts = parts[1].split(" "); //second part of the array is further splite into another array called methodParts
                if (methodParts.length > 0) {
                    methods.add(methodParts[0]);
                }
            }
        }

        System.out.println("HTTP Methods Found:");
        for (String method : methods) {
            System.out.println(" - " + method);
        }
    }
}
