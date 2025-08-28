/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maazh
 */
public class SecretMessage {
    private char[] encode;   // encryption array
    private char[] decode;   // decryption array
    private int displacement; // rotation value

    public SecretMessage(int displacement) {
        this.displacement = displacement;
        encode = new char[26];
        decode = new char[26];
        generateEncryptionCode();
        generateDecryptionCode();
    }

    // Method to generate encrypted character array
    private void generateEncryptionCode() {
        for (int i = 0; i < 26; i++) {
            encode[i] = (char) ('A' + (i + displacement) % 26);
        }
    }

    // Method to generate decrypted character array
    private void generateDecryptionCode() {
        for (int i = 0; i < 26; i++) {
            decode[i] = (char) ('A' + (i - displacement + 26) % 26);
        }
    }

    // Returns encoded character array
    public char[] getEncodeArray() {
        return encode;
    }

    // Returns decoded character array
    public char[] getDecodeArray() {
        return decode;
    }

    // Encrypts the message
    public String getSecretMessage(String message) {
        return StringUtility.encryptDecrypt(message, encode);
    }

    // Decrypts the message
    public String getDecodedMessage(String message) {
        return StringUtility.encryptDecrypt(message, decode);
    }

    // Overrides toString to display everything
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Encryption Code: ").append(new String(encode)).append("\n");
        sb.append("Decryption Code: ").append(new String(decode)).append("\n");
        return sb.toString();
    }
}

