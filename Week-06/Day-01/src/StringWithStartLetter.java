import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringWithStartLetter {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(stringsStartWith('A')));
    }

    public static String[] stringsStartWith(char character) {
        List<String> cities = Arrays.asList("ROME", "LONDON", "NAIROBI", "CALIFORNIA", "ZURICH", "NEW DELHI", "AMSTERDAM", "ABU DHABI", "PARIS");

        return (cities.stream()
                .filter(string -> string.charAt(0) == character)
                .collect(Collectors.toList())).toArray(String[]::new);
    }
}
