package Core;

import Utils.Helper;
import javafx.util.Pair;

import java.util.HashMap;

public class Morse extends MethodEncryptDecrypt {
    private static HashMap<Character, String> encodeMap;
    private static HashMap<String, Character> decodeMap;
    private static Pair<HashMap<Character, String>, HashMap<String, Character>> codingMaps;

    static {
        codingMaps=Helper.MorseHelper.FillMorseCodeValues();
        encodeMap = codingMaps.getKey();
        decodeMap = codingMaps.getValue();
    }

    public Morse(String name) {
        super(name);
    }

    @Override
    public String encrypt(String message) {
        String encoded = "";
        String[] words = message.toLowerCase().trim().split("\\s");
        try {

            for (String word : words) {
                for (int i = 0; i < word.length(); i++) {
                    encoded += encodeMap.get(word.charAt(i)) + " ";
                }
                encoded += "  ";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encoded;
    }

    @Override
    public String decrypt(String message) {
        String decoded = "";
        String[] morse = message.trim().split("\\s\\s\\s");
        try {

            for (String word : morse) {
                for (String sign : word.split("\\s")) {
                    for (int i = 0; i < decodeMap.keySet().size(); i++) {
                        if (sign.equals(decodeMap.keySet().toArray()[i])) {
                            decoded += decodeMap.get(decodeMap.keySet().toArray()[i]);
                        }
                    }
                }
                decoded += " ";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decoded;
    }


}
