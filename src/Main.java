/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maazh
 */
public class Main {
    public static void main(String[] args) {
        // Sample Run 1 with rotation 5
        SecretMessage sm1 = new SecretMessage(5);
        String original1 = "The zebra is on the way";
        String secret1 = sm1.getSecretMessage(original1);
        String decoded1 = sm1.getDecodedMessage(secret1);

        System.out.println("Original Message: " + original1);
        System.out.println(sm1);
        System.out.println("Secret Message: " + secret1);
        System.out.println("Decoded Message: " + decoded1);
        System.out.println();

        // Sample Run 2 with rotation 4
        SecretMessage sm2 = new SecretMessage(4);
        String original2 = "Help in danger";
        String secret2 = sm2.getSecretMessage(original2);
        String decoded2 = sm2.getDecodedMessage(secret2);

        System.out.println("Original Message: " + original2);
        System.out.println(sm2);
        System.out.println("Secret Message: " + secret2);
        System.out.println("Decoded Message: " + decoded2);
    }
}
