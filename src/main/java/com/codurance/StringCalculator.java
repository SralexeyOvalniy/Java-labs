package com.codurance;

public class StringCalculator {

    public int Add(String input) {

        if(input.length() == 0) {
            return 0;
        } else {
            String[] numList = SplitUndefinedNumbers(input);
            return sum(numList);
        }
    }

    private static String[] SplitUndefinedNumbers(String input) {
        return input.split(("[\\r\\n|,]").trim());
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
