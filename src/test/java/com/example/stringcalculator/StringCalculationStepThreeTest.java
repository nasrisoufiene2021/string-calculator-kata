package com.example.stringcalculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StringCalculationStepThreeTest {

    private final StringCalculator stringCalculator = new StringCalculator();

    @ParameterizedTest
    @MethodSource("shouldReturnTheSumWhenStringContainsNewLinesParams")
    void should_return_the_sum_when_string_contains_commas_or_new_lines(String numbers, int expectedResult) {
        int actualResult = stringCalculator.add(numbers);
        assertEquals(expectedResult, actualResult);
    }

    public static Stream<Arguments> shouldReturnTheSumWhenStringContainsNewLinesParams() {
        return Stream.of(
                Arguments.of("1,2\n8,9", 20),
                Arguments.of("10\n20,8\n9\n0", 47),
                Arguments.of("5\n5\n6\n0", 16),
                Arguments.of("7\n3,6,4,8,2\n100\n200\n300\n5,5,60", 700)
        );
    }


}
