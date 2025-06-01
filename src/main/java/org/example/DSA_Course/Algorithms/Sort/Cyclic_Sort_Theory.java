package org.example.DSA_Course.Algorithms.Sort;

import java.util.Arrays;

import static org.example.DSA_Course.Algorithms.Sort.SortUtil.swap;

public class Cyclic_Sort_Theory {
    public static void main(String[] args) {
        int[] unsortedArr = new int[]{3,1,5,2,4};

        int[] unsortedArrDuplicates = new int[]{3,3,1,1,2,5,4};
        //*** When question asks 1 to N range, use this**
        // 1...N --> her bir ededin indexi n-1 olmalidir sorted olmasi ucun, 1-->0,2-->1,3--->2 etc.

        /*** Big O
         * 1. Time Complexity --> Linear O(N) in most cases, but can go up to O(N^2) in the worst case.
         *    Best Case  -> O(N)         // when all elements are already in their correct positions
         *    Average/Worst Case -> O(N) to O(N^2)  // due to multiple swaps when many elements are misplaced
         *    Explanation: Ideally, each element is swapped only once into its correct position,
         *    resulting in O(N) time. However, if the array is far from sorted, the number of comparisons
         *    and swaps may increase toward O(N^2) in rare cases.

         * 2. Space Complexity --> Constant O(1)
         *    Explanation: Cyclic Sort is an in-place algorithm. It uses no additional space.

         * 3. Swap Count --> At most (N - 1)
         *    Explanation: Each swap puts at least one element into its correct position.
         *    So the total number of swaps is at most N - 1.
         ***/

        // 🔍 Normally:
        //Cyclic Sort is O(N) because each element is placed directly where it belongs (at most once).
        //In a well-behaved array (e.g. all values from 1 to N with no duplicates), each index gets its value in one swap.
        //
        //⚠️ But worst-case O(N²) happens only when:
        //The input array has duplicates (which violates Cyclic Sort's assumptions).
        //You modify Cyclic Sort to handle invalid inputs or do extra checks (e.g., for duplicate detection).
        //
        //So in practice:
        //✅ If array contains distinct integers in the range 0 to N-1 or 1 to N, Cyclic Sort is strictly O(N).
        //
        //➡️ Otherwise, it could degenerate if not written carefully.
        //In ideal conditions (no duplicates, values in valid range), it’s always O(N).

        System.out.println(Arrays.toString(cyclicSortWithoutCheckDuplicates(unsortedArr)));
        System.out.println(Arrays.toString(cyclicSortWithWhileLoop(new int[] {5, 1, 2, 3, 4})));

        System.out.println(Arrays.toString(cyclicSortWithWhileLoop(unsortedArrDuplicates))); // Not Working
    }

    private static int[] cyclicSortWithoutCheckDuplicates(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {

            int correctIndex = arr[i] - 1; // 3 - 1 = 2 true index for arr[i]
            while (arr[i] != arr[correctIndex]){ // 2 != arr[2] --> true-dursa swap et
                swap(arr,i,correctIndex);
                correctIndex = arr[i] - 1; // refresh ci,because i has changed
            }
        }
        return arr;
    }

    private static int[] cyclicSortWithWhileLoop(int[] arr) {
        int i = 0;

            while(i < arr.length - 1){
              int correctIndex = arr[i] - 1;
                if(arr[i] != arr[correctIndex]) // swap edende i-ni artirmiriq
                    swap(arr,i,correctIndex);
                else
                    i++;
            }

        return arr;
    }

}
