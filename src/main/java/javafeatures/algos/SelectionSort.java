package javafeatures.algos;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] input = {9, 8, 7, 6, 5, -10, 0, 22, 43};
        Arrays.stream(input).forEach(d -> System.out.print(d + ", "));
        System.out.println();

        System.out.println("------ Non Recursive Method ------");

        for (int i = 0; i < input.length - 1; i++) {
            int smallIndex = i;
            for (int j = i+1; j < input.length; j++) {
                if (input[j] < input[smallIndex]) {
                    smallIndex = j;
                }
            }
            int temp = input[smallIndex];
            input[smallIndex] = input[i];
            input[i] = temp;
        }
        Arrays.stream(input).forEach(d -> System.out.print(d + ", "));
    }

}
