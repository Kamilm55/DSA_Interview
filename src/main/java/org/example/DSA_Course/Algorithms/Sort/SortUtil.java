package org.example.DSA_Course.Algorithms.Sort;

public class SortUtil {
    protected static void swap(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];// Secure first index
        arr[firstIndex] = arr[secondIndex]; // we lost prev first index value but it is protected in temp
        arr[secondIndex] = temp;
    }
}
