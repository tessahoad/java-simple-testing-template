package com.elsevier.techassociates.tddkata.secondattempt;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    private final StringCalculator stringCalculator = new StringCalculator();

    @Test
    public void addShouldReturnZeroWhenPassedEmptyString() {
        int actualResult = stringCalculator.add("");
        int expectedResult = 0;

        assertEquals(expectedResult, actualResult, "Expected " + expectedResult + " result was " + actualResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    public void addShouldReturnTheQuotedValueWhenPassed(String number) {
        int actualResult = stringCalculator.add(number);
        int expectedResult = Integer.parseInt(number);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void addShouldReturnTheSumOfTwoCommaSeparatedQuotedValuesWhenPassed() {
        int actualResult = stringCalculator.add("1,2");
        int expectedResult = 3;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void addShouldReturnTheSumOfThreeCommaSeparatedQuotedValuesWhenPassed() {
        int actualResult = stringCalculator.add("1,2,3");
        int expectedResult = 6;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void addShouldReturnTheSumOfFourCommaSeparatedQuotedValuesWhenPassed() {
        int actualResult = stringCalculator.add("1,2,3,4");
        int expectedResult = 10;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void addShouldReturnTheSumOfTwoNewLineSeparatedQuotedValuesWhenPassed() {
        int actualResult = stringCalculator.add("1\n2");
        int expectedResult = 3;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void addShouldReturnTheSumOfThreeNewLineAndCommaSeparatedQuotedValuesWhenPassed() {
        int actualResult = stringCalculator.add("1\n2,3");
        int expectedResult = 6;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void addShouldReturnSumWhenGivenDelimiter() {
        int actualResult = stringCalculator.add("//;\n1;2");
        int expectedResult = 3;

        assertEquals(expectedResult, actualResult);
    }
}
