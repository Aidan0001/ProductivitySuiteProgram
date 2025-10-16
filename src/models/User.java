package models;

/**
 * Represents a user account with encrypted credentials.
 */
public class User {
    private final String username;  // Final - never changes
    private String encryptedPassword;  // Can change
    private int encryptionKey;  // Can change
 
 /**
 * Creates a new User with the specified credentials.
 * 
 * @param username The unique username for this account
 * @param encryptedPassword The encrypted password string
 * @param encryptionKey the key used to encrypt/decrypt the password.
 */
    public User(String username, String encryptedPassword, int key) {
        this.username = username;
        this.encryptedPassword = encryptedPassword;
        this.encryptionKey = key;
    }
 /**
  * Gets the username for this account
  * 
  * @return the username as a string
  */
    public String getUsername() { 
        return username; }
    /**
     * Gets the encrypted password for this account.
     * 
     * @return The encrypted password as a String
     */
    public String getEncryptedPassword() { 
        return encryptedPassword; }
     /**
     * Gets the encryption key used for this account's password.
     * 
     * @return The encryption key as an integer
     */
    public int getEncryptionKey() { 
        return encryptionKey; }
}