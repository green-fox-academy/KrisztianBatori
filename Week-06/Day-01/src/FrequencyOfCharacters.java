import java.util.HashMap;
import java.util.stream.Collectors;

public class FrequencyOfCharacters {
    public static void main(String[] args) {
        HashMap<Character, Integer> characterFrequency = frequencyOfCharacters("AAABBBCCCABCCBAUUAABB");

        for (Character character:
             characterFrequency.keySet()) {
            System.out.println(character + ": " + characterFrequency.get(character));
        }
    }

    public static HashMap<Character, Integer> frequencyOfCharacters(String str) {

        return new HashMap<>() {{
                    for (Character c:
                         str.chars()
                                 .distinct()
                                 .mapToObj(c -> Character.toString((char) c))
                                 .collect(Collectors.joining())
                                 .toCharArray()) {
                        put(c, (int)str.chars()
                                .filter(character -> character == c)
                                .count());
                    }
            }};
    }
}