
import model.Interaction;
import utils.InputValidator;
import utils.IntersFile;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.ZoneId;



public class SalesPeople {

    private ArrayList<Interaction> interactions = new ArrayList<>();

    public ArrayList<Interaction> getInteractions() {
        return interactions;
    }

    public boolean addInteraction(Interaction interaction) {
        return interactions.add(interaction);
    }

    // method for deleting sales people from the list.
    // using .get() method to get ID from the arraylist "interactions"
    //using .remove() to delete ID from the list.
    public boolean deleteInteraction(String interactionId) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < interactions.size(); i++) {
            if (interactionId.equals(interactions.get(i).getId())) {
                System.out.println("Type 'y' to delete inter_id from the list.");
                // user need to put inter_id and y to complete the process.
                String deleteConfirm = scanner.next();
                if (deleteConfirm.equals("y")) {
                    return true;
                }
                return interactions.remove(interactions.get(i));
            }
        }
        return false;
    }
    // updating data of sales people

    public boolean updateInteraction(String interactionId) throws ParseException {

        printInteractionUpdateManual();
        // calling manual for updating first.
        Scanner s = new Scanner(System.in);
        String newInfo = ""; // setting target
        boolean isDone = false;
        Interaction inter = null;

        for (int i = 0; i < interactions.size(); i++) {
            if (interactionId.equals(interactions.get(i).getId())) {
                // finding object to modify
                inter = interactions.get(i);
            }

            if (inter == null) {
                return false;
            }
            //using "switch" to update data from the sales people list.
            while (!isDone) {
                String target = s.nextLine();
                // setting user input as a next input

                switch (target) {
                    case "date": {

                        System.out.print("Enter new date of birth(dd-mm-yyyy) : ");
                        String date = new Scanner(System.in).nextLine();

                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                        SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd-MMM-yyyy");
                        //using "SimpleDateFormat" to print out exact time.

                        Date dDate = dateFormat.parse(date);
                        String strOutputDate = dateFormat2.format(dDate);
                        //this will change String value of "dDate" to String

                        boolean isValid = InputValidator.getInstance().validateBirthDay(strOutputDate);
                        //checking whether user input right form of input by using .validateBirthday from the class "InputValidator"
                        if (isValid) {
                            inter.setDateOfInteraction(strOutputDate);
                        } else {
                            System.out.println("Invalid birthday form!");
                        }
                        break;
                    }

                    case "method": {
                        newInfo = updateInfoPrompt(target);
                        inter.setInteractionMethod(newInfo);
                        //inter= interactions.getId
                        Boolean isValid = InputValidator.getInstance().validateMethod(newInfo);
                        if (isValid) {
                            JOptionPane.showMessageDialog(null, "valid form! Press 0 to continue.");
                            inter.setPotential(newInfo);
                            //using "JOptionPane.showMessageDialog" for popup screen.
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid");
                        }
                        break;
                    }

                    case "potential": {
                        newInfo = updateInfoPrompt(target);
                        Boolean isValid = InputValidator.getInstance().validatePotential(newInfo);
                        if (isValid) {
                            JOptionPane.showMessageDialog(null, "valid form! Press 0 to continue.");
                            inter.setPotential(newInfo);
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid");
                        }
                        break;
                    }
                    case "0": {
                        isDone = true;
                        break;
                    }

                    default: {
                        System.out.println("Continue... Press '0' ");
                        break;
                    }
                }
            }
        }
        return true;
    }

    private void printInteractionUpdateManual() {
        System.out.println("Which information would you like to update?");
        System.out.println("OPTIONS : [date(MM/DD/YYYY), method, potential]");
        System.out.println("Enter '0' when update is complete.");
    }

    private String updateInfoPrompt(String updateTarget) {
        System.out.print("Type new " + updateTarget + " to update : ");
        return new Scanner(System.in).nextLine();
    }

    //printing out interactions from the arraylist  <Interaction>
    public void printAllInteractions() throws IOException {
        try {
            IntersFile intersFile = new IntersFile();
            intersFile.saveInteractionToFile(interactions.get(interactions.size() - 1));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Please run again! Do not save when there is no user!");
        }
        for (int i = 0; i < interactions.size(); i++) {
            System.out.println(interactions.get(i));
        }

        if (interactions.size() == 0) {
            System.out.println("The sales people list is empty.");
        }
    }

    public void reportCustomerPotential() throws ParseException {

        System.out.println("Input the start date(dd-MM-yyyy): ");
        String startDate = new Scanner(System.in).nextLine();
        Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(startDate);

        System.out.println("Input the end date(dd-MM-yyyy): ");
        String endDate = new Scanner(System.in).nextLine();
        Date date2 = new SimpleDateFormat("dd-MM-yyyy").parse(endDate);

        int P = 0;
        int Neg = 0;
        int Neu = 0;

        for (int i = 0; i < interactions.size(); i++) {
            Date doiDate = interactions.get(i).getDateOfInteractionInDate();

            //  boolean isBetweenStrAndEnd = ((doiDate.after(date1)) && (doiDate.before(date2)));
            boolean isBetweenStrAndEnd = true;
            if (isBetweenStrAndEnd) {
                if (interactions.get(i).getPotential().equals("P")) {
                    P += 1;
                }
                if (interactions.get(i).getPotential().equals("NEU")) {
                    Neu += 1;
                }
                if (interactions.get(i).getPotential().equals("NEG")) {
                    Neg += 1;
                }
            }


        }

        System.out.println("Start Date : " + startDate +
                "\nEnd Date : " + endDate +
                "\n================================== " +
                "\n<Potential>" +
                "\nPositive : " + P +
                "\nNegative : " + Neg +
                "\nNeutral : " + Neu);

    }


    public void reportInteraction() throws ParseException {
        System.out.println("Input the start date(dd-MM-yyyy): ");
        String startDate = new Scanner(System.in).nextLine();
        Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(startDate);

        System.out.println("Input the end date(dd-MM-yyyy): ");
        String endDate = new Scanner(System.in).nextLine();
        Date date2 = new SimpleDateFormat("dd-MM-yyyy").parse(endDate);

        int Jan2020 = 0;
        int Feb2020 = 0;
        int Mar2020 = 0;
        int Apr2020 = 0;
        int May2020 = 0;
        int Jun2020 = 0;
        int Jul2020 = 0;
        int Aug2020 = 0;
        int Sep2020 = 0;
        try {
            for (int i = 0; i < interactions.size(); i++) {
                Date doiDate = interactions.get(i).getDateOfInteractionInDate();
                boolean isInRange = doiDate.before(date1) && doiDate.after(date2);
                //boolean isBetweenStrAndEnd = ((doiDate.after(date1)) && (doiDate.before(date2)));
                boolean isBetweenStrAndEnd = true;
                if (isBetweenStrAndEnd) {
                    if (isInRange) {
                        Jan2020 += 1;
                    }
                    if (isInRange) {
                        Feb2020 += 1;
                    }
                    if (isInRange) {
                        Mar2020 += 1;
                    }
                }
                System.out.println("Jan/2020 : " + Jan2020
                        + "\nFeb/2020 : " + Feb2020
                        + "\nMarch / 2020 : " + Mar2020
                );
            }
        } catch (NullPointerException e) {
            System.out.println("something wrong try it again. ");

        }
    }
}
