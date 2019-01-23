public class StringsPractice {
    public static void main(String[] args) {

        // 01 - Simple replace
        String example = "In a dishwasher far far away";
        example = example.replace("dishwasher", "galaxy");
        System.out.println(example);

        // 02 - Url fixer
        String url = "https//www.reddit.com/r/nevertellmethebots";
        url = url.replace("bots", "odds");
        url = url.substring(0, 5) + ":" + url.substring(5);

        System.out.println(url);

        // 03 - Takes longer
        String quote = "\"Hofstadter's Law: It you expect, even when you take into account Hofstadter's Law.\"";
        quote = quote.substring(0, quote.indexOf("It") + "It".length() + 1) + "always takes longer than" + quote.substring(quote.indexOf("you") - 1, quote.length());
        System.out.println(quote);

        // 04 - To do print
        String todoText = " - Buy milk\n";
        todoText = "My todo:\n" + todoText;
        todoText += " - Download games\n";
        todoText += "\t - Diablo";
        System.out.println(todoText);

        // 05 - Reverse
        String reversed = ".eslaf eb t'ndluow ecnetnes siht ,dehctiws erew eslaf dna eurt fo sgninaem eht fI";
        System.out.println(reverse(reversed));
    }

    public static String reverse(String str) {
        String reversedString = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversedString += str.charAt(i);
        }
        return reversedString;
    }
}
