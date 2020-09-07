package com.codersbay;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println();
        System.out.println("Enter you list:");

        Scanner s = new Scanner(System.in);
        String inputStr = "";
        int[] userInput = new int[1];
        boolean firsttime = true;
        while (true) {
            inputStr = s.nextLine();
            // abort of the input
            if (inputStr.toLowerCase().contains("q")) {
                break;
            }
            // to get a number out of the String
            int result = 0;
            boolean positivSign = true;
            String help = "";
            for (int j = 0; j < inputStr.length(); j++) {
                if (inputStr.charAt(j) >= '0' && inputStr.charAt(j) <= '9') {
                    help += inputStr.charAt(j);
                } else if (inputStr.charAt(j) == '-' && help.isEmpty()) {
                    positivSign = false;
                }
            }
            for (int j = 0, h = help.length() - 1; j < help.length(); j++, h--) {
                if (help.charAt(j) >= '0' && help.charAt(j) <= '9') {
                    result += Math.pow(10, h) * (help.charAt(j) - '0');
                }
            }
            if (!positivSign) {
                result *= -1;
                positivSign = true;
            }

            // the userInput Array has already one element so the first time i have to fill that.
            if (firsttime) {
                userInput[0] = result;
                firsttime = false;
            } else {
                userInput = addElement(userInput, result);
            }
        }
        System.out.println("Your list with " + userInput.length + " elements:");
        System.out.println(Arrays.toString(userInput));

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < userInput.length; i++) {
            if (userInput[i] > max) {
                max = userInput[i];
            }
        }
        System.out.println("the maximum is " + max);
    }

    public static int[] addElement(int[] inputArray, int inputElement) {
        int[] help = new int[inputArray.length + 1];

        for (int i = 0; i < inputArray.length; i++) {
            help[i] = inputArray[i];
        }

        help[help.length - 1] = inputElement;
        return (help);
    }
}