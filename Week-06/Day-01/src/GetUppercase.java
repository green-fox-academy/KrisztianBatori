import java.util.Arrays;
import java.util.stream.Collectors;

public class GetUppercase {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findUppercase("ASJKhfsdFSJeu")));
        System.out.println(Arrays.toString(findUppercase("V")));
        System.out.println(Arrays.toString(findUppercase("AAAAAAAA!u")));
        System.out.println(Arrays.toString(findUppercase("BaaaB")));
        System.out.println(Arrays.toString(findUppercase("]0r+32F0woG;lsdfZ")));
        System.out.println(Arrays.toString(findUppercase("-0909-0-U")));
    }

    public static char[] findUppercase(String str) {
        return str.chars()
                .filter(character -> character > 64 && character < 91)
                .mapToObj(c -> Character.toString((char) c))
                .collect(Collectors.joining())
                .toCharArray();
    }
}
