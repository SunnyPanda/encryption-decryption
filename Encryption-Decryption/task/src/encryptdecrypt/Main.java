package encryptdecrypt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String original = scanner.nextLine();
        int key = scanner.nextInt();

        System.out.println(encrypt(original, key));
    }

    static String encrypt(String original, int key) {
        StringBuilder encrypted = new StringBuilder();
        for (char letter : original.toCharArray()) {
            if (Character.isAlphabetic(letter)) {
                encrypted.append((char) (((letter - 'a' + key) % 26) + 'a'));
            } else {
                encrypted.append(letter);
            }
        }
        return encrypted.toString();
    }
}
