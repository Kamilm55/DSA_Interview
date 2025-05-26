package org.example.DSA_Course.Algorithms.Search.Binary_Search;
// https://www.youtube.com/watch?v=f6UU7V3szVw&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ
public class Binary_Search_Theory {
    public static void main(String[] args) {

        /***
         * If given arr is sorted try binary search firstly to solve the problem!
         * Big O:
         Time Complexity: O(log₂ n) Logarithmic
         Space Complexity: O(1) Constant

         For the worst case:
         N - arr-daki element sayi
         k - quvvet (nece defe arr split olubsa)
         1 = N / 2^k --> N = 2^k
         logN = log2^k --> logN = klog2
         k = logN / log2 -> k = log₂ n
         ***/
        // Array must be sorted for binary search
        int[] sortedArr = new int[]{-15,-5,25,45,59,78,98,100};// Asc order
        int[] descSortedArr = new int[]{100,45,45,45,19,8,-12,-56};// Desc order

        System.out.println(binarySearch(sortedArr,98));
        System.out.println(binarySearchDesc(descSortedArr,45)); // ilk tapdigi tekrarlanan ededin indexini return edir
    }

    private static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;


        while (start <= end){
//            int middle = (start + end)/2; // start + end int-in max value-dan cox ola biler
            int middle = start + (end - start)/2;
            // Middle dinamik olaraq her iteration-da yenilenmelidir
            // Each iteration -> refresh the middle AND left OR right index

            if(target == arr[middle]) return middle;
            else if (target > arr[middle]) start = middle + 1;
            else end = middle - 1;

            /*** Middle indexdeki element yoxlanib start ve ya end index onunla eyni olmamalidir:
             1. Bosuna uzada biler, cox iteration olar
             2. Son indexdedirse target islemeyecek -> cunki start=7, end=8, target=8-deki elemet olsa
             her (7 + 8) / 2 = 7 verir start deyismir --> infinte loop
             To solve this --> start = middle + 1 , (8 + 8) / 2 = 8 target is found!
             **/

//            if(target == arr[middle]) return middle;
//            else if (target > arr[middle]) start = middle;
//            else end = middle;
        }
        return -1;// If not found
    }

    private static int binarySearchDesc(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end){
            int middle = start + (end - start)/2;

            if(target > arr[middle]) end = middle - 1;
            else if (target < arr[middle]) start = middle + 1;
            else return middle;
        }
        return -1;// If not found
    }
}
