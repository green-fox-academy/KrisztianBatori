import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class FilterFoxes {
    public static void main(String[] args) {
        List<Fox> foxes = new ArrayList<>() {{
            add(new Fox("one", "green", 2));
            add(new Fox("two", "green", 6));
            add(new Fox("three", "red", 3));
            add(new Fox("four", "green", 10));
            add(new Fox("five", "red", 4));
        }};

        System.out.println("Green foxes:");
        foxes.stream().filter(fox -> fox.color.equals("green")).map(fox -> fox.name).forEach(System.out::println);
        System.out.println("Green foxes, age less than 5:");
        foxes.stream().filter(fox -> fox.color.equals("green") && fox.age < 5).map(fox -> fox.name).forEach(System.out::println);


    }
}
