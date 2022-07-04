package com.example.stringcalculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StringCalculationStepFourTest {

    private final StringCalculator stringCalculator = new StringCalculator();

    @ParameterizedTest
    @MethodSource("shouldReturnTheSumWhenStringContainsNewLinesParams")
    void should_return_the_sum_when_string_contains_commas_or_new_lines(String numbers, int expectedResult) {
        int actualResult = stringCalculator.add(numbers);
        assertEquals(expectedResult, actualResult);
    }

    public static Stream<Arguments> shouldReturnTheSumWhenStringContainsNewLinesParams() {
        return Stream.of(
                Arguments.of("//;\n1;2;8;9", 20),
                Arguments.of("10;20;8;9;0", 47),
                Arguments.of("//,\n5,5,6,0", 16),
                Arguments.of("//:\n7:3:100", 110)
        );
    }


}
