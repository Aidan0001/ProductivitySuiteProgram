package authentication;

import models.User;
import utils.EncryptionHelpers;
import utils.InputValidator;
import utils.FileHandler;
import java.util.Scanner;
/**
 * Handles user authentication including registration, login, and menu navigation.
 */
public class Authentication {
    static Scanner myScan = new Scanner(System.in);
    
    public static void main(String[] args) {
        
    }
    /**
     * Registers a new user account.
     * Validates username and password, checks for duplicates,
     * encrypts the password, and saves the user to file.
     * 
     * @return The newly created User object if successful, null if registration fails
     */
    public static User register() {
        System.out.println("Enter your username: ");
        String username = myScan.nextLine();
        
        if(!InputValidator.isNotEmpty(username, username)) return null;
        if(!InputValidator.meetsMinLength(username, 3, username)) return null;
        if(!InputValidator.noCommas(username, username)) return null;
        
        if(FileHandler.userExists(username)) {
            System.out.println("Username already exists.");
            return null;
        }

        System.out.println("Enter your password: ");
        String password = myScan.nextLine();
        
        if(!InputValidator.isNotEmpty(password, "Password")) return null;
        if(!InputValidator.meetsMinLength(password, 6, "Password")) return null;
        if(!InputValidator.noCommas(password, "Password")) return null;
        
        int key =  EncryptionHelpers.generateKey(); // Calls generate key
        String encryptedPassword = EncryptionHelpers.encrypt(password, key); // Calls encryption method
        
        User newUser = new User(username, encryptedPassword, key);
                
        FileHandler.saveUser(newUser);
        
        System.out.println("Registration successful.");
        return newUser;
    }
     /**
     * Logs in an existing user.
     * Validates credentials by loading the user from file,
     * decrypting the stored password, and comparing with the entered password.
     * 
     * @return The User object if login successful, null if login fails
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
        
        if(!password.equals(decryptedPassword)){
            System.out.println("Incorrect password!");
            return null;
        }
        System.out.println("Login Succssful!");
        System.out.println("Welcome: " + user.getUsername());
        return user;
    }

     /**
     * Displays the main authentication menu.
     * Allows users to register, login, or exit the application.
     * After successful login, displays the user dashboard.
     */
    public static void mainMenu() {
        Scanner myScan = new Scanner(System.in);
        User currentUser;
        int userChoice;
        
        do {
            System.out.println("=== Login/Register ===");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("0. Exit");
           
            if(myScan.hasNextInt()) {
            userChoice = myScan.nextInt();
            myScan.nextLine();
            } else {
                System.out.println("Invalid input. Pleaes enter a number.");
                myScan.nextLine();
                userChoice = -1;
            }
            
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
    /**
     * Displays the user dashboard after successful login.
     * Provides access to various modules like Password Manager, Contact Book, etc.
     * 
     * @param user The logged-in User object
     */
    public static void userDashboard(User user) {
        Scanner myScan = new Scanner(System.in);
        int userChoice;
        
        do {
            System.out.println("=== Productivity Suite ===");
            System.out.println("1. Password Manager");
            System.out.println("2. Contact Book");
            System.out.println("3. To-Do List");
            System.out.println("4. Expense Tracker");
            System.out.println("5. Hangman");
            System.out.println("0. Log out");
            
            if(myScan.hasNextInt()) {
            userChoice = myScan.nextInt();
            myScan.nextLine();
            } else {
                System.out.println("Invalid input. Pleaes enter a number.");
                myScan.nextLine();
                userChoice = -1;
            }
            
            switch(userChoice) {
                default -> System.out.println("Invalid choice.");
                case 0 -> System.out.println("Logging out...");
                case 1 -> System.out.println("Do something");
                case 2 -> System.out.println("Do something");
                case 3 -> System.out.println("Do something");
                case 4 -> System.out.println("Do something");
                case 5 -> System.out.println("Do something");
                }
        } while(userChoice !=0);
    }
 }