
import model.Customer;
import model.Interaction;

//import utils.FileUtils;

import java.io.IOException;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    private static int customerId = 0;
    private static int interactionId = 0;

    private static SalesPeople salesPeople = new SalesPeople();
    private static CustomerManager customerManager = new CustomerManager();

    public static void main(String[] args) throws ParseException,IOException {
        //getting user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 'm' to see the manual!");


        while (true) {

            String input = scanner.nextLine();

            switch (input) {
                case "m": {
                    printManual();
                    break;
                }
                // operations for leads (customers)
                case "10": {
                    addCustomer();
                    break;
                }
                case "20": {
                    String customerId = enterCustomerIdPrompt();
                    updateCustomer(customerId);
                    break;
                }
                case "30": {
                    String customerId = enterCustomerIdPrompt();
                    deleteCustomer(customerId);
                    break;
                }
                case "40": {
                    System.out.println("Printing all customers in the list...");
                    System.out.println(" ");
                    try{
                        printCustomer();
                    }catch (Exception e){

                    }
                    break;
                }
                case "1": {
                    addInteractionInfo();
                    break;
                }
                case "2": {
                    String interactionId = enterInteractionIdPrompt();
                    updateInteractionInfo(interactionId);
                    break;
                }
                case "3": {
                    String interactionId = enterInteractionIdPrompt();
                    deleteInteractionInfo(interactionId);
                    break;
                }
                case "4": {
                    System.out.println("Printing all the sales people in the list ...");
                    System.out.println(" ");
                    printAllInteractions();
                    break;
                }
                case "100": {
                    System.out.println("Displaying age of customers...");
                    System.out.println(" ");
                    reportCustomerAge100();
                    break;
                }
                case "200":{
                    System.out.println("Displaying potential of cutomers...");
                    System.out.println(" ");
                    reportCustomerPotential200();
                    break;
                }
                case "300":{
                    System.out.println("Displaying interaction by month...");
                    System.out.println(" ");
                    reportInteraction300();
                    break;
                }
                case "0": {
                    System.out.println("Good bye ... ");

                    System.exit(0);
                }
                default:
                    System.out.println("Your choice do not exist in the manual.");
                    break;
            }
        }

    }

    private static void printManual() {
        System.out.println("[Manual]\n" +
                "===MANAGE CUSTOMERS===\n" +
                "10 : Enter customer info\n" +
                "20 : Update customer info\n" +
                "30 : Delete customer\n" +
                "40 : Print all customers\n" +
                "50 : Saved!!\n\n" +

                "===MANAGE SALES INTERACTIONS===\n" +
                "1 : Add interaction info\n" +
                "2 : Update interaction info by id\n" +
                "3 : Delete interaction by id\n" +
                "4 : Print all interactions\n" +
                "0 : Exit this program\n" +

                "===Extra functions===\n" +
                "100 : Display customer age\n" +
                "200 : Display number of interactions by potential\n" +
                "300 : Display number of interactions by month\n");
    }

    private static String enterCustomerIdPrompt() {
        System.out.print("Enter customer id : ");
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }

    private static String enterInteractionIdPrompt() {
        System.out.print("Enter model.Interaction Id : ");
        Scanner interactionIdInput = new Scanner(System.in);
        return interactionIdInput.nextLine();
    }


    /* model.Customer related method*/
    public static void addCustomer() throws ParseException {

        Customer customer = createCustomerObject();

        if (customerManager.addCustomer(customer)) {
            // ArrayList.add returns true if the item was added successfully
            System.out.println("Add customer successful! \n" + customer);
        } else {
            System.out.println("Add customer failed!");
        }
    }

    private static void deleteCustomer(String customerId) {
        boolean isDeleted = customerManager.deleteCustomer(customerId);
        if (isDeleted) {
            System.out.println("Deleting customer form the list...");
            System.out.println("Deleted customer " + customerId + " successfully!");
        } else {
            System.out.println("Delete customer failed!");
        }
    }

    private static void updateCustomer(String customerId) throws ParseException {

        boolean isUpdated = customerManager.updateCustomer(customerId);

        if (isUpdated) {
            System.out.println("Update customer successful!");
        } else {
            System.out.println("Update customer failed.");
        }
    }

    private static void printCustomer() throws IOException{
        customerManager.printAllCustomers();
    }


    private static void printOutSalesToFile() throws IOException {
        salesPeople.printAllInteractions();
    }

    private static Customer createCustomerObject() throws ParseException {
        Scanner customerInfoInput = new Scanner(System.in);
        Customer customer = new Customer();

        System.out.println("Enter customer info");
        customer.setId(String.format("lead_%03d", customerId++));

        System.out.print("Name : ");      //using "print" function to disable new line
        String name = customerInfoInput.nextLine();
        customer.setName(name);

        System.out.print("Date of Birth (dd-MM-yyyy) : ");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd-MMM-yyyy");

        String finalDate = customerInfoInput.nextLine();

        Date dDate = dateFormat.parse(finalDate);
        String strOutputDate = dateFormat2.format(dDate);

        customer.setDateOfBirth(strOutputDate);
        customer.setDateOfBirthInDate(dDate);


        System.out.print("Gender (Male - 0, Female - 1) : ");
        String gender = customerInfoInput.nextLine();
        customer.setGender(gender);

        System.out.print("Phone Number : ");
        String phoneNumber = customerInfoInput.nextLine();
        customer.setPhoneNumber(phoneNumber);

        System.out.print("Email : ");
        String email = customerInfoInput.nextLine();
        customer.setEmail(email);

        System.out.print("Address : ");
        String address = customerInfoInput.nextLine();
        customer.setAddress(address);

        return customer;
    }




    /* model.Interaction related method */
    private static void addInteractionInfo() throws ParseException{

        Interaction interaction = createInteractionObject();

        boolean isAdded = salesPeople.addInteraction(interaction);
        if(isAdded){
            System.out.println("model.Interaction added successfully!\n" + interaction);
        }else{
            System.out.println("model.Interaction add failed !");
        }
    }

    private static void deleteInteractionInfo(String interactionId) {
        boolean isDeleted = salesPeople.deleteInteraction(interactionId);
        if(isDeleted){
            System.out.println("Delete interaction information successful!");
        }else{
            System.out.println("Delete interaction information failed.");
        }
    }

    private static void updateInteractionInfo(String interactionId) throws ParseException {
        boolean isUpdated = salesPeople.updateInteraction(interactionId);
        if(isUpdated){
            System.out.println("Update interaction information successful!");
        }else{
            System.out.println("Update interaction information failed.");
        }
    }

    private static void printAllInteractions() throws IOException{
        salesPeople.printAllInteractions();
    }


    //////
    //need to be worked more!
    //////
    private static Interaction createInteractionObject() throws ParseException{
        Scanner interactionInfoInput = new Scanner(System.in);
        Interaction interaction = new Interaction();
        interaction.setId(String.format("inter_%03d", interactionId++));


        System.out.print("Date of interaction (dd-MMM-yyyy) : ");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd-MMM-yyyy");

        String finalDate = interactionInfoInput.nextLine();

        Date dDate = dateFormat.parse(finalDate);
        String strOutputDate = dateFormat2.format(dDate);

//        String doi = interactionInfoInput.nextLine();
//        Date printDoi = null;
//        try{
//            //Parsing the String
//            printDoi = dateFormat.parse(doi);
//            //printDoi = dateFormat.parse(doi);
//        }catch(ParseException e){
//            e.printStackTrace();
//        }
        interaction.setDateOfInteraction(strOutputDate);

        System.out.print("model.Customer ID : ");
        String customerId = interactionInfoInput.nextLine();
        Customer customer = customerManager.getCustomerById(customerId);

        if(customer == null){
            while(customer == null){
                System.out.println("wrong customer id, please try again!");
                customerId = interactionInfoInput.nextLine();
                customer = customerManager.getCustomerById(customerId);
            }
        }
        interaction.setCustomer(customer);

        System.out.print("model.Interaction Method (SNS / email / telephone / face to face) : ");
        String method = interactionInfoInput.nextLine();
        interaction.setInteractionMethod(method);

        System.out.print("Potential (P - positive, NEG - negative, NEU - neutral) : ");
        String potential = interactionInfoInput.nextLine();
        interaction.setPotential(potential);

        return interaction;
    }

    private static void reportCustomerAge100() throws ParseException {
        customerManager.reportCustomerAge();
    }

    private static void reportCustomerPotential200() throws ParseException{
        salesPeople.reportCustomerPotential();
    }

    private static void reportInteraction300() throws ParseException{
        salesPeople.reportInteraction();
    }

}
