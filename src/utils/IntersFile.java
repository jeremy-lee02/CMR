package utils;
import model.Customer;
import model.Interaction;

import java.io.*;

public class IntersFile {
    public void saveInteractionToFile(Interaction interaction)  {
        try {
            // Create a file and print out the file
            FileWriter fileWriter = new FileWriter("interactions.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            //System.out.println(interaction.toString());
            printWriter.println(interaction.toString());
            printWriter.close();

        } catch (IOException e) {
            System.out.println("Error occurred while writing customer to the file.");
            e.printStackTrace();
        }

        System.out.println("saved! ");
    }
}