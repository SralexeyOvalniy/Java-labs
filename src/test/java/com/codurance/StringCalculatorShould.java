package com.codurance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class StringCalculatorShould {

    private StringCalculator stringCalculator;
    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource(value ={
            "''; 0",
            "0, 0; 0",
            "1, 0; 1",
            "1, 2; 3",
            "1, 2, 3, 4, 5, 6, 7, 8, 9; 45",
            "'1\n2, 3'; 6",
            "'1,\n2, 3'; 6"
    }, delimiter = ';')
    void returns_correct_output_with_input(String input, int output) {
        Assertions.assertEquals(output, stringCalculator.Add(input));
    }

}
