package model;


import java.util.Date;

public class Interaction {

    private String id;

    private String dateOfInteraction;
    private Date dateOfInteractionInDate;
    private Customer customer;
    private String interactionMethod;
    private String potential;

    public Interaction(){

    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDateOfInteraction(String dateOfInteraction) {
        this.dateOfInteraction = dateOfInteraction;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setInteractionMethod(String interactionMethod) {
        this.interactionMethod = interactionMethod;
    }

    public void setPotential(String potential) {
        this.potential = potential;
    }

    public String getId() {
        return id;
    }
//    public String getDateOfInteraction() { return dateOfInteraction; }

    public String getDateOfInteraction() {
        return dateOfInteraction;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getInteractionMethod() {
        return interactionMethod;
    }

    public String getPotential() {
        return potential;
    }

    public Date getDateOfInteractionInDate() {
        return dateOfInteractionInDate;
    }

    public void setDateOfInteractionInDate(Date dateOfInteractionInDate) {
        this.dateOfInteractionInDate = dateOfInteractionInDate;
    }

    @Override
    public String toString() {
        return "ID: "+id +", DOI: " + dateOfInteraction + ", lead_ID: " + customer.getId() + ", Interaction Method: " + interactionMethod + ", Potential: "
                + potential;
    }
}
