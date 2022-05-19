package com.elsevier.techassociates.tddkata.firstattempt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator();

    @Test
    public void addShouldReturn0ForEmptyString() {
        int expectedResult = 0;
        int actualResult = calculator.add("");

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void addShouldReturnValueForSingleValue() {
        int expectedResult = 1;
        int actualResult = calculator.add("1");

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void addShouldReturnSumForCommaSeparatedStringOfTwoNumbers() {
        int expectedResult = 3;
        int actualResult = calculator.add("1,2");

        assertEquals(expectedResult, actualResult);
    }

    /// ~ 5mins once I remembered how to write Java methods

    @Test
    public void addShouldReturnSumForCommaSeparatedStringOfThreeNumbers() {
        int expectedResult = 6;
        int actualResult = calculator.add("1,2,3");

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void addShouldReturnSumForCommaSeparatedStringOfFiveNumbers() {
        int expectedResult = 15;
        int actualResult = calculator.add("1,2,3,4,5");

        assertEquals(expectedResult, actualResult);
    }

    // 10 mins

    @Test
    public void addShouldReturnSumForNewLineSeparatedStringOfTwoNumbers() {
        int expectedResult = 3;
        int actualResult = calculator.add("1\n2");

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void addShouldReturnSumForCommaAndNewLineSeparatedStringOfThreeNumbers() {
        int expectedResult = 6;
        int actualResult = calculator.add("1\n2,3");

        assertEquals(expectedResult, actualResult);
    }

    // 15 mins

    @Test
    public void addShouldSupportCustomDelimiter() {
        int expectedResult = 3;
        int actualResult = calculator.add("//;\n1;2");

        assertEquals(expectedResult, actualResult);
    }

    // 25 mins

    @Test
    public void addThrowWhenNegativeAndSingleNumber() {
        Assertions.assertThrows(RuntimeException.class, () -> calculator.add("-1"));
    }

    @Test
    public void addThrowWhenNegativeAndCommaSeparatedString() {
        Assertions.assertThrows(RuntimeException.class, () -> calculator.add("-1,2"));
    }

    @Test
    public void addThrowWhenNegativeAndCustomDelimiter() {
        Assertions.assertThrows(RuntimeException.class, () -> calculator.add("//;\n-1;2"));
    }

    //33 mins

    @Test
    public void addThrowWhenManyNegativesAndCommaSeparatedString() {
        Assertions.assertThrows(RuntimeException.class, () -> calculator.add("-1,-2"));
    }

    @Test
    public void addThrowWhenManyNegativesAndCustomDelimiter() {
        Assertions.assertThrows(RuntimeException.class, () -> calculator.add("//;\n-1;-2"));
    }

    // 40 mins
}
