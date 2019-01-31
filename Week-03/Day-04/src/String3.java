public class String3 {
    public static void main(String[] args) {

        System.out.println(insertAsterisk("xxxxxxxxx"));
    }

    public static String insertAsterisk (String text) {
        if (text.length() == 1 || text.charAt(text.length() - 2) == '*') {
            return text;
        }
        else {
            return text.charAt(0) + "*" + insertAsterisk(text.substring(1));
        }
    }
}
