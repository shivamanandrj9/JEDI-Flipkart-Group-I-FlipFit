package com.flipkart.helper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Config {
    private static final String FILE_NAME = "./src/com/flipkart/helper/counter.txt"; // Update with your directory

    // Read the counter from the file
    private int readCounter() {
        int counter = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line = reader.readLine();
            if (line != null) {
                counter = Integer.parseInt(line);
            }
        } catch (IOException e) {
            // If file doesn't exist or there's an error, return 0
            System.out.println("Could not read counter, starting from 0.");
        }
        return counter;
    }

    // Write the counter to the file
    private void writeCounter(int counter) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write(String.valueOf(counter));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Increment the counter
    public void increment() {
        int counter = readCounter();
        counter++;
        writeCounter(counter);
    }

    // Decrement the counter
    public void decrement() {
        int counter = readCounter();
        counter--;
        writeCounter(counter);
    }

    // Get the current value of the counter
    public int getCounter() {
        return readCounter();
    }

}
