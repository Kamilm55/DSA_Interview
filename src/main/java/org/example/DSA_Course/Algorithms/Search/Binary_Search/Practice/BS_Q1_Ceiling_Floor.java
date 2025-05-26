package org.example.DSA_Course.Algorithms.Search.Binary_Search.Practice;
// https://www.youtube.com/watch?v=W9QJ8HaRvJQ&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ
public class BS_Q1_Ceiling_Floor {
    public static void main(String[] args) {
    // Q1: Ceiling of a number, Ceiling - the smallest element in arr greate or equals to target
    // {2,3,5,9,14,16,18} , target = 14 -> answer = 14; target = 7 -> answer = 9 ; target = 20 -> answer = INTEGER.MAX
    int[] sortedArr = new int[]{2,3,5,9,14,16,18}; // ASC
    int target = 3;

    System.out.println(findCeiling(sortedArr, target));
    System.out.println(findCeilingGPT(sortedArr,target));
    }

    // My Code
    private static int findCeiling(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        if(target < arr[0]) return arr[0]; // If target is smaller than first element -> return first
        if(target > arr[end]) return Integer.MAX_VALUE; // If not found -> target > lastElement

        while (start <= end){
            int mid = start + (end - start) / 2;

            if(target > arr[mid]){
                if(target < arr[mid + 1]) return arr[mid + 1]; // Eger mid ve mid+1 arasindadirsa boyuk olani return et

                start = mid + 1;// Normal binary search flow
            }
            else if (target  < arr[mid]){
                if(target > arr[mid - 1]) return arr[mid]; // Eger mid ve mid-1 arasindadirsa boyuk olani return et

                end = mid - 1; // Normal binary search flow
            }
            else return arr[mid]; // if(target == arr[mid)
        }

        return Integer.MAX_VALUE;
    }

    /***
     However:
     Your if (target < arr[mid + 1]) return arr[mid + 1]; introduces an extra comparison inside the loop.
     It doesn’t change the overall time complexity but makes each iteration slightly heavier in cost.

     Constant-lar Big O-ya tesir etmir, amma execution time ferq edir.
     **/

    // Optimized code
    private static int findCeilingGPT(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        // If the target is greater than the largest element
        if (target > arr[end]) return Integer.MAX_VALUE;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return arr[mid]; // Exact match
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // At the end of loop, start points to the smallest number >= target
        // Loop bitdi ve exact match tapilmadi,
        // meselen target = 15 -> arr[end],arr[start] = 14, start == end (son iteration)
        // target > arr[mid] --> start = mid + 1 , while loop bitir (start > end)=false, arr[start]=16
        return arr[start];
//        return 777777777; // for debugging

        /*** AZ
         *  Start end-i kecdikde loop bitir, start == end son iterationdur,
         *  eger exact match tapilmiyibsa, ya end -=1 olacaq ya da start +=1,
         *  her iki halda da start > end olur ve loop qirilir,
         *  loop qirilanda start targetden bir sonraki elementde , end ise bir evvelki elementde qalir,
         *  şərt eger biggest number <= target olsa idi arr[end] return ederdik.
         **/

        /** EN
         *  When start crosses end, the loop terminates.
         *  The last iteration occurs when start == end.
         *  If an exact match is not found, either start becomes mid + 1 or end becomes mid - 1.
         *  In both cases, we eventually reach start > end and exit the loop.
         *
         *  At that point:
         *  - `start` is pointing to the **smallest element greater than or equal to the target** (the ceiling).
         *  - `end` is pointing to the **largest element less than the target** (the floor).
         *
         *  If we were looking for the **floor** (i.e., largest element ≤ target), we would return `arr[end]`.
         *  But for the **ceiling** (i.e., smallest element ≥ target), we return `arr[start]`.
         */
    }

}
