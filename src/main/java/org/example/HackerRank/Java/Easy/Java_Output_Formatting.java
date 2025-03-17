package org.example.HackerRank.Java.Easy;

import java.util.Scanner;

public class Java_Output_Formatting {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("================================");
    for(int i=0;i<3;i++)
    {
        String s1=sc.next();
        int x=sc.nextInt();


        System.out.printf(s1 + getSpaces(15 - s1.length()) + String.format("%03d", x) + "\n");
        // *** %03d → Formats an integer (d) with at least 3 digits, filling with 0 if needed. **
    }

    System.out.println("================================");

}
    public static String getSpaces(int count) { // *** dynamic formmating **
        return String.format("%" + count + "s", "");}
}