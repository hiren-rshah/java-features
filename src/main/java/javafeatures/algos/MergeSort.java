package javafeatures.algos;

import java.util.Arrays;

public class MergeSort {

    public static void divide(int[] arr, int startIndex, int endIndex) {


        if (startIndex >= endIndex) {
            return;
        }
        int midIndex = startIndex + (endIndex - startIndex) / 2;
        divide(arr, startIndex, midIndex);
        divide(arr, midIndex + 1, endIndex);
        conquer(arr, startIndex, midIndex, endIndex);
    }

    private static void conquer(int[] arr, int startIndex, int midIndex, int endIndex) {
        Arrays.stream(arr).forEach(d -> System.out.print(d + ", "));
        System.out.println("");
        int[] mergedArr = new int[endIndex - startIndex + 1];
        int index1 = startIndex;
        int index2 = midIndex + 1;
        int x = 0;
        while (index1 <= midIndex && index2 <= endIndex) {
            if (arr[index1] <= arr[index2]) {
                mergedArr[x] = arr[index1];
                x++; index1++;
            } else {
                mergedArr[x] = arr[index2];
                x++; index2++;
            }
        }
        while(index1 <= midIndex){
            mergedArr[x++] = arr[index1++];
        }
        while (index2 <= endIndex) {
            mergedArr[x++] = arr[index2++];
        }

        for(int i=0, j = startIndex;  i < mergedArr.length ; i++, j++){
            arr[j] = mergedArr[i];
        }

    }


    public static void main(String[] args) {
        int[] input = {9,8,7,6,22,43};
        divide(input, 0, input.length-1);
        Arrays.stream(input).forEach(d -> System.out.print(d + ", "));
    }
}
