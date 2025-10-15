
import java.util.Scanner;
import java.io.*;

public class Authentication {
    static Scanner myScan = new Scanner(System.in);
    
    public static void main(String[] args) {
        
    }
    
    /**
     *User Register method.
     * {@return the name} {@code null} if unknown  
     */
    public static User register() {
        System.out.println("Enter your username: ");
        String username = myScan.nextLine();
        
        if(FileHandler.userExists(username)) {
            System.out.println("Username already exists.");
            return null;
        }
        
        System.out.println("Enter your password: ");
        String password = myScan.nextLine();
        
        int key =  EncryptionHelpers.generateKey(); // Calls generate key
        String encryptedPassword = EncryptionHelpers.encrypt(password, key); // Calls encryption method
        
        User newUser = new User(username, encryptedPassword, key);
                
        FileHandler.saveUser(newUser);
        
        System.out.println("Registration successful.");
        return newUser;
    }
 
     /**
     *User Login method.
     * {@return the name} {@code null} if unknown  
     */
    public static User login() {
        System.out.println("Enter username: ");
        String username = myScan.nextLine();
        
        System.out.println("Enter password: ");
        String password = myScan.nextLine();
        
        User user = FileHandler.loadUser(username);
        
        if(user == null) {
            System.out.println("User doesn't exist, please Register.");
            return null;
        }
        
        String decryptedPassword = EncryptionHelpers.decrypt(user.getEncryptedPassword(), user.getEncryptionKey());
        
        if(password.equals(decryptedPassword)){
            System.out.println("Login Successful!");
            return user;
        } else {
            System.out.println("Incorrect password!");
            return null;
        }
    }

    public static void mainMenu() {
        Scanner myScan = new Scanner(System.in);
        User currentUser = null;
        int userChoice;
        
        do {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("0. Exit");
            userChoice = myScan.nextInt();
            switch(userChoice) {
                default -> System.out.println("Invalid choice."); 

                case 0 -> System.out.println("Exitting...");
                case 1 -> Authentication.register();
                case 2 -> {
                    currentUser = Authentication.login();
                    if(currentUser != null) {
                        Authentication.userDashboard(currentUser);
                    }
                }
            }
        } while(userChoice !=0);
    }
    
    public static void userDashboard(User user) {
        Scanner myScan = new Scanner(System.in);
        int userChoice;
        
        do {
            System.out.println("1. Password Manager");
            System.out.println("2. Contact Book");
            System.out.println("3. To-Do List");
            System.out.println("4. Expense Tracker");
            System.out.println("5. Hangman");
            System.out.println("0. Log out");
            userChoice = myScan.nextInt();
            switch(userChoice) {
                default -> System.out.println("Invalid choice.");
                case 0 -> System.out.println("Exitting...");
                case 1 -> System.out.println("Do something");
                case 2 -> System.out.println("Do something");
                case 3 -> System.out.println("Do something");
                case 4 -> System.out.println("Do something");
                case 5 -> System.out.println("Do something");
                }
        } while(userChoice !=0);
    }
 }
