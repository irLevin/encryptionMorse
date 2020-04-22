package Utils;

import javafx.util.Pair;

import java.util.HashMap;

public final class Helper {
    public static class MorseHelper {
        public static final Character[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
                'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8',
                '9', '0', '!', ',', '?', '.'};
        public static final String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
                "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
                "-.--", "--..", ".----", "..---", "...--", "....-", ".....",
                "-....", "--...", "---..", "----.", "-----", "-.-.--", "--..--", "..--..", ".-.-.-", ".----.",};

        public static Pair<HashMap<Character, String>, HashMap<String, Character>> FillMorseCodeValues() {
            HashMap<String, Character> morseToChar = new HashMap<String, Character>();
            HashMap<Character, String> charToCode = new HashMap<Character, String>();
            for (int i = 0; i < chars.length; i++) {
                charToCode.put(chars[i], morse[i]);
                morseToChar.put(morse[i], chars[i]);
            }
            return new Pair<HashMap<Character, String>, HashMap<String, Character>>(charToCode, morseToChar);
        }
    }
}
