package javafeatures.algos;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] input = {9,8,7,6,22,43};
        quickSort(input, 0, input.length - 1);
        Arrays.stream(input).forEach(d -> System.out.print(d + ", "));
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }

    }

    private static int partition(int[] array, int low, int high) {
        Arrays.stream(array).forEach( d -> System.out.print(d + ", "));
        System.out.println();
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        i++;
        int temp = array[i];
        array[i] = pivot;
        array[high] = temp;
        return i;


    }
}
