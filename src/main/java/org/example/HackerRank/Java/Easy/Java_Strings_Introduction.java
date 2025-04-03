package org.example.HackerRank.Java.Easy;

import java.io.*;
import java.util.*;

public class Java_Strings_Introduction {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        /* Enter your code here. Print output to STDOUT. */


        System.out.println(A.length() + B.length());
        System.out.println(A.charAt(0) > B.charAt(0) ? "Yes" : "No");// If first char is equal re-check with while -> letters as index
       /*** Actually, we must use compareTo() method:
        Compares two strings lexicographically. The comparison is based on the Unicode value of each character in the strings.
        The character sequence represented by this String object is compared lexicographically to the character sequence represented by the argument string.

        The result is a negative integer if this String object lexicographically precedes the argument string.
        The result is a positive integer if this String object lexicographically follows the argument string.
        The result is zero if the strings are equal; compareTo returns 0 exactly when the equals(Object) method would return true.

        This is the definition of lexicographic ordering.
        If two strings are different, then either they have different characters at some index that is a valid index for both strings, or their lengths are different, or both.
        If they have different characters at one or more index positions, let k be the smallest such index; then the string whose character at position k has the smaller value,
        as determined by using the < operator, lexicographically precedes the other string.
        In this case, compareTo returns the difference of the two character values at position k in the two string -- that is, the value:
        this.charAt(k)-anotherString.charAt(k)

        If there is no index position at which they differ, then the shorter string lexicographically precedes the longer string. In this case, compareTo returns the difference of the lengths of the strings -- that is, the value:
        this.length()-anotherString.length()

        For finer-grained String comparison, refer to java.text.Collator.
        Params:
        anotherString – the String to be compared.
        Returns:
        the value 0 if the argument string is equal to this string;
        a value less than 0 if this string is lexicographically less than the string argument;
        and a value greater than 0 if this string is lexicographically greater than the string argument.
         **/
//       A.compareTo(B)

        System.out.println(A.substring(0,1).toUpperCase() + A.substring(1) + " " + B.substring(0,1).toUpperCase() + B.substring(1) );

        // substring()
        /***
        Returns a string that is a substring of this string. The substring begins at the specified beginIndex and extends to the character at index endIndex - 1. Thus the length of the substring is endIndex-beginIndex.
        Examples:
          "hamburger".substring(4, 8) returns "urge"
          "smiles".substring(1, 5) returns "mile"

        Params:
        beginIndex – the beginning index, inclusive. endIndex – the ending index, exclusive.
        Returns:
        the specified substring.
        Throws:
        IndexOutOfBoundsException – if the beginIndex is negative, or endIndex is larger than the length of this String object, or beginIndex is larger than endIndex.
         **/
    }
}




