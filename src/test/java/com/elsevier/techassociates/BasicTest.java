package com.elsevier.techassociates;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicTest {
    @Test
    public void shouldSuccessfullyRunTest() {
        //given
        String expectedResult = "result";

        //when
        String actualResult = "result";

        //then
        assertEquals(expectedResult, actualResult);
    }
}
