package org.example.HackerRank.Java.Easy;

import java.util.Scanner;

public class Java_Loops_II {
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            int sum = a;
            for (int j = 1; j < Math.pow(2, n); j*=2) {
                sum += j * b;
                System.out.print(sum + " ");
            }
            System.out.println();

        }
        in.close();
    }
}
