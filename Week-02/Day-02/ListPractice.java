import java.lang.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ListPractice {
    public static void main(String[] args) {

        // 06 - Solar system
        ArrayList<String> planetList = new ArrayList<String>(Arrays.asList("Mercury","Venus","Earth","Mars","Jupiter","Uranus","Neptune"));
        System.out.println(putSaturn(planetList));

        // 07 - Match making
        ArrayList<String> girls = new ArrayList<String>(Arrays.asList("Eve","Ashley","Claire","Kat","Jane"));
        ArrayList<String> boys = new ArrayList<String>(Arrays.asList("Joe","Fred","Tom","Todd","Neef","Jeff"));
        System.out.println(makingMatches(girls, boys));

        // 08 - Append letter
        List<String> far = Arrays.asList("bo", "anacond", "koal", "pand", "zebr");
        System.out.println(appendA(far));

        // 09 - Candy shop
        ArrayList<Object> arrayList = new ArrayList<Object>();
        arrayList.add("Cupcake");
        arrayList.add(2);
        arrayList.add("Brownie");
        arrayList.add(false);
        System.out.println(sweets(arrayList));

        // 10 - Element finder
        ArrayList<Integer> arrayList2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(containsSeven(arrayList2));

        // 11 - Is in list
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16));
        System.out.println(checkNums(list));

        // 12 - Quote swap
        ArrayList<String> list2 = new ArrayList<String>(Arrays.asList("What", "I", "do", "create,", "I", "cannot", "not", "understand."));
        System.out.println(quoteSwap(list2));

        // 13 - Calculator
        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> validOperands = new ArrayList<>(Arrays.asList('+', '-', '*', '/', '%'));
        ArrayList<Character> validNumbers = new ArrayList<>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9'));
        String operandA = "";
        String operandB = "";
        int mainIndex = 0;

        System.out.printf("Please type in the expression: ");
        String input = scanner.nextLine();
        if (validOperands.contains(input.charAt(mainIndex))) {
            mainIndex += 2;
            if (validNumbers.contains(input.charAt(mainIndex))) {
                operandA += input.charAt(mainIndex);
                mainIndex++;
                while (validNumbers.contains(input.charAt(mainIndex))) {
                    operandA += input.charAt(mainIndex);
                    mainIndex++;
                }
                if (input.charAt(mainIndex) == ' ') {
                    mainIndex++;
                    while (validNumbers.contains(input.charAt(mainIndex))) {
                        operandB += input.charAt(mainIndex);
                        if (mainIndex + 1 == input.length()) {
                            calculate(input.charAt(0), Integer.parseInt(operandA), Integer.parseInt(operandB));
                            break;
                        }
                        else if (!validNumbers.contains(input.charAt(mainIndex + 1))) {
                            System.out.println("INVALID INPUT");
                        }
                        mainIndex++;
                    }
                }
                else {
                    System.out.println("INVALID INPUT");
                }
            } else {
                System.out.println("INVALID INPUT");
            }
        } else {
            System.out.println("INVALID INPUT");
        }
    }

    public static ArrayList<String> putSaturn(ArrayList<String> Planets) {
        Planets.add(5, "Saturn");
        return Planets;
    }

    public static ArrayList<String> makingMatches (ArrayList<String> girls, ArrayList<String> boys) {
        ArrayList<String> mergedList = new ArrayList<>();
        boolean girlsTurn = true;
        while (!(boys.isEmpty() && girls.isEmpty())) {
            if (girlsTurn && !(girls.isEmpty())) {
                mergedList.add(girls.remove(0));
                girlsTurn = false;
            }
            else if (!(boys.isEmpty())) {
                mergedList.add(boys.remove(0));
                girlsTurn = true;
            }
            else {
                girlsTurn = true;
            }
        }
        return mergedList;
    }

    public static List<String> appendA(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) + "a");
        }
        return list;
    }

    public static ArrayList<Object> sweets(ArrayList<Object> list) {
        ArrayList<Object> modList = new ArrayList<>(list);
        modList.set(modList.indexOf(2), "Croissant");
        modList.set(modList.indexOf(false), "Ice cream");
        return modList;
    }

    public static String containsSeven(ArrayList<Integer> list) {
        for (Integer element: list) {
            if (element == 7) {
                return "Hoorray";
            }
        }
        return "Noooooo";
    }

    public static boolean checkNums(ArrayList<Integer> list) {
        return list.containsAll(new ArrayList<>(Arrays.asList(4, 8, 12, 16)));
    }

    public static String quoteSwap(ArrayList<String> list) {
        String correctQuote = "";
        String temp = list.get(list.indexOf("cannot"));
        list.set(list.indexOf("cannot"), list.get(list.indexOf("do")));
        list.set(list.indexOf("do"), temp);

        for (String element: list) {
            correctQuote += element + " ";
        }
        return correctQuote.substring(0, correctQuote.length() - 1);
    }

    public static void calculate(char operator, Integer operandA, Integer operandB) {
        if (operator == '+') {
            System.out.println(operandA + operandB);
        }
        else if (operator == '-') {
            System.out.println(operandA - operandB);
        }
        else if (operator == '*') {
            System.out.println(operandA * operandB);
        }
        else if (operator == '/') {
            System.out.println((double) operandA / (double) operandB);
        }
        else if (operator == '%') {
            System.out.println(operandA % operandB);
        } else {
            System.out.println("ERROR: Invalid operand!");
        }
    }
}
