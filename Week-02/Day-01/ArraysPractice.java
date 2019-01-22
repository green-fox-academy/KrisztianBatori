import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArraysPractice {
    public static void main(String[] args) {
        // 06 - Third
        int[] q = {4, 5, 6, 7};
        System.out.println(q[2]);

        // 07 - Compare length
        int[] p1 = {1, 2, 3};
        int[] p2 = {4, 5};
        System.out.println(p2.length > p1.length);

        // 08 - Sum elements
        int[] r = {54, 23, 66, 12};
        System.out.println(Integer.sum(r[1], r[2]));

        // 09 - Change element
        int[] s = {1, 2, 3, 8, 5, 6};
        //Arrays.binarySearch(s, 8) -> Outputs '-7'
        s[Arrays.binarySearch(s, 5)] = 4;
        System.out.println(s[4]);

        // 10 - Increment element
        int[] t = {1, 2, 3, 4, 5};
        t[2] += 1;
        System.out.println(t[2]);

        // 11 - Print all
        int[] numbers = {4, 5, 6, 7};
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf(numbers[i] + " ");
        }
        System.out.println();

        // 12 - Diagonal matrix
        int[][] matrix = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = 0;
            }
            matrix[i][i] = 1;
        }
        for (int i = 0; i < 4; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        // 13 - Double items
        int[] numList = {3, 4, 5, 6, 7};
        for (int i = 0; i < 5; i++) {
            numList[i] *= 2;
            System.out.print(numList[i] + " ");
        }
        System.out.println();

        // 14 Colors
        String[][] Colors = { {"Lime", "forest green", "olive", "pale green", "spring green"},
                              {"orange red", "red", "tomato"},
                              {"orchid", "violet", "pink", "hot pink"} };

        // 15 - Swap elements
        String[] abc = {"first", "second", "third"};
        String temp = abc[0];
        abc[0] = abc[2];
        abc[2] = temp;
        System.out.println(abc[0] + " " + abc[2]);

        // 16 - Sum all
        int[] ai = {3, 4, 5, 6, 7};
        int sum = 0;
        for (int element: ai) { sum += element; }
        System.out.println(sum);

        // 17 - Reverse
        int[] aj = {3, 4, 5, 6, 7};
        int[] ar = new int[5];
        int counter = 0;
        for (int i = aj.length - 1; i >= 0; i--) {
            ar[counter] = aj[i];
            counter++;
        }
        aj = Arrays.copyOf(ar, 5);
        System.out.println(Arrays.toString(aj));

        // +1 - Unique (COPIED SOLUTION)
        System.out.println(Arrays.toString(unique(new int[] {1, 11, 34, 11, 52, 61, 1, 34})));

        // +2 - Anagram
        System.out.println(isAnagram("god".toCharArray(), "dog".toCharArray()));

        // +3 - Palindrome builder
        System.out.println(createPalindrome(""));
        System.out.println(createPalindrome("greenfox"));
        System.out.println(createPalindrome("123"));

        // +4 - Palindrome searcher
        System.out.println(Arrays.toString(palindromeSearcher("dog goat dad duck doodle never")));
        System.out.println(Arrays.toString(palindromeSearcher("apple")));
        System.out.println(Arrays.toString(palindromeSearcher("racecar")));
        System.out.println(Arrays.toString(palindromeSearcher("")));

        // +5 - Bubble
        System.out.println(Arrays.toString(bubble(new int[] {1, 11, 34, 5, 11, 52, 61, 34, 1, 1, 5, 2, 10})));
        System.out.println(Arrays.toString(advancedBubble(new int[] {4, 5, 6, 11, 2, 1, 2, 1, 66, 7, 33, 45, 2, 4, 5}, true)));
        System.out.println(Arrays.toString(advancedBubble(new int[] {1, 12, 35, 6, 12, 53, 62, 35, 1, 1, 5, 2, 10}, false)));
    }

    public static int[] unique(int[] arr) {
        return Arrays.stream(arr).distinct().toArray();
    }

    public static boolean isAnagram(char[] input1, char[] input2) {
        boolean identical = false;
        char[] input1Reversed = new char[input1.length];
        int counter = 0;
        for (int i = input1.length - 1; i >= 0; i--) {
            input1Reversed[counter] = input1[i];
            counter++;
        }
        return Arrays.equals(input1Reversed, input2);
    }

    public static String createPalindrome(String input) {
        StringBuilder palindrome = new StringBuilder();
        int counter = 0;
        for (int i = input.length() - 1; i >= 0; i--) {
            palindrome.append(input.toCharArray()[i]);
            counter++;
        }
        return input + palindrome;
    }

    public static String[] palindromeSearcher(String text) {
        char[] convertedText = text.toCharArray();
        ArrayList<String> stringArray = new ArrayList<>();
        for (int i = 0; i < convertedText.length - 1; i++) {
            for (int j = i + 1; j < convertedText.length; j++) {
                if (convertedText[i] == convertedText[j]) {
                    boolean palindromeFound = false;
                    int startIndexCopy = i;
                    int endIndexCopy = j;
                    int startIndex = i;
                    int endIndex = j;
                    while (!(startIndex == endIndex)) {
                        startIndex++;
                        endIndex--;
                        if (!(convertedText[startIndex] == convertedText[endIndex])) {
                            break;
                        }
                        if (startIndex + 1 == endIndex || startIndex + 2 == endIndex || startIndex == endIndex) {
                            palindromeFound = true;
                        }
                    }
                    if (palindromeFound) {
                        char[] newPalindrome = Arrays.copyOfRange(convertedText, startIndexCopy, endIndexCopy+1);
                        stringArray.add(new String(newPalindrome));
                        break;
                    }
                }
            }
        }
        return stringArray.toArray(new String[stringArray.size()]);
    }

    public static int[] bubble(int[] unsortedArray) {
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int j = 0; j < unsortedArray.length - 1; j++) {
                if (unsortedArray[j] > unsortedArray[j + 1]) {
                    int temp = unsortedArray[j];
                    unsortedArray[j] = unsortedArray[j + 1];
                    unsortedArray[j + 1] = temp;
                    swapped = true;
                }
            }
        }
        return unsortedArray;
    }

    public static int[] advancedBubble(int[] unsortedArray, boolean ascending) {
        if (ascending) {
            return bubble(unsortedArray);
        }
        else {
            unsortedArray = Arrays.copyOf(bubble(unsortedArray), unsortedArray.length);
            int[] reversedArray = new int[unsortedArray.length];
            int counter = 0;
            for (int i = unsortedArray.length - 1; i >= 0; i--) {
                reversedArray[counter] = unsortedArray[i];
                counter++;
            }
            return reversedArray;
        }
    }
}
