import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

/**
 * Created by aze on 2017.04.04..
 */
public class Extension {
    int add(int a, int b) {
        return a + b;
    }

    int maxOfThree(int a, int b, int c) {
        OptionalInt optionalInt = Arrays.stream(new int[] {a, b, c}).max();
        if (optionalInt.isPresent()) {
            return optionalInt.getAsInt();
        }
        else {
            return 0;
        }
    }

    int median(List<Integer> pool) {
        if (pool.size() % 2 == 0) {
            return pool.get((pool.size()-1) / 2) + pool.get((pool.size()-1) / 2 + 1);
        }
        else {
            return pool.get((int)Math.ceil(((pool.size()-1) / 2.)));
        }
    }

    boolean isVowel(char c) {
        return Arrays.asList('a', 'u', 'o', 'e', 'i').contains(Character.toLowerCase(c));
    }

    String translate(String hungarian) {
        String teve = hungarian;
        int length = teve.length();
        for (int i = 0; i < length; i++) {
            char c = teve.charAt(i);
            if (isVowel(c)) {
                teve = String.join(c + "v" + c, teve.split(""+c));
                i+=2;
                length+=2;
            }
        }
        return teve;
    }
}
