package org.example.DSA_Course.Algorithms.Sort;
// https://www.youtube.com/watch?v=F5MZyqRp_IM&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYq

import java.util.Arrays;

public class Bubble_Sort_Theory {
    public static void main(String[] args) {
        int[] unsortedArr = new int[]{ 897,53,6,-8,0,9,49,48,787};
        int[] sortedArr = new int[]{1,2,3,5,4};

        System.out.println(Arrays.toString(bubbleSort(sortedArr)));
//        System.out.println(Arrays.toString(bubbleSort(unsortedArr)));
//        Arrays.stream(bubbleSort(arr)).forEach(System.out::println);

        /*** Big O
         * 1. Time Complexity --> Quadratic O(N^2)
         Best Case -> O(N) --> Sorted (Actually N - 1 comparisons)
         Worst Case -> O(N^2) --> Sorted in opposite direction (e.g desc)
         N = number of comparisons (Ignore constants e.g: n - 12 --> n, n - 100 --> n)

         * 2. Space Complexity --> Constant O(1)
         ***/
    }

    private static int[] bubbleSort(int[] arr) {
        int len = arr.length;

        // En boyuk elementleri saga dogru duzur, ilk iterationdan sonra en boyuk 1 element sagda olacaq
        // 2-cide ise sagda 2 element sorted veziyetde olacaq ve s.
        // her iterationda ITERATION COUNT qeder sagda sorted elementler olacaq ve inner loop-un bunlari
        // compare etmesine ehtiyac yoxdur
        // ilk loopdaki i bizim ITERATION COUNT-umuzu temsil edir current i = 0 , len = 9 -->
        // inner loop j < 9 - 0 qeder yoxlayacaq
        // eger i = 4 --> sagda 4 element sorted, inner loop must be compare 5 elements at the left -->
        // j < 5 --> j < (9-4=5)

        // To compare we use inner loop j and j - 1 elements
        for (int i = 0; i < len; i++) { // i 0-dan baslayir iteration sayir, length qeder davam edecek, compare etmek ucun istifade olunmur
            boolean isAlreadySorted = true;// Eger inner loop-da swap olmursa, demeli artiq sorted olub ve outer loop -> break

            for (int j = 1; j < len - i; j++) {// j 1-den baslayir ve bir element soldaki ile muqayise edir, Sagdaki sorted olunmus arr-e catana qeder
                if(arr[j] < arr[j - 1]){ // o biri 2 case >= sorted demekdir zaten
                    // To swap 2 elements we cannot do directly
                    int temp = arr[j]; // arr[j] current value temp-de saxlanilir, rahatliqla arr[j]-e yeni value vere bilerik
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;

                    isAlreadySorted = false; // Swap eledim, yeni sorted deyil
                }
            }

            if (isAlreadySorted) break; // inner loop-da swap olmayib, yeni arr artiq sorted-dir
        }

        return arr;
    }
}
