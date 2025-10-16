package models;

/**
 * Represents a contact in the contact book.
 */
public class Contact {
    private String firstName;
    private String lastName; 
    private String phoneNumber;
    private String email;
 /**
 * Creates a new User with the specified credentials.
 * 
 * @param firstName The first name of a contact
 * @param lastName The last name of a contact
 * @param phoneNumber The phone number of a contact
 * @param email The email of a contact.
 */
    public Contact(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
 /**
  * Gets the first name of this contact.
  * 
  * @return the first name as a string
  */
    public String getFirstName() { 
        return firstName; }
    /**
     * Gets the last name for this contact.
     * 
     * @return The last name as a String
     */
    public String getLastName() { 
        return lastName; }
     /**
     * Gets the phone number for this contact.
     * 
     * @return The phone number as a String
     */
    public String getPhoneNumber() { 
        return phoneNumber; }
    /**
     * Gets the email for this contact.
     * 
     * @return the email as a String.
     */
    public String getEmail() {
        return email;
    }
}
