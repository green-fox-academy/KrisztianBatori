import java.util.Arrays;

public class isAnagram {

    private char[] input1;
    private char[] input2;

    isAnagram(String str1, String str2) {
        input1 = str1.toCharArray();
        input2 = str2.toCharArray();
    }

    public boolean areInputsAnagrams() {
        if (input1.length != 0 && input2.length != 0) {
            char[] input1Reversed = new char[input1.length];
            int counter = 0;
            for (int i = input1.length - 1; i >= 0; i--) {
                input1Reversed[counter] = input1[i];
                counter++;
            }
            return Arrays.equals(input1Reversed, input2);
        }
        else {
            return false;
        }
    }
}
