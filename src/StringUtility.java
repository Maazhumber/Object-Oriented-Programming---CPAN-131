/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maazh
 */
public class StringUtility {
    // This method takes message and code array to encrypt or decrypt
    public static String encryptDecrypt(String message, char[] code) {
        char[] chars = message.toUpperCase().toCharArray();
        StringBuilder result = new StringBuilder();

        for (char c : chars) {
            if (c >= 'A' && c <= 'Z') {
                int index = c - 'A';
                result.append(code[index]);
            } else {
                result.append(c);  // keep space or punctuation unchanged
            }
        }
        return result.toString();
    }
}
