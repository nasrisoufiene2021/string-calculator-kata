package com.example.stringcalculator;

import java.util.Arrays;

public class StringCalculator {

    public int add(String numbers) {
        if(numbers.isEmpty()){
            return 0;
        }
        return Arrays.stream(numbers.split("[,\n]"))
                .mapToInt(Integer::parseInt).sum();
    }
}
