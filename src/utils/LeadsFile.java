package utils;
import model.Customer;
import model.Interaction;

import java.io.*;
import java.util.Scanner;

public class LeadsFile {

    public void saveCustomerToFile(Customer customer) {
        try {
            // Create a file and print out the file
            FileWriter fileWriter = new FileWriter("leads.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            // System.out.println(customer.toString());
            printWriter.println(customer.toString());
            printWriter.close();

        } catch (IOException e) {
            System.out.println("Error occurred while writing customer to the file.");
            e.printStackTrace();
        }

        System.out.println("saved! ");
    }
}
