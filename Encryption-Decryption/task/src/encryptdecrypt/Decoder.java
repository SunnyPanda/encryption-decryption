package encryptdecrypt;

public class Decoder extends EncoderDecoder{
    @Override
    String process(String inputString, Algorithm algorithm) {
        return algorithm.decrypt(inputString, Integer.parseInt(key));
    }
}
