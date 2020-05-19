package com.aditya.personal.algorithmproblems;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LogFiles {

    public static List<String> reorderLines(int logFileSize, List<String> logLines) {

        return logLines.stream()
                // standardize the inputs to lowercase since case insensitive matching.
                .map(String::toLowerCase)

                // now perform the sort
                .sorted((line1, line2) -> {

                    String[] line1Split = line1.split("\\s+");

                    String[] line2Split = line2.split("\\s+");

                    boolean isLine1StartingDigit = Character.isDigit(line1Split[1].charAt(0));

                    boolean isLine2StartingDigit = Character.isDigit(line2Split[1].charAt(0));

                    if (isLine1StartingDigit || isLine2StartingDigit)
                        return isLine1StartingDigit ? (isLine2StartingDigit ? 0 : 1) : -1;

                    int comparisonResult = line1Split[1].compareTo(line2Split[1]);

                    if (comparisonResult != 0)
                        return comparisonResult;

                    return line1Split[0].compareTo(line2Split[0]);

                }).collect(Collectors.toList());

    }

    public static void main(String[] args) {

        List<String> p = reorderLines(4, Arrays.asList("[mi2 jog mid pet]", "[wz3 34 54 398]", "[a1 alps cow bar]", "[x4 45 21 7]"));
        System.out.println(p);
    }

}
