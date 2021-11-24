package com.codurance;

import java.util.Scanner;

public class StringCalculator {

    public int Add(String input) {
        if(input.equals("")) {
            return 0;
        } else {
            String delimeter = "," + "|" + "[\\r\\n]+";

            if (input.startsWith("//")){
                String[] parts = input.split("[\\r\\n]+", 2);
                delimeter = parts[0].substring(2);
                input = parts[1];
            }

            String[] numList = SplitUndefinedNumbers(input, delimeter);
            return sum(numList);
        }
    }

    private static String[] SplitUndefinedNumbers(String input, String delimeter) {
        //return input.split((delimeter + "|" + "[\\r\\n]+"));
        return input.split(delimeter);
    }

    private static int sum(String[] numbers) {
        int sum = 0;

        for (String s : numbers) {
            int number = Integer.parseInt(s.replaceAll("[^0-9]", ""));
            sum += number;
        }
        return sum;
    }

}
