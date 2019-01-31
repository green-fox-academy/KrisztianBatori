public class String2 {
    public static void main(String[] args) {
        System.out.println(removeX("xxxxxxxx3345lkfdgklbxjhxabhxauinauxneoaxoianxnxnawiuwioyyyawoyxuxa"));
    }
    public static String removeX (String text) {
        if (text.contains("x")) {
            return removeX(text.replaceFirst("x", ""));
        }
        else {
            return text;
        }
    }
}
