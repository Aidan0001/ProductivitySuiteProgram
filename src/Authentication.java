
import java.util.Scanner;
import java.io.*;

public class Main {
    static Scanner myScan = new Scanner(System.in);
    
    public static void main(String[] args) {
        
    }
    
    public static void mainMenu() {
          int userChoice;
   
        /*
        **Menu for user navigation**
        */
        do { 
            
            System.out.println("Enter number to navigate.");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("0. Exit");
            userChoice = myScan.nextInt();
            
            switch(userChoice) {
                case 0 -> System.out.println("Exitting Application...");
                default -> System.out.println("Invalid Input...");
            }
        }while(userChoice!=0);
    }
    
    /**
     *User Register method.
     */
    public static void register() {
        
    }
    
    }
