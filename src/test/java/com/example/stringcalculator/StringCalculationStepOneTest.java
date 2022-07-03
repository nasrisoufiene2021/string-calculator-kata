package com.example.stringcalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StringCalculationStepOneTest {

    private final StringCalculator stringCalculator = new StringCalculator();

    @Test
    void should_return_zero_when_empty_string() {
        String numbers = "";
        int actualResult = stringCalculator.add(numbers);
        assertEquals(0, actualResult);
    }

    @ParameterizedTest
    @CsvSource({"1,1", "2,2", "3,3", "100,100"})
    void should_return_given_number_when_string_contains_only_one_number(String numbers, int expectedResult) {
        int actualResult = stringCalculator.add(numbers);
        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @MethodSource("shouldReturnTheSumWhenStringContainsTowNumbersParams")
    void should_return_the_sum_when_string_contains_tow_numbers(String numbers, int expectedResult) {
        int actualResult = stringCalculator.add(numbers);
        assertEquals(expectedResult, actualResult);
    }

    public static Stream<Arguments> shouldReturnTheSumWhenStringContainsTowNumbersParams() {
        return Stream.of(
                Arguments.of("1,2", 3),
                Arguments.of("4,2", 6),
                Arguments.of("8,9", 17),
                Arguments.of("5,0", 5),
                Arguments.of("0,0", 0),
                Arguments.of("0,4", 4)
        );
    }


}
