/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aidan0001
 */
public class User {
    private final String username;  // Final - never changes
    private String encryptedPassword;  // Can change
    private int encryptionKey;  // Can change
    
    public User(String username, String encryptedPassword, int encryptionKey) {
        this.username = username;
        this.encryptedPassword = encryptedPassword;
        this.encryptionKey = encryptionKey;
    }
    
    // Getters
    public String getUsername() { 
        return username; }
    
    public String getEncryptedPassword() { 
        return encryptedPassword; }
    
    public int getEncryptionKey() { 
        return encryptionKey; }
}
