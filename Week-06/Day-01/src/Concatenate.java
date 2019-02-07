import java.util.Arrays;
import java.util.stream.Collectors;

public class Concatenate {
    public static void main(String[] args) {
        System.out.println(concatenate(new Character[] {'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd'}));
    }

    public static String concatenate(Character[] chars) {

        return Arrays.stream(chars)
                .mapToInt(c -> c)
                .mapToObj(c -> Character.toString((char) c))
                .collect(Collectors.joining());
    }
}
