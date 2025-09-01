//@author: Melissa Chen
//@date: 2025 July 25
//@purpose: Lab 9 Part 2; create a responsive chatbot between me and Gemini

package labs.example.APIs;

import java.net.URI;
import java.net.URISyntaxException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

public class GeminiChatBotAssignment {

     // Sends a user prompt to the Gemini API and returns its text response
    public static String sendToGemini(String prompt, String apiKey) throws IOException {
        //
        String apiUrl = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key=" + apiKey;

        // Setup connection
        HttpURLConnection conn = (HttpURLConnection) new URL(apiUrl).openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json"); // Set content type
        conn.setDoOutput(true); // Enable sending a request body

        // Build JSON payload
        JSONObject requestBody = new JSONObject();
        JSONObject message = new JSONObject();
        JSONArray parts = new JSONArray();
        parts.put(new JSONObject().put("text", prompt)); // Add the user's input text
        message.put("parts", parts); 
        JSONArray contents = new JSONArray();  // Full conversation (list of messages)
        contents.put(message);  // Add current user message
        requestBody.put("contents", contents);

        // Send JSON to Gemini API
        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = requestBody.toString().getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length); // Write the full JSON payload
        }

        // Read response
        InputStreamReader streamReader = new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8); //ensures the response is correctly interpreted especially if it contains non-ASCII characters
        BufferedReader in = new BufferedReader(streamReader);//wraps the InputStreamReader to efficiently read the response line by line
        StringBuilder response = new StringBuilder(); // For building the complete response
        String inputLine;

        while ((inputLine = in.readLine()) != null) { //reads each line of the response and appends it to the StringBuilder
            response.append(inputLine);
        }
        in.close(); //closing the reader

        // Parse response JSON
        JSONObject json = new JSONObject(response.toString());
        JSONArray candidates = json.getJSONArray("candidates");
        
        //handles empty array (like when the API doesn't return response)
        if (candidates.length() == 0) {
            return "No response from Gemini.";
        }

        JSONArray partsArray = candidates.getJSONObject(0)//retrieves the first object in the JSONARRAY array
             .getJSONObject("content")  //holds additional structured data related to the candidate's content
              .getJSONArray("parts"); // retrieves the parts key within the content object

        return partsArray.getJSONObject(0).getString("text").trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //read user input from the console
        String apiKey = "AIzaSyBd0ACkwLCaBmAKJ-pv43-e4utWls8-yVM"; 

        System.out.println("Welcome to your Gemini chatbot! Type 'exit' to quit."); //program begins by printing a welcome message

        //prompt the user for input continuously until they leave
        while (true) {
            System.out.print("You: ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            try { //handles exeptions and print error message
                String response = sendToGemini(userInput, apiKey);
                System.out.println("Gemini: " + response);
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }

        scanner.close(); //closing the scanner after the loop ends
    }
}
