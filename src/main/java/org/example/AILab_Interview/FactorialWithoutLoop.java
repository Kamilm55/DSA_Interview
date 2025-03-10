package org.example.AILab_Interview;

import java.util.Scanner;

// 2. Factorial without loop → 5 -> 120 ; 3 -> 6
public class FactorialWithoutLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close();

        if (num < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        }
        else {
            System.out.println(
                    factorial(num)
            );
        }
    }
    // Ideal code that Chat-Gpt write (debug and understand)
    private static int factorial(int num) {

        if (num == 0) {
            return 1; // Base case: 0! = 1
        }
         int hasil = num * factorial(num - 1); // Recursive case

        return  hasil;
        // factorial(num - 1) --> child method

        // Base case: 0! = 1 -> 2 cases:
        // Case 1: num > 0
        // num * metodun return etdiyi value -> en axirda metod 1 return edir,
        // evvelki hasilleri de 1-e vururuq
        // Case 2: num = 0 (ilkin input -> esas metoda -> childda yox)
        // If num is 0 return 1 and method ends -> "esas metod" bitir

        // Note: Eger ilkin input num = 0 deyilse, hemise hasil * metodun return etdiyi value cagirilir,
        // ne vaxt ki num == 0 oldu yene "child method" (esas metod yox axirinci merheledeki recursive funksiya) bitir,
        // ve biten func 1 return edir "esas metodumuz" ise bitmeyib, esas metodun return etdiyi value hasili vururuq son alinan 1-e,
        // child func bitdiyi ucun esas metod return edib sonlana biler
    }


    // Ideal code that I write
    private static int factorialWithRecursion(int num) {
        if (num == 0){
            return 1;// 0! = 1; -> exception - istisna
        }

        if(num == 1){ // 3;2;1 -> if num == 0 -> *(1-1) -> answer always be 0
            return num;// end of recursion
        }

        // continue recursion
        return num * factorialWithRecursion(num - 1);// 3*(3-1)*(2-1) ;
    }
}
