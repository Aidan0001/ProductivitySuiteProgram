/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.*;
/**
 *
 * @author user
 */

public class FileHandler {

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
    
    public static boolean userExists(String username) {
        return loadUser(username) != null;
    }
    
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
    
}
