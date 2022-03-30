package model;


import java.util.Date;

public class Customer {


    private String id;
    private String name;
    private String dateOfBirth;
    private Date dateOfBirthInDate; // saving date as a form of "date"
    private String gender;
    private String phoneNumber;
    private String email;
    private String address;

    public Customer(){

    }

    public String getId() {
        return id;
    }

    public Date getDateOfBirthInDate() {
        return dateOfBirthInDate;
    }

    public void setDateOfBirthInDate(Date dateOfBirthInDate) {
        this.dateOfBirthInDate = dateOfBirthInDate;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "ID: "+id + ", Name: "  + name +", DOB: " + dateOfBirth + ", Gender: " + gender + ", Phone Number: "
                + phoneNumber + ", Email: " + email + ", Address: " + address;
    }

}

