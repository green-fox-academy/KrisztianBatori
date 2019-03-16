package com.greenfoxacademy.frontend.models;

import java.util.Arrays;

public class SithTextGenerator {

    private static String[] randomWords = new String[] {"Arrgh.", "Uhmm.", "Garh.", "Err..err.err.", "Huff."};

    public static String generateSithText(String text) {
        if (text.length() == 1) {
            return text;
        }
        else {
            StringBuilder stringBuilder = new StringBuilder();
            String[] textSplittedToSentences = text.split("\\. ");

            for (int i = 0; i < textSplittedToSentences.length; i++) {

                String[] sentenceSplitted = textSplittedToSentences[i].split(" ");

                sentenceSplitted[1] = sentenceSplitted[1].substring(0, 1).toUpperCase() + sentenceSplitted[1].substring(1);
                sentenceSplitted[0] = sentenceSplitted[0].substring(0, 1).toLowerCase() + sentenceSplitted[0].substring(1);

                for (int j = 1; i < text.length(); j += 2) {
                    try {
                        stringBuilder.append(sentenceSplitted[j] + " ");
                        stringBuilder.append(sentenceSplitted[j - 1] + " ");
                    } catch (IndexOutOfBoundsException e) {
                        stringBuilder.append(sentenceSplitted[j - 1]);
                        if (stringBuilder.charAt(stringBuilder.length() - 1) != 46) {
                            stringBuilder.append(". ");
                        }
                        else {
                            stringBuilder.append(" ");
                        }
                        break;
                    }
                }

                if ((int) (Math.random() * 2) == 0) {
                    stringBuilder.append(randomWords[(int) (Math.random() * randomWords.length)] + " ");
                }
                else {
                    stringBuilder.append(randomWords[(int) (Math.random() * randomWords.length)] + " ");
                    stringBuilder.append(randomWords[(int) (Math.random() * randomWords.length)] + " ");
                }
            }

            stringBuilder.setLength(stringBuilder.length() - 1);    // For getting rid of the last whitespace character.
            return stringBuilder.toString();
        }
    }
}
