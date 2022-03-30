package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    // using "Singleton pattern"
    private static InputValidator instance;

    private InputValidator() {
    }

    public static InputValidator getInstance() {
        if (instance == null) {
            // if calling other value, it will not reply.
            instance = new InputValidator();
        }
        return instance;
    }

    // regular expression for the right user input
    private final String nameRegex = "^[a-zA-Z\\s]+";
    private final String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private final String phoneRegex = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$";
    private final String genderRegex = "[0-1]";
    private final String addressRegex = "\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)";

    public boolean validateName(String name) {

        if (name.trim().equals("")) {
            return true;
        } else {
            return Pattern.matches("[a-zA-Z]+", name);
            //using pattern class and matches method.
            // checking if "name" is matches with regex
        }
    }

    public boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber.trim().equals("")) {
            return true;
        } else {
            Pattern pattern = Pattern.compile(phoneRegex);
            Matcher matcher = pattern.matcher(phoneNumber);
            return matcher.matches();
        }
    }

    public boolean validateGender(String gender) {
        if (gender.trim().equals("")) {
            return true;
        } else {
            Pattern pattern = Pattern.compile(genderRegex);
            Matcher matcher = pattern.matcher(gender);
            return matcher.matches();
        }
    }

    public boolean validateAddress(String address) {
        if (address.trim().equals("")) {
            return true;
        } else {
            Pattern pattern = Pattern.compile(addressRegex);
            Matcher matcher = pattern.matcher(addressRegex);
            return matcher.matches();
        }
    }

    public boolean validateMethod(String method){
        if(method.trim().equals("")){
            return true;
        }else if(method.matches("sns|email| telephone|face to face")){
            return true;
        }else if (method.matches("SNS|EMAIL|TELEPHONE|FACE TO FACE")){
            return true;
        }else{
            return false;
        }

    }


    public boolean validatePotential(String potential) {


        if (potential.matches("P|NEU|NEG")){
            return true;
        }else if(potential.matches("p|neu|neg")){
            return true;
        }else{
            return false;
        }
    }

    public boolean validateBirthDay(String strDate) {
        // Check if date is 'null'
        if (strDate.trim().equals("")) {
            return true;
        }
        System.out.println("valid! press '0' to finish this stage.");
        return true;
    }

}

