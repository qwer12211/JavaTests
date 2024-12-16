package org.example;

import java.util.*;

public class Calculater {


    public String findWordWithMostI(String sentence) {
        if (sentence == null ) {
            throw new IllegalArgumentException("Предложение не может быть пустым");
        }

        String[] words = sentence.split("");
        String resultWord = "";
        int maxCount = 0;

        for (String word : words) {
            int count = 0;
            for (char c : word.toCharArray()) {
                if (c == 'И' || c == 'и') {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                resultWord = word;
            }
        }
        return resultWord;
    }



    public int findMaxDiagonalSum(int[][] matrix) {
        int diagonal1Sum = 0;
        int diagonal2Sum = 0;
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            diagonal1Sum += matrix[i][i];
            diagonal2Sum += matrix[i][n - 1 - i];
        }

        return Math.max(diagonal1Sum, diagonal2Sum);
    }


    public String getFirstLettersInUpperCase(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(word.charAt(0));
            }
        }

        return result.toString().toUpperCase();
    }










    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }
}
