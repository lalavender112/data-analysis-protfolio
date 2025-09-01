package labs.example.fileOperations;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileOperator {

    private static final String FILE_PATH = "src/labs/example/fileOperations/"; //specifies the base directory
    private static final String FILE_NAME = "users.csv"; //specifies the name of CSV file

    public static void openCSVFile() {
        File csvFile = new File(FILE_PATH + "files/" + FILE_NAME); //creates a File object for the CSV file
        File logFile = new File(FILE_PATH + "logs/csv_error.log"); //creates the csv_error.log file under the logs directory

        // Create csv_error.log if it doesn't exist
        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
                FileWriter logWriter = new FileWriter(logFile, true);
                logWriter.write("The file was not found. File is created.");
                logWriter.close();
            } catch (IOException ex) {
                System.out.println("There was a problem creating the log file.");
            }
        }

        try (
            BufferedReader csvReader = new BufferedReader(new FileReader(csvFile)); //csvReader is created to read the CSV file line by line
            BufferedWriter logWriter = new BufferedWriter(new FileWriter(logFile, true))
        ) {
            String line;
            int count = 0;
            while ((line = csvReader.readLine()) != null) { //reads CSV file line by line (loops until readLine() returns null)
                if (count > 0) { //tracks number of the line; processing begins only after the first line is skipped
                    try {
                        String[] values = line.split(","); //for each line, it is split into an array of strings, seperated by commas
                        String name = values[0]; 
                        int total = 0; //remaining values are parsed as integers
                        for (int i = 1; i < values.length; i++) { //calculates sum
                            total += Integer.parseInt(values[i].trim());
                        }
                        int avg = total / (values.length - 1); //calculates average
                        System.out.println("Name: " + name + ", Average: " + avg);
                    } catch (Exception e) { 
                        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                        logWriter.write(timestamp + " - Error processing line: \"" + line + "\" → " + e.getMessage() + "\n");
                    }
                }
                count++;
            }
        } catch (IOException e) { //if I0Execption occurs while opening or reading the CSV file, the message below is printed
            System.out.println("There was a problem reading the CSV file: " + e.getMessage());
        }
    }

    public static void main(String[] args) { //entry point for the FileOperator program
        openCSVFile();
    }
}
