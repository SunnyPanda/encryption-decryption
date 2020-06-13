package encryptdecrypt;

public interface Algorithm {

    String encrypt(String original, int key);

    String decrypt(String encrypted, int key);
}
