package com.codurance;

public class StringCalculator {

    public int Add(String input) {
        int sum = 0;
        if(input.length() == 0) {
            return 0;
        }
        String[] numbers = input.split(",".trim());

        for (int i =0; i < numbers.length; i++) {
            int number = Integer.parseInt(numbers[i].replaceAll("[^0-9]", ""));
            sum += number;
        }
        System.out.println(sum);
        return sum;
    }
}
