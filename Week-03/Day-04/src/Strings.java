public class Strings {
    public static void main(String[] args) {
    }

    public static String changeX (String text) {
        if (text.contains("x")) {
            return changeX(text.replaceFirst("x", "y"));
        }
        else {
            return text;
        }
    }
}
