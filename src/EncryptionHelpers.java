/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public class EncryptionHelpers {

public static String encrypt(String password, int key) {
    StringBuilder encryptedPassword = new StringBuilder("");
    for (char c : password.toCharArray()) {
        if(Character.isLetter(c)) {
         // Makes sure string built from cipher is in the alphabet
         char base = Character.isLowerCase(c) ? 'a' : 'A';
         /*
          * Starts the cipher proccess, takes the word (c) - by base so we
          * don't leave the alphabet
          * adds the key to them
          * Mod by 26 to make sure it's in the alphabet
          * base) % 26 + base handles negative integers.
          */
         encryptedPassword.append((char)((c - base + key % 26 + 26) % 26 + base));
        } else {
               encryptedPassword.append(c);
            }
    }
    return encryptedPassword.toString();
}
    
public static String decrypt(String encryptedPassword, int key) {
    StringBuilder decryptedPassword = new StringBuilder("");
    
    for (char c : encryptedPassword.toCharArray()) {
        if(Character.isLetter(c)) {
            char base = Character.isLowerCase(c) ? 'a' : 'A';
            /*
            * Starts the cipher proccess, takes the word (c) - by base so we
            * don't leave the alphabet
            * then we subtract the letter by the key to get our original position
            * Mod by 26 to make sure it's in the alphabet
            * base) % 26 + base handles negative integers.
            */
            decryptedPassword.append((char) ((c - base - key % 26 + 26) % 26 + base));
        } else {
            decryptedPassword.append(c);
        }
    }
    return decryptedPassword.toString();
}

public static int generateKey() {
   // generates random key
  return (int)(Math.floor(Math.random() * 513) - 256); 
}
}
