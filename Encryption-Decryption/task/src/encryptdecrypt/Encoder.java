package encryptdecrypt;

public class Encoder extends EncoderDecoder{

    @Override
    String process(String inputString, Algorithm algorithm) {

        return algorithm.encrypt(inputString, Integer.parseInt(key));
    }
}
