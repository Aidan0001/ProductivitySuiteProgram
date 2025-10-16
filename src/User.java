public class User {
    private final String username;  // Final - never changes
    private String encryptedPassword;  // Can change
    private int encryptionKey;  // Can change
    // Builder
    public User(String username, String encryptedPassword, int key) {
        this.username = username;
        this.encryptedPassword = encryptedPassword;
        this.encryptionKey = key;
    }
    // Getters
    public String getUsername() { 
        return username; }
    
    public String getEncryptedPassword() { 
        return encryptedPassword; }
    
    public int getEncryptionKey() { 
        return encryptionKey; }
}