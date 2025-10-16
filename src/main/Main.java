package main;


import authentication.Authentication;
import utils.FileHandler;

/**
 * Entry point for the Productivity Suite application.
 * Initializes the file system and starts the authentication menu.
 */
public class Main {
    
    /**
     * Main method - application entry point.
     * Ensures the data file exists and starts the main menu.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        FileHandler.ensureFileExists();
        Authentication.mainMenu();
    }
}