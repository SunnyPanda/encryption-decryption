package encryptdecrypt;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String operation = scanner.nextLine();
        String inputString = scanner.nextLine();
        int key = scanner.nextInt();
        switch (operation) {
            case "enc":
                System.out.println(encrypt(inputString, key));
                break;
            case "dec":
                System.out.println(decrypt(inputString, key));
        }
    }

    static String encrypt(String original, int key) {
        StringBuilder encrypted = new StringBuilder();
        for (char letter : original.toCharArray()) {
            encrypted.append((char)(letter + key));
        }

        return encrypted.toString();
    }

    static String decrypt(String encrypted, int key) {
        StringBuilder original = new StringBuilder();
        for (char letter : encrypted.toCharArray()) {
            original.append((char)(letter - key));
        }

        return original.toString();
    }
}
