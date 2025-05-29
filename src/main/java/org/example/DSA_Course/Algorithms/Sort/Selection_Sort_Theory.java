package org.example.DSA_Course.Algorithms.Sort;

import java.util.Arrays;

// https://www.youtube.com/watch?v=Nd4SCCIHFWk&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ
public class Selection_Sort_Theory {
    public static void main(String[] args) {
        int[] unsortedArr = new int[]{ 897,53,6,-8,0,9,49,48,787};
        int[] sortedArr = new int[]{1,2,3,4,5};

        System.out.println(Arrays.toString(selectionSort(unsortedArr)));
        System.out.println(Arrays.toString(selectionSort(sortedArr)));

        /*** Big O
         * 1. Time Complexity --> Quadratic O(N^2)
         Best Case -> O(N^2)
         Worst Case -> O(N^2)
         Max value tapmaq ucun her iki loop calismalidir,her element ile compare etmelidir

         * 2. Space Complexity --> Constant O(1)
         ***/
    }

    private static int[] selectionSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {// en boyuk elementi axira yerlesdirir
            int max = arr[0];  // Default assume first element as max, then change
            int indexOfMax = 0; // default
            int lastIndex = arr.length - 1 - i;

            for (int j = 1; j < arr.length - i; j++) {// inner loop max element tapir, soldaki unsorted hisse ucun
                if(arr[j] > max) {
                    indexOfMax = j;
                }
            }

            // Swap last element of unsorted part and max element
            int temp = arr[lastIndex] ;
            arr[lastIndex] = arr[indexOfMax];
            arr[indexOfMax] = temp;
        }

        return arr;
    }
}
