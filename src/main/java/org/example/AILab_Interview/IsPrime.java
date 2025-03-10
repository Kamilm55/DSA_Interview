package org.example.AILab_Interview;

import java.util.Scanner;

// 3. Input is prime or not? 12 -> false, 117 -> true
public class IsPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close();

        System.out.println(
                isPrimeEfficient1(num)
        );
    }

    // Code that I write -> ⏳ Time Complexity: O(n)
    private static boolean isPrime(int num) {
        boolean flag = true;

        for (int i = 2; i < num; i++) {
            if(num % i == 0){
                return false;
            }
        }
        return flag;
    }
    // A little bit optimal but again linear complexity O(n/2) = O(n)
    private static boolean isPrime2(int num) {
        boolean flag = true;

        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return flag;
    }
    // More understandable code ⏳ Time Complexity: O(√n)
    // Prime Numbers ≤ 100
    // 2, 3, 5, 7 |<9|   11, 13, 17, 19, 23  |<25|
    // 29,31 |<36|   37, 41, 43, 47 |<49|   53, 59, 61   |<64|
    // 67, 71, 73, 79   |<81|    83, 89, 97   |<100|

    // input 49
    // i baslayir 3-den
    // i-nin kvadratindan kicikdirse ya cutdur ya tekdir:
    // cutdurse zaten prime ola bilmez --> cutleri cixdiq
    // tekdirse
    // i = 3 -> 9 dan kicik 3-e bolunmeyenler cutdur ya da primedir
    // i = 5 -> 25 den kicik 3 ve 5-e bolunmeyenler cutdur ya da primedir
    // i = 7 -> 49 den kicik 3, 5 ve 7-e bolunmeyenler cutdur ya da primedir
    // i = 9 -> 81 den kicik 3, 5, 7 ve 9-a bolunmeyenler cutdur ya da primedir
    // Cutleri de cixdigimiza gore yerde qalir --> prime

    // Example: Checking n = 49
    // √49 = 7, so we check divisibility for numbers ≤ 7:
    // i = 3 → 49 % 3 != 0
    // i = 5 → 49 % 5 != 0
    // i = 7 → 49 % 7 == 0 → Return false (Not prime)
    // We only did 3 checks instead of 48 (if we had checked all numbers from 2 to 48).

    // Neden √n'e Kadar Kontrol Ediyoruz?
    // Bir prime olmayan sayı n, her zaman iki çarpanın çarpımı olarak yazılabilir:
    // n=a×b -> 36=6×6
    // Eğer her iki çarpan da √n'den büyük olursa, bu durumda çarpımları n'den büyük olur, bu da bir çelişkidir.
    // Bu nedenle, en az bir çarpan mutlaka √n veya daha küçük olmalıdır.
    // Eğer √n veya daha küçük olan hiçbir sayı n’i tam bölmüyorsa, o zaman n asaldır.
    // Bu mantık nedeniyle asal sayı kontrolü yaparken n'i değil, sadece √n'e kadar olan sayıları kontrol etmemiz yeterlidir.
    // Bu da O(√n) zaman karmaşıklığını sağlar.
    private static boolean isPrimeEfficient1(int num) {
        if (num < 2) return false; // 0 and 1 are not prime numbers
        if (num == 2 || num == 3) return true; // 2 and 3 are prime numbers
        if (num % 2 == 0) return false; // Even numbers > 2 are not prime

        for (int i = 3; i * i <= num; i += 2) { // Start from 3, check only odd numbers
            if (num % i == 0) {
                return false;
            }
        }
        // 0,1,2,3 ve cut ededler yoxlanilib
        // 5 7 9 11 13 15 etc.
        // 5 -> 9 <= 5 false --> loopa girmir true
        // 7 -> 9 <= 7 false --> loopa girmir true
        // 9 -> 9 <= 9 true --> loopa girir ve 3-e bolunur false

        return true;// eger boluneni yoxdursa prime -> true
    }

    // Ideal code that Chat-Gpt write -> ⏳ Time Complexity: O(√n) → Much faster for large numbers!
    private static boolean isPrimeEfficient2(int num) {
        // Zaman qazanmaq ucun kicik sade ededleri manual return edirik.
        if (num <= 1) {
            return false; // 0 and 1 are not prime
        }
        if (num == 2 || num == 3) {
            return true; // 2 and 3 are the smallest primes
        }
        // 2-e ve ya 3-e bolunenleri manual return
        if (num % 2 == 0 || num % 3 == 0) {
            return false; // Exclude even numbers and multiples of 3
        }

        // i num-a bolunurse kvadrati da boluner
        // i-ni 6 vahid artira bilerik cunki, 2 ve 3 e bolunme sansi yoxdur
        // Check only up to √num
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }

    // Note: In Big-O notation, we ignore constants, so n/2 simplifies to O(n).
    // Why Do We Ignore Constants?
    // Big-O notation describes the growth rate, not the exact number of operations.
    // If we express it as:
    // O(n)
    // O(n/2)
    // O(2n)
    // O(3n + 5)
    // All of these are proportional to n. Since multiplying by a constant (1/2, 2, 3)
    // does not change the growth rate, we simplify it to O(n).

//    Example
//    Let’s compare:
//    1. O(n/2)
//    If n = 1,000,000, the loop runs 500,000 times.
//    2. O(n)
//    If n = 1,000,000, the loop runs 1,000,000 times.
//    Even though O(n/2) runs fewer times, it still grows proportionally(mütənasib olaraq) to n,
//    so we write it as O(n).

    // Why Do We Ignore Constants in Big-O Notation?
    //Big-O notation only focuses on the growth rate of an algorithm as n increases.
    //It does not measure exact performance, but rather how an algorithm scales.
}
