package org.example.DSA_Course.Algorithms.Sort.Practice;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.example.DSA_Course.Algorithms.Sort.SortUtil.swap;

public class Cyclic_Sort_Practice {
    public static void main(String[] args) {
        // Leetcode

        // Amazon question
        // Q1: 268. Missing Number -> https://leetcode.com/problems/missing-number/description/
        // Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
        int[] nums = new int[]{0,1};

        System.out.println(missingNumber(nums));
        System.out.println(missingNumber2(nums));

        // Google question
        // Q2: 448. Find All Numbers Disappeared in an Array -> https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
        // Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
        //    Constraints:
        //        n == nums.length
        //        1 <= n <= 105
        //        1 <= nums[i] <= n
        int[] nums2 = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums2));


    }

    // A2
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    //🔍 O(1) extra auxiliary space — because all work is done in-place in the input array.
    //But it uses O(k) space for the output List<Integer>, where k is the number of missing numbers.
    //So technically:
    //✅ Auxiliary space = O(1)
    //✅ Total space (including output) = O(k)
    // Auxiliary space - Yardımcı Alan / Ek Bellek Kullanımı
    //  Bu terim, bir algoritmanın input(ve output) verisi dışında kullandığı ek hafızayı ifade eder.
    // Note: abit uzunlukta (örneğin 3 elemanlı) bir array veya liste kullanırsan, bu hâlâ O(1) (sabit) space olarak kabul edilir.
    public static List<Integer>  findDisappearedNumbers(int[] nums) {

        int i = 0;

        // Array-de duplicate value olanda baxir ki, bu value dogru yerdedi (ilk versiyasi dogru index-de olduguna gore)
        // ignore edir, belelikle  --> [1, 2, 3, 4, 3, 2, 7, 8] --> duplicatlar missing value-larin indexinde yerlesir
        while (i < nums.length){
            int correctIndex = nums[i] - 1;

            if(nums[i] != nums[correctIndex])
                swap(nums,i,correctIndex);
            else
                i++;

        }

        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < nums.length ; j++) {
            int correct = j + 1;
            if(nums[j] != correct) list.add(correct);
        }

        return list;
    }

    // A1 --> Two separate loops one after another still means O(N), not O(2N) or anything worse.
    // O(N) + O(N) = O(2N) → simplified to → O(N)
    // ❗ But If Nested:
    //This would be O(N²)

    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public static int missingNumber(int[] nums) {

        int N = nums.length; // 3-durse [0,1,2,3] olmasi gerekir

        int i = 0;
            while (i < nums.length){ // i < nums.length - 1 islemeyecek
                int correctIndex = nums[i]; // [0,n] --> 0 --> 0 , 1 --> 1

                if(nums[i] != N){ // n indexindeki element-i swap etsek index out of bound olacaq
                    if(nums[i] != nums[correctIndex])
                        swap(nums,i,correctIndex);
                    else
                        i++;
                }else i++;
            }


        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != j) return j;
        }

        return N; // Eger yuxarida tapilmayibsa demek ki en sondadir
    }
    public static int missingNumber2(int[] nums) {
        int i = 0;

        while (i < nums.length) {
            int correctIndex = nums[i];
            if (correctIndex < nums.length && nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

        // Find the missing number
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j) return j;
        }

        return nums.length; // If all indices matched, the missing number is n
    }

    // Very fast execution time
    // (Runtime: 0 ms, Beats 100.00% of users) but:
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int missingNumber3(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n + 1]; // Extra auxilary space
        for(int num : nums){
            freq[num]++;
        }
        for(int i = 0; i <= n; i++){
            if(freq[i] == 0){
                return i;
            }
        }
        return 0;
    }

}
