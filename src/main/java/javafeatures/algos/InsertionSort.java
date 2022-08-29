package javafeatures.algos;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] input = {9, 8, 7, 6, 5, -10, 0, 55, 43};
        Arrays.stream(input).forEach(d -> System.out.print(d + ", "));
        System.out.println();

        System.out.println("------ Non Recursive Method ------");

        for (int i = 1; i < input.length; i++) {
            int current = input[i];
            int j = i - 1;
            while (j >= 0 && current < input[j]) {
                input[j + 1] = input[j];
                j--;
            }
            input[j + 1] = current;

        }
        Arrays.stream(input).forEach(d -> System.out.print(d + ", "));
    }

}
