package org.example.HackerRank.Java.Easy;

import java.io.*;
import java.util.Calendar;
import java.util.Locale;

class Solution {

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */

    public static String findDay(int month, int day, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day); // Calendar months are 0-based (0 = January)

        return calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.ENGLISH).toUpperCase();
    }

}

public class Java_Date_and_Time {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // Fallback to a default file if OUTPUT_PATH is null
        String outputPath = System.getenv("OUTPUT_PATH");
        if (outputPath == null) {
            outputPath = "output.txt"; // Use a default file
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputPath));
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int month = Integer.parseInt(firstMultipleInput[0]);

        int day = Integer.parseInt(firstMultipleInput[1]);

        int year = Integer.parseInt(firstMultipleInput[2]);

        String res = Solution.findDay(month, day, year);

        bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

