package javafeatures.algos;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] input = {9, 8, 7, 6, 5, -10, 0, 22, 43};
        bubbleSort(input, 0, input.length - 1);
        System.out.println("------ Recursive Method ------");
        Arrays.stream(input).forEach(d -> System.out.print(d + ", "));
        System.out.println();

        System.out.println("------ Non Recursive Method ------");

        // time complexity - n^2
        int[] array = {9, 8, 7, 6, 5, -10, 0, 22, 43};
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        Arrays.stream(array).forEach(d -> System.out.print(d + ", "));
    }

    private static void bubbleSort(int[] array, int low, int high) {
        if (low < high) {
            for (int i = low; i < high; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            bubbleSort(array, low, high - 1);
        }
    }

}
