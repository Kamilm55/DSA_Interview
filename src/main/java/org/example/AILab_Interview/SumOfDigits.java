package org.example.AILab_Interview;

import java.util.Scanner;

// 1. Sum all digits of the integer: 321 -> 6
public class SumOfDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close(); // Close Scanner to prevent resource leak

        System.out.println(
                sum2(num)
        );
    }
    // Ideal code
    public static int sum(int num){ // num = 321
        int sum = 0;

        while (num != 0){ // 321!=0;32!=0;3!=0 -> true; 0 != 0 --> false (End of the loop)
            int remainder = num % 10;// 1;2; 3 % 10 -> 3
            sum += remainder;// 0+1=1;1+2=3; 3+3=6

            num /= 10;// 32;3; 3 / 10 -> 0
        }

        return sum;
    }

    // Code that I write
    public static int sum2(int num){// num = 321
        int sum = 0;

        while (num / 10 > 0){ // 32>0;3>0 -> true; 0 > 0 --> false (End of the loop)
            int remainder = num % 10;// 1;2
            sum += remainder;// 0+1=1;1+2=3

            num /= 10;// 32;3; 3 / 10 -> 0
        }
        // sum is 3 (only first digit of num not added to sum)
        // num is the first digit of the num -> 3
        return sum + num;// 3 + 3 --> 6
    }
}
