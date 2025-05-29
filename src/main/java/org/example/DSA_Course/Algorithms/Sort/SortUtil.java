package org.example.DSA_Course.Algorithms.Sort;

public class SortUtil {
    protected static void swap(int[] arr, int first, int second) {
        int temp = arr[first];// Secure first index
        arr[first] = arr[second]; // we lost prev first index value but it is protected in temp
        arr[second] = temp;
    }
}
