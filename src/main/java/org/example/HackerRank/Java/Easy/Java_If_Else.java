package org.example.HackerRank.Java.Easy;

import java.util.Scanner;

public class Java_If_Else {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");/*
        ***
        This line is used to consume any remaining newline characters that were left in the input buffer after nextInt().
        // The skip() method takes a regular expression (regex) as an argument and skips matching characters.
        // The regex pattern "(\r\n|[\n\r\u2028\u2029\u0085])?" means:
        // \r\n → Matches Windows-style newline (\r\n).
        // [\n\r\u2028\u2029\u0085] → Matches any newline character, including:
        // \n (Unix newline)
        // \r (Old Mac newline)
        // \u2028 (Line Separator)
        // \u2029 (Paragraph Separator)
        // \u0085 (Next Line character)
        // The ? at the end means optional, so it skips at most one occurrence of the newline.
        **
        */

        scanner.close();

        // Task
        //Given an integer, n, perform the following conditional actions:
        //
        //If  is odd, print Weird
        //If  is even and in the inclusive range of 2 to 5, print Not Weird
        //If  is even and in the inclusive range of 6 to 20, print Weird
        //If  is even and greater than 20, print Not Weird

        if(N % 2 == 1){ // Odd
            System.out.println("Weird");
        }else { // Odd deyilse avtomatik hamisi even olur, hamisinin ilk sertini tamamladiq
            if(N >= 2 && N <= 5){
                System.out.println("Not Weird");
            } else if (N >= 6 && N <= 20) {
                System.out.println("Weird");
            } else if (N > 20) {
                System.out.println("Not Weird");
            }
        }
    }
}
