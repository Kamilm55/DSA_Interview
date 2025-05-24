package org.example.DSA_Course.Algorithms.Search.Linear_Search;

public class Linear_Search_Tasks {
    public static void main(String[] args) {
        int[] arr = new int[]{ 897,53,6,-8,0,9,49,48,787};
        int[][] arr2d = new int[][]{
                {897, 53, 6, -8},
                {9, 49, 48, 787}
        };
        int[][] accounts =  new int[][]{{2,8,7},{7,1,3},{1,9,5}};


        // 1. Min number
        System.out.println(findMin(arr));// -8

        // 2. Search in 2d arr
        System.out.println(searchIn2d(arr2d,48)); // row:1 col:2
        System.out.println(searchIn2d(arr2d,7894)); // NOT FOUND!

        // 3. Even Digits --> Leetcode - 1295.Find Numbers with Even Number of Digits -> https://leetcode.com/problems/find-numbers-with-even-number-of-digits/description/
        // Given an array nums of integers, return how many of them contain an even number of digits.
        System.out.println(findEvenDigit(arr));
        // Linear olaraq butun elementlere baxmaliyiq ona gore O(N) deyismeyecek( Total Time Complexity), amma arr elementlerinin
        // digit sayini tapilmasini optimize ede bilerik, her elementde digit sayi qeder loop isletmeyerek
        // *** Arr daxilindeki her bir element ucun Big O:**
        // First version: Time Complexity: O(N) Linear
        // Optimized version: Time Complexity: O(1) Constant
        // Math.log10(num) is a constant-time operation (uses hardware-level operations).
        // (int)Math.log10(num) + 1 is O(1).

        // 4. Leetcode 1672. Richest Customer Wealth -> https://leetcode.com/problems/richest-customer-wealth/description/
        System.out.println(maximumWealth(accounts));
        // Not Optimized Code
        //Time Complexity -> O(m × n) Linear
        //Space Complexity -> O(m) --> *** row-nun sayi qeder elemnti olan arr yaratdim elave olaraq, Qalan variablelar constantdir,tesir etmirler (Dinamik olanlara baxiriq,meselen arr elementleri artib azalsa space deyisiklik gosterir amma constantlar yene oldugu kimi qalirlar)**

        // Optimized and readable Code
        System.out.println(maximumWealthOptimized(accounts));
        //Space Complexity -> O(1) Constant -->  since no extra array is used.
    }

    // 4 OPTIMIZED
    private static int maximumWealthOptimized(int[][] accounts) {
        int max = 0; // Negative ola bilmez,en az 0 OR Integer.MIN_VALUE
        for (int[] customer : accounts) {
            int sum = 0;
            for (int bank : customer) {
                sum += bank;
            }
            if(sum > max) max = sum;
        }
        return max;
    }

    // 4
    private static int maximumWealth(int[][] accounts) {

        int[] sumsArr = new int[accounts.length];

        for (int row = 0; row < accounts.length; row++) {
            int sumForEachCustomer = 0;
            for (int col = 0; col < accounts[row].length; col++) {
                sumForEachCustomer += accounts[row][col];
            }
            sumsArr[row] = sumForEachCustomer;
        }

        return findMaxFromArr(sumsArr);
    }

    private static int findMaxFromArr(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if(num > max) max = num;
        }

        return max;
    }


    // 3
    private static int findEvenDigit(int[] arr) {
        int counter = 0;

        for (int num : arr) {
           if(num < 0) num = -num; // num negativedirse positive et
           if(isDigitEvenOptimizedWay(num)) counter++;
        }

        return counter;
    }
    // 🔢 Understanding the Math
    //🧮 Mathematical Property:
    //For any positive integer num, the number of digits d is:
    //log10(num) gives the power of 10 needed to reach num.
    //Taking the floor of this log gives the number of digits minus one.
    //Adding 1 gives the correct number of digits.
    //
    //📘 Example:
    //Let’s try num = 12345.
    //log10(12345) ≈ 4.091
    //(int)log10(12345) = 4
    //Add 1 → 4 + 1 = 5 digits ✅
    private static boolean isDigitEvenOptimizedWay(int num) {
        int counterOfDigits = 0;
        if
            (num == 0) counterOfDigits = 1;//0-i handle etmeliyik yoxsa -2147483647 verir
        else
            counterOfDigits =  (int)Math.log10(num) + 1; // Digit sayi -> daha optimized sekilde

        return counterOfDigits % 2 == 0;
    }
    private static boolean isDigitEven(int num) {
        int counterOfDigits = 0;

        // Digitleri say
        while (num > 0){ // Yerde iki case qalir  0 < ve ya 0, 0 < menfi 1-e vurulur, num eger 0-dirsa zaten even digit deyil, amma odd olsa idi 0 ucun ayri if case yazmali idik
            // 123 ededini ferz edek
            counterOfDigits++; // 123 -> 1; 12 -> 2; 1 -> 3 END

            num /= 10; // 123 / 10 -> 12 T;  12 / 10 -> 1 T; 1 / 10 -> 0, 0 > 0 F
        }

        return counterOfDigits % 2 == 0;
    }

    // 2
    private static String searchIn2d(int[][] arr2d, int target) {
        for (int row = 0; row < arr2d.length; row++)
            for (int col = 0; col < arr2d[row].length; col++) {
                if(arr2d[row][col] == target) return "row:" + row + " col:" + col;
            }

        return "NOT FOUND!";
    }

    // 1
    private static int findMin(int[] arr) {
        int min = arr[0]; // Minimumu 0 qoyma, negative ola biler -> ona gore arr-den bir value secib hamisi ile muqayise etmeliyik
        for (int num : arr) {
            if(num < min) min = num;
        }

        return min;
    }
}
