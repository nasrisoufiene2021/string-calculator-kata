package com.example.stringcalculator;

import java.util.Arrays;

public class StringCalculator {

    public int add(String numbers) {

        if(numbers.isEmpty()){
            return 0;
        }

        String[] lines = numbers.split("\n");
        String lineNumbers = numbers;
        String delim = ";";

        if(lines.length > 1 && lines[0].length() == 3){
            lineNumbers = lines[1];
            delim = String.valueOf(lines[0].charAt(2));
        }

        lineNumbers.split(delim);
        return Arrays.stream(lineNumbers.split(delim))
                .mapToInt(Integer::parseInt).sum();
    }
}
