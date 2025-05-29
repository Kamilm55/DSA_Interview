package org.example.DSA_Course.Algorithms.Sort;

import java.util.Arrays;

import static org.example.DSA_Course.Algorithms.Sort.SortUtil.swap;

// https://www.youtube.com/watch?v=By_5-RRqVeE
// animation gif -> https://www.google.com/url?sa=i&url=https%3A%2F%2Fcommons.wikimedia.org%2Fwiki%2FFile%3AInsertion-sort-example.gif&psig=AOvVaw36bYYcJYNBnrV9mSP9nr15&ust=1748620635399000&source=images&cd=vfe&opi=89978449&ved=0CBMQjRxqFwoTCKDEiIKGyY0DFQAAAAAdAAAAABAE
public class Insertion_Sort_Theory {
    public static void main(String[] args) {
        // Why Insertion sort?
        // 1. Steps get reduced if array is sorted (Same as buble)
        // 2. Number of swaps reduced as compared to buble --> It mostly shifts elements instead of swapping them
        // Used for smaller values of N. It is good for partially sorted array.
        // It takes part in hybrid sorting algorithms. (Merge sort-da istifade ede bilerik)

        int[] unsortedArr = new int[]{ 897,53,6,-8,0,9,49,48,787};
        int[] sortedArr = new int[]{1,2,3,4,5};

        System.out.println(Arrays.toString(insertionSort(unsortedArr)));
        System.out.println(Arrays.toString(insertionSort(sortedArr)));
        /*** Big O
         * 1. Time Complexity --> Quadratic O(N^2)     // general unsorted array
         *    Best Case -> O(N)          // when the array is already sorted
         *    Worst Case -> O(N^2)       // when the array is sorted in reverse order
         *    Explanation: In the worst case, for each element, we may need to compare with all previous elements.

         * 2. Space Complexity --> Constant O(1)
         *    Explanation: Insertion sort is an in-place sorting algorithm. It doesn't require extra space.
         ***/

    }

    // Sola dogru yigilir, i index-den sol teref artiq sorteddir.
    private static int[] insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++)  // j=i+1 -> index out of bound olmasin deye (len - 1)-e qeder davam edecek
            for (int j = i + 1; j > 0; j--) {
                if(arr[j] < arr[j - 1]){
                   swap(arr, j,j-1);
                } else if (arr[j] > arr[j - 1]) { // *** If I don't write this line at code even in best case it executes as N^2***
                    break;
                }
            }

        return arr;
    }
}
