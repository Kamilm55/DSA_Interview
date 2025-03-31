package org.example.DSA_Course;
// https://www.youtube.com/watch?v=mV3wrLBbuuE&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=24
public class Time_and_Space_Complexity_COMPLETE_Tutorial {
    public static void main(String[] args) {
        // *** Time complexity != Time taken **
        // *** Time complexity == How time grows as the data gets larger (small numbers ignored) **
        // *** Constants ignored (because effects are small) **
        // *** Always ignore less dominating terms, such as O(n^3 + n^2 + n) -> n^2 + n ignored -> O(n^3) **

        // O(3n^3 + 4n^2 + 5n + 6) -> ignore constants ->  O(n^3 + n^2 + n) ->
        // ignore less dominating terms ->  O(n^3)


        // *** Big O Notation **
        // O(n) - linear
        // O(log(n)) - logharitmic
        // O(1) - constant
        // O(2^n) - exponential
        // O(n^2) - quadratic
        // O(n^t) - polynomial (t > 2)
        // O(nlog(n)) - log-linear
        // O(n!) - factorial

    }
}
