package org.example.HackerRank.Java.Easy;

import java.util.Scanner;

public class Java_Substring_Comparisons {
    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0,k);// *** 1st iteration of the loop **
        String largest = s.substring(0,k);


        // *** i=1 -> no need first iteration; i '<=' s.length() - k ---> for all possible substr  **
        for (int i = 1; i <= s.length() - k; i++) {
            String newSubStr = s.substring(i,i+k);

            if(newSubStr.compareTo(largest) > 0) largest = newSubStr;
            if(newSubStr.compareTo(smallest) < 0) smallest = newSubStr;
        }



        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}