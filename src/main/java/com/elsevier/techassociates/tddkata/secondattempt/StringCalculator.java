package com.elsevier.techassociates.tddkata.secondattempt;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        } else if (numbers.startsWith("//")) {
            String[] delimiterAndInputSplit = numbers.split("\n");
            String delimiter = delimiterAndInputSplit[0].substring(2);
            String input = delimiterAndInputSplit[1];
            return sumOfDelimiterSeparatedString(input, delimiter);
        } else if (numbers.contains(",") || numbers.contains("\n")) {
            return sumOfDelimiterSeparatedString(numbers, "[,\\n]");
        }
        return Integer.parseInt(numbers);
    }

    private int sumOfDelimiterSeparatedString(String input, String delimiter) {
        String[] inputSplit = input.split(delimiter);
        int sum = 0;
        for (String stringNumber : inputSplit) {
            sum += Integer.parseInt(stringNumber);
        }
        return sum;
    }
}
