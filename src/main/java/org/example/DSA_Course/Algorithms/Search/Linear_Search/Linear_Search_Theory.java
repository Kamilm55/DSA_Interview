package org.example.DSA_Course.Algorithms.Search.Linear_Search;
// https://youtu.be/_HRA37X8N_Q?si=NoWROYX6mKKwkzHA
public class Linear_Search_Theory {
    public static void main(String[] args) {
        /*** Big O
         * 1. Time Complexity --> Linear O(N)
         Best: O(1) ->  Constant (Ilk element)
         Worst: O(N) -> Size of the array (Son element)
         Linear graph Time/Size of the array -> Size artdiqca Time-da artir --> O(N)
         "Whenever the size of the array increases, the time also increases proportionally."

         * 2. Space Complexity --> Constant O(1)
         When analyzing linear search, we're looking at how much extra memory (not including the input array itself) is needed to perform the search.
         Hec bir extra array isletmedik, copy etmedik sadece variable

         The input array arr is not counted in space complexity (we assume it’s already given).
         The function only uses a constant amount of extra space:
         A few variables: i, target, and possibly the return value.
         No extra data structures that grow with input size (like lists, hash tables, etc.)

         * This means:
         * Time increases with input size (O(n))
         * Memory usage stays the same regardless of input size (O(1))
         ***/

        int arr[] = new int[]{ 5,6,8,9,49,48,787};
        System.out.println(linearSearch(arr, 5)); // 0
        System.out.println(linearSearch(arr, 787));// 6
        System.out.println(linearSearch(arr, 48)); // 5
        System.out.println(linearSearch(arr, 456)); // -1
        System.out.println(linearSearch(new int[]{},48));// -1 empty array

    }

    private static int linearSearch(int[] arr, int num) {
        if (arr.length == 0) return -1;

        for (int i = 0; i < arr.length; i++)
                if (num == arr[i]) return i; // 'input' hansi 'indexdeki element'e beraberdise hemin 'index'i return et


        return -1; // Eger yuxarida hec ne tapilmasa, return edilmese
    }
}
