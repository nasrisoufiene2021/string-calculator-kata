package com.example.stringcalculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StringCalculationStepFiveTest {

    private final StringCalculator stringCalculator = new StringCalculator();

    @ParameterizedTest
    @MethodSource("shouldThrowExceptionWhenStringContainsNegativeNumber")
    void should_throw_exception_when_string_contains_negative_number(String numbers, int expectedResult) {
        int actualResult = 0;
        try {
            actualResult = stringCalculator.add(numbers);
            assertEquals(expectedResult, actualResult);
        } catch(IllegalArgumentException e){

        }
    }

    public static Stream<Arguments> shouldThrowExceptionWhenStringContainsNegativeNumber() {
        return Stream.of(
                Arguments.of("//;\n1;2;8;-9", 20)
        );
    }


}
