import java.util.HashMap;

public class CountLetters {
    public static HashMap<Character, Integer> countLetters(String str) {
        HashMap<Character, Integer> letterMap = new HashMap<>();
        for (Character c: str.toCharArray()) {
            if (!letterMap.containsKey(c)) {
                letterMap.put(c, 1);
            }
            else {
                letterMap.replace(c, letterMap.get(c) + 1);
            }
        }
        return letterMap;
    }
}
