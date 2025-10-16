package utils;

/**
 * Provides encryption and decryption utilities using a Caesar cipher variant.
 */
public class EncryptionHelpers {
    
    /**
     * Encrypts a password using a Caesar cipher with the given key.
     * Only letters are encrypted; other characters remain unchanged.
     * Case is preserved (uppercase stays uppercase, lowercase stays lowercase).
     * 
     * @param password The plain text password to encrypt
     * @param key The encryption key (shift amount)
     * @return The encrypted password as a String
     */
public static String encrypt(String password, int key) {
    StringBuilder encryptedPassword = new StringBuilder("");
    for (char c : password.toCharArray()) {
        if(Character.isLetter(c)) {
         char base = Character.isLowerCase(c) ? 'a' : 'A';
         encryptedPassword.append((char)((c - base + key % 26 + 26) % 26 + base));
        } else {
               encryptedPassword.append(c);
            }
    }
    return encryptedPassword.toString();
}
    /**
     * Decrypts an encrypted password using the Caesar cipher with the given key.
     * This reverses the encryption process.
     * 
     * @param encryptedPassword The encrypted password to decrypt
     * @param key The encryption key that was used to encrypt the password
     * @return The original plain text password
     */
public static String decrypt(String encryptedPassword, int key) {
    StringBuilder decryptedPassword = new StringBuilder("");
    
    for (char c : encryptedPassword.toCharArray()) {
        if(Character.isLetter(c)) {
            char base = Character.isLowerCase(c) ? 'a' : 'A';
            decryptedPassword.append((char) ((c - base - key % 26 + 26) % 26 + base));
        } else {
            decryptedPassword.append(c);
        }
    }
    return decryptedPassword.toString();
}
  /**
     * Generates a random encryption key.
     * The key is an integer between -256 and 256.
     * 
     * @return A random integer to be used as an encryption key
     */
public static int generateKey() {
  return (int)(Math.floor(Math.random() * 513) - 256); 
}
}
