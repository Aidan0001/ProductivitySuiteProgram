package utils;

import models.User;
import models.Contact;
import java.io.*;
/**
 * Handles all file operations for user data storage.
 * User data is stored in CSV format in Data/users.txt
 */
public class FileHandler {
 /**
     * Saves a user to the users.txt file.
     * User data is appended in CSV format: username,encryptedPassword,key
     * 
     * @param user The User object to save to file
     */
    public static void saveUser(User user) {
       try ( // opens users.txt file in append mode.
               FileWriter writer = new FileWriter("Data/users.txt", true)) {
           writer.write(user.getUsername() + ","
                   + user.getEncryptedPassword() + ","
                   + user.getEncryptionKey() + "\n");
       } catch(IOException e) {
           System.out.println("Error saving user: " + e.getMessage());
        }
    }
     /**
     * Loads a user from the users.txt file by username.
     * Searches through the file line by line for a matching username.
     * 
     * @param username The username to search for
     * @return The User object if found, null if not found or error occurs
     */
    public static User loadUser(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Data/users.txt"))) {
            String line;
     
            for(line = reader.readLine(); line !=null; line = reader.readLine()) {
                String[] split = line.split(",");
                String storedUsername = split[0];
                String encryptedPassword = split[1];
                int key = Integer.parseInt(split[2]);
                
                if(storedUsername.equals(username)) {
                  return new User(username, encryptedPassword, key);
                }
            }
        } catch(IOException e) {
            System.out.println("Error loading user: " + e.getMessage());
        }
        return null;
    }
      /**
     * Checks if a user with the given username exists in the file.
     * 
     * @param username The username to check
     * @return true if the username exists, false otherwise
     */
    public static boolean userExists(String username) {
        return loadUser(username) != null;
    }
    /**
     * Ensures the users.txt file exists.
     * Creates the Data directory and users.txt file if they don't exist.
     * Should be called at application startup.
     */
    public static void ensureFileExists() {
         File file = new File("Data/users.txt");
         
    try {
        if(!file.exists()) {
            file.getParentFile().mkdirs();  // Creates Data folder if needed
            file.createNewFile();  // Creates users.txt
            System.out.println("Created users.txt file");
        }
    } catch(IOException e) {
        System.out.println("Error creating file: " + e.getMessage());
    }
    }
    
   public static void saveContact() {
       
   }
}
