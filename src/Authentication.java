
import java.util.Scanner;
import java.io.*;

public class Authentication {
    static Scanner myScan = new Scanner(System.in);
    
    public static void main(String[] args) {
        
    }
    
    /**
     *User Register method.
     */
    public static User register() {
        System.out.println("Enter your username: ");
        String username = myScan.nextLine();
        
        if(userExists(username)) {
            System.out.println("Username already exists.");
            return null;
        }
        
        System.out.println("Enter your password: ");
        String password = myScan.nextLine();
        
        int key = generateRandomKey();
        String encryptedPassword = encrypt(password, key);
        
        User newUser = new User(username, encryptedPassword, key);
                
        saveUser(newUser);
        
        System.out.println("Registration successful.");
        return newUser;
    }
 
     /**
     *User Login method.
     */
    public static User login() {
        System.out.println("Enter username: ");
        String username = myScan.nextLine();
        
        System.out.println("Enter password: ");
        String password = myScan.nextLine();
        
        User user = loadUser(username);
        
        if(user == null) {
            System.out.println("User doesn't exist, please Register.");
            return null;
        }
        
        String decryptedPassword = decrypt(user.getEncryptedPassword(), user.getEncryptionKey());
        
        if(password.equals(decryptedPassword)){
            System.out.println("Login Successful!");
            return user;
        } else {
            System.out.println("Incorrect password!");
            return null;
        }
    }

 }
