import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class OddAverage {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);

        OptionalDouble optionalAverage = numbers.stream()
                                                .filter(number -> number % 2 != 0)
                                                .mapToDouble(n -> n)
                                                .average();

        if (optionalAverage.isPresent()) {
            System.out.println(optionalAverage.getAsDouble());
        }
    }
}
