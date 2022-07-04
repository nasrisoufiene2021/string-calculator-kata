package com.example.stringcalculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StringCalculationStepTowTest {

    private final StringCalculator stringCalculator = new StringCalculator();

    @ParameterizedTest
    @MethodSource("shouldReturnTheSumWhenStringContainsUnknownAmountNumbersParams")
    void should_return_the_sum_when_string_contains_unknown_amount_of_numbers(String numbers, int expectedResult) {
        int actualResult = stringCalculator.add(numbers);
        assertEquals(expectedResult, actualResult);
    }

    public static Stream<Arguments> shouldReturnTheSumWhenStringContainsUnknownAmountNumbersParams() {
        return Stream.of(
                Arguments.of("1;2;8;9", 20),
                Arguments.of("10;20;8;9;0", 47),
                Arguments.of("5;5;6;0", 16),
                Arguments.of("7;3;6;4;8;2;100;200;300;5;5;6;0", 646)
        );
    }


}
