package com.elsevier.techassociates.tddkata.firstattempt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        else if (numbers.startsWith("//")) {
            String[] delimiterInputSplit = numbers.split("\n", 2);
            String delimiter = delimiterInputSplit[0].substring(2);

            return sumInputWithDelimiter("[" + delimiter + "]", delimiterInputSplit[1]);
        }
        else if (numbers.contains(",") || numbers.contains("\n")) {
            return sumInputWithDelimiter("[,\\n]", numbers);
        }
        else {
            int parsedInt = Integer.parseInt(numbers);
            validateInts(List.of(parsedInt));
            return parsedInt;
        }
    }

    private void validateInts(List<Integer> numbers) {
        List<Integer> invalidNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (number < 0) {
                invalidNumbers.add(number);
            }
        }
        if (invalidNumbers.size() > 0) {
            throw new RuntimeException("negatives not allowed, bad number were" + Arrays.toString(invalidNumbers.toArray()));
        }
    }

    private Integer sumInputWithDelimiter(String delimiter, String delimiterInputSplit) {
        Pattern pattern = Pattern.compile(delimiter);
        String[] splitNumbers = delimiterInputSplit.split(pattern.pattern());
        List<Integer> parsedInts = new ArrayList<>(splitNumbers.length);
        for (String stringNumber: splitNumbers) {
            int parsedInt = Integer.parseInt(stringNumber);
            parsedInts.add(parsedInt);
        }
        validateInts(parsedInts);
        return parsedInts.stream().reduce(0, Integer::sum);
    }
}
