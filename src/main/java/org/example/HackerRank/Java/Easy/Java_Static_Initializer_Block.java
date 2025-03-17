package org.example.HackerRank.Java.Easy;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Java_Static_Initializer_Block {
    static int B,H; // default 0
    static boolean flag;// default false

    // Static block to initialize and validate input
    // *** Many real-world Java applications (e.g., database connections, configuration loading) require initializing static resources before execution. **
    static {
        Scanner sc = new Scanner(System.in);
        B = sc.nextInt();
        H = sc.nextInt();

        if (B > 0 && H > 0) {
            flag = true;
        } else {
            flag = false;
            try {
                throw new Exception("Breadth and height must be positive");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }

    public static void main(String[] args) {
        if (flag) {
            System.out.println(B * H); // Calculate and print the area
        }
    }
}
