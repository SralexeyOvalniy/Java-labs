package com.codurance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StringCalculator {

    private static int calledCount  = 0;

    public int Add(String input) {
        calledCount++;
        if(input.equals("")) {
            return 0;
        } else {
            //Default Delimeter
            String delimeter = "," + "|" + "[\\r\\n]+";

            if (input.startsWith("//")){
                String[] parts = input.split("[\\r\\n]+", 2);
                //delimeter = parts[0].substring(2);
                delimeter = parseDelimeter(parts[0]);
                input = parts[1];
            }

            String[] numList = SplitUndefinedNumbers(input, delimeter);
            checkForNegativeNumbers(numList);
            System.out.println(getCalledCount());
            return sum(numList);
        }
    }

    private static String[] SplitUndefinedNumbers(String input, String delimeter) {
        return input.split(delimeter);
    }

    private static String parseDelimeter(String header) {
        String delimeter = header.substring(2);
        if (delimeter.startsWith("[")) {
            delimeter = delimeter.substring(1, delimeter.length()-1);
        }
        return delimeterUnion(delimeter);
    }

    private static String delimeterUnion(String delimeter) {
        String[] temp, fin;
        String uDelimeter;

        temp = delimeter.split("]\\[");
        fin = new String[temp.length];
        for(int i =0; i < temp.length; i++) {
            temp[i] = Pattern.quote(temp[i]);
            fin[i] = temp[i];
        }
        uDelimeter = Arrays.toString(fin);

        return uDelimeter;
    }

    private static int sum(String[] numbers) {
        int sum = 0;

        for (String s : numbers) {
            if(s.isEmpty()) {
                continue;
            } else {
                int number = Integer.parseInt(s.trim());
                if(number <= 1000) {
                    sum += number;
                }
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
