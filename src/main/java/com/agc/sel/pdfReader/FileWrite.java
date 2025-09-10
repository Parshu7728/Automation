package com.agc.sel.pdfReader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The FileWrite class provides functionality to write text to a file. It uses a
 * FileWriter to handle file operations and includes error handling for
 * potential IOExceptions.
 */
public class FileWrite {
	// FileWriter object used for writing to a file
	FileWriter writer;

	/**
	 * Writes the specified text to a predefined file.
	 *
	 * @param file The text content to be written to the file.
	 */
	public void writeFile(String file) {
		try {
            // Check if the directory exists
            File directory = new File("E:/AutomationAGC/Automation/src/main/resources/reportData");
            if (!directory.exists()) {
                System.out.println("Directory does not exist. Creating it...");
                directory.mkdirs(); // Create the directory if it doesn't exist
            }

            // Create a FileWriter object to write to the specified file path
            writer = new FileWriter("E:/AutomationAGC/Automation/src/main/resources/reportData/ReportData");

            // Write the provided text to the file
            writer.write(file);

            // Close the FileWriter to release resources
            writer.close();

            // Print a success message to the console
            System.out.println("Text written to file successfully.");
        } catch (IOException e) {
            // Print the stack trace if an IOException occurs
            e.printStackTrace();
        }
    }
}
