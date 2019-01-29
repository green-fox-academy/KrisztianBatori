import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExceptionsAndFiles {
    public static void main(String[] args) {

        // 01 - Divide by zero
        int number = 5;
        System.out.println(divide(number));

        // 02 - Print each line
        try {
            Path filePath = Paths.get("../GreenFox/my-file.txt");
            for (String text: Files.readAllLines(filePath)) {
                System.out.println(text);
            }
        } catch (Exception e) {
            System.out.println("Unable to read file: my-file.txt");
        }

        // 03 - Count lines
        System.out.println(fileCountLines("../GreenFox/my-file.txt"));

        // 04 - Write single line
        writeLine("../GreenFox/my-file.txt", "Krisztián Bátori");

        // 05 - Write multiple lines
        writeMultipleLines("../GreenFox/my-file.txt", "Greenfox Power", 5);

        // 06 - Copy file
        copyFile("../GreenFox/my-file.txt", "../GreenFox/new-file.txt");

        // 07 - Logs
        for (String address: getUniqueIPs("../GreenFox/log.txt")) {
            System.out.println(address);
        }
        System.out.println();
        int[] ratio = GetPostRatio("../GreenFox/log.txt");
        System.out.println(ratio[0] + " : " + ratio[1]);

        // 08 - Tic tac toe
        System.out.println(ticTacResult("../GreenFox/win-o.txt"));
        System.out.println(ticTacResult("../GreenFox/win-x.txt"));
        System.out.println(ticTacResult("../GreenFox/draw.txt"));

        // 09 - Doubled
        for (String line: decryptFile("../GreenFox/duplicated_chars.txt")) {
            System.out.println(line);
        }
        System.out.println();

        // 10 - Reversed lines
        for (String line: reverseFile("../GreenFox/reversed_chars.txt")) {
            System.out.println(line);
        }
        System.out.println();

        // +1 - Encode lines
        for (String line: decodeFile("../GreenFox/encoded_chars.txt")) {
            System.out.println(line);
        }
        System.out.println();

        // +2 - Lottery
        System.out.println(getMostCommonNumber("../GreenFox/lottery.csv"));
    }

    public static int divide(int divisor) {
        int result = 0;
        try {
            result = 10 / divisor;
        }
        catch (ArithmeticException e) {
            System.out.println("fail");
        }
        return result;
    }

    public static int fileCountLines (String pathFile) {
        try {
            Path filePath = Paths.get(pathFile);
            return Files.readAllLines(filePath).size();
        } catch (Exception e) {
            return 0;
        }
    }

    public static void writeLine (String pathFile, String textToWrite) {
        try {
            Path filePath = Paths.get(pathFile);
            Files.write(filePath, new ArrayList<String>() {{ add(textToWrite); }});
        } catch (Exception e) {
            System.out.println("Unable to read file: my-file.txt");
        }
    }

    public static void writeMultipleLines (String pathFile, String textToWrite, int numberOfLines) {
        try {
            Path filePath = Paths.get(pathFile);
            for (int i = 0; i < numberOfLines; i++) {
                Files.write(filePath, new ArrayList<String>() {{ add(textToWrite); }}, StandardOpenOption.APPEND);
            }
        } catch (Exception e) {
        }
    }

    public static boolean copyFile (String fileToCopy, String newFile) {
        try {
            Files.write(Paths.get(newFile), Files.readAllLines(Paths.get(fileToCopy)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static ArrayList<String> getUniqueIPs (String pathFile) {
        try {
            return (ArrayList<String>)Files.lines(Paths.get(pathFile))
                    .map(line -> line.split("   ")[1]).distinct()
                    .collect(Collectors.toList());
        } catch (Exception e) {
            return new ArrayList<>() {
                {
                    add("ERROR");
                }
            };
        }
    }

    public static int[] GetPostRatio (String pathFile) {
        try {
            return new int[] {
                    (int)Files.lines(Paths.get(pathFile))
                            .map(line -> line.split("   ")[2])
                            .filter(line -> line.startsWith("POST"))
                            .count(),
                    (int)Files.lines(Paths.get(pathFile))
                            .map(line -> line.split("   ")[2])
                            .filter(line -> line.startsWith("GET"))
                            .count(),
            };
        } catch (Exception e) {
            return new int[] {
                    0, 0
            };
        }
    }

    public static String ticTacResult(String pathFile) {
        try {
            ArrayList<String[]> lines = (ArrayList<String[]>)Files.lines(Paths.get(pathFile))
                                            .map(line -> line.split(""))
                                            .collect(Collectors.toList());

            for (int i = 0; i < 2; i++) {   // Check the vertical lines
                if (lines.get(i)[0].equals("O") && lines.get(i)[1].equals("O") && lines.get(i)[2].equals("O")) {
                    return "O";
                }
                else if (lines.get(i)[0].equals("X") && lines.get(i)[1].equals("X") && lines.get(i)[2].equals("X")) {
                    return "X";
                }
            }

            for (int i = 0; i < 2; i++) {   // Check the horizontal lines
                if (lines.get(0)[i].equals("O") && lines.get(1)[i].equals("O") && lines.get(2)[i].equals("O")) {
                    return "O";
                }
                else if (lines.get(0)[i].equals("X") && lines.get(1)[i].equals("X") && lines.get(2)[i].equals("X")) {
                    return "X";
                }
            }

            // Finally, the cross lines

            if (lines.get(0)[0].equals("O") && lines.get(1)[1].equals("O") && lines.get(2)[2].equals("O")) {
                return "O";
            }
            else if (lines.get(0)[0].equals("X") && lines.get(1)[1].equals("X") && lines.get(2)[2].equals("X")) {
                return "X";
            }

        } catch (Exception e) {
        }
        return "Draw";
    }

    public static ArrayList<String> decryptFile (String pathFile) {
        try {
            ArrayList<String> list = (ArrayList<String>)Files.lines(Paths.get(pathFile))
                                            .collect(Collectors.toList());

            for (int i = 0; i < list.size(); i++) {
                String newText = "";
                for (int distinctIndex = 0; distinctIndex < list.get(i).length(); distinctIndex += 2) {
                    newText += list.get(i).charAt(distinctIndex);
                }
                list.set(i, newText);
            }

            return list;

        } catch (Exception e) {
            return new ArrayList<>() {
                {
                    add("ERROR");
                }
            };
        }
    }
    public static ArrayList<String> reverseFile (String pathFile) {
        try {
            ArrayList<String> list = (ArrayList<String>)Files.lines(Paths.get(pathFile))
                    .collect(Collectors.toList());

            for (int i = 0; i < list.size(); i++) {
                list.set(i, new StringBuilder(list.get(i)).reverse().toString());
            }

            return list;

        } catch (Exception e) {
            return new ArrayList<>() {
                {
                    add("ERROR");
                }
            };
        }
    }
    public static ArrayList<String> decodeFile (String pathFile) {
        try {
            ArrayList<String> list = (ArrayList<String>)Files.lines(Paths.get(pathFile))
                    .collect(Collectors.toList());

            for (int i = 0; i < list.size(); i++) {
                String newText = "";
                for (int j = 0; j < list.get(i).length(); j++) {
                    newText += (char)(list.get(i).charAt(j) - 1);
                }
                list.set(i, newText);
            }

            return list;

        } catch (Exception e) {
            return new ArrayList<>() {
                {
                    add("ERROR");
                }
            };
        }
    }

    public static Integer getMostCommonNumber (String pathFile) {
        try {
            ArrayList<String[]> numbers = (ArrayList<String[]>)Files.lines(Paths.get(pathFile))
                    .map(line -> line.split(";", 12)[11])
                    .map(line -> line.split(";"))
                    .collect(Collectors.toList());


            HashMap<String, Integer> lottery_numbers = new HashMap<>();

            for (String[] week_numbers: numbers) {
                for (String number: week_numbers) {
                    if (!(lottery_numbers.containsKey(number))) {
                        lottery_numbers.put(number, 1);
                    }
                    else {
                        lottery_numbers.replace(number, lottery_numbers.get(number) + 1);
                    }
                }
            }

            Integer max = 0;
            String maxKey = "";

            for (String key: lottery_numbers.keySet()) {
                if (lottery_numbers.get(key) > max) {
                    max = lottery_numbers.get(key);
                    maxKey = key;
                }
            }

            return Integer.parseInt(maxKey);

        } catch (Exception e) {
            return 0;
        }
    }
}
