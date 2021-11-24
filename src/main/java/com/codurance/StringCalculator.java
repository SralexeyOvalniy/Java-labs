package com.codurance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringCalculator {
    private static int calledCount  = 0;

    public int Add(String input) {
        calledCount++;
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
            checkForNegativeNumbers(numList);
            System.out.println(calledCount);
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
            //int number = Integer.parseInt(s.replaceAll("[^0-9]", ""));
            int number = Integer.parseInt(s.trim());
            if(number <= 1000) {
                sum += number;
            }
        }
        return sum;
    }

    private static void checkForNegativeNumbers(String[] numbers) {
        List<String> negatives = new ArrayList<>();
        for (String number : numbers) {
            if (number.contains("-")) {
                negatives.add(number);
            }
        }
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed" + negatives);
        }
    }

    public static int getCalledCount() {
        return calledCount;
    }

}
