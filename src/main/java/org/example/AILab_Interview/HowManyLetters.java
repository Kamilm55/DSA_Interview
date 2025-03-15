package org.example.AILab_Interview;

import java.util.*;

// 3. Return type must be Map<Srtring,Integer> -> in a String input each letter how many times repeated?
// Nurlan --> {n=2,u=1,r=1,l=1,a=1}
public class HowManyLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        scanner.close();

        System.out.println(
                countLettersOptimal(input)
        );
    }

    // Code that I write
    private static Map<String, Integer> countLetters(String input) {
        String str = input.toLowerCase();

        List<Character> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }

        Map<String, Integer> map = new LinkedHashMap<>();// Hash table and linked list implementation of the Map interface, with predictable iteration order
        for (char c : list) {
            String strChar = String.valueOf(c);
            if (map.containsKey(strChar)) {
                int currentCharCount = map.get(strChar);
                map.put(strChar,++currentCharCount);
            }else {
                map.put(strChar,1);
            }
        }

        return map;
    }

    // Other method that I write
    private static Map<String, Integer> countLetters2(String input) {
        String str = input.toLowerCase();


        Map<String, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);// in outer loop

            if(map.containsKey(String.valueOf(currentChar))) continue;
            // bu olmasa eyni herfi ikinci defe de sayir ve neticede hamisi 1 olur

            int currentCountOfChar = 1;
            for (int j = i + 1; j < str.length() ; j++) {
                char currentChar2 = str.charAt(j); // in inner loop

                if (currentChar2 == currentChar) ++currentCountOfChar;

            }
            map.put(String.valueOf(currentChar),currentCountOfChar);// in outer loop
        }

        return map;
    }

    // Code that chat-gpt write
    private static Map<Character, Integer> countLettersOptimal(String input) {
        Map<Character, Integer> letterCount = new LinkedHashMap<>(); // Preserves order

        for (char c : input.toLowerCase().toCharArray()) {
            letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
        }

        return letterCount;
    }

    // Big-O Notation Analysis for Each Method
    //
    //1. countLetters(String input) (Your First Method)
    //Complexity Analysis:
    //  Converting to lowercase → O(n)
    //  Creating list and populating it with characters → O(n)
    //  Iterating over list to populate map → O(n)
    //Total Complexity:
    //  O(n) + O(n) + O(n) = O(n) ✅ (Linear Time Complexity)
    //
    //Optimization Issue:
    //  Unnecessary use of an ArrayList (extra space usage).
    //  String conversion (String.valueOf(c)) in every iteration is inefficient.
    //
    //2. countLetters2(String input) (Your Second Method)
    //Complexity Analysis:
    //  Converting to lowercase → O(n)
    //  Outer loop iterating over each character → O(n)
    //  Inner loop checking for duplicate characters → O(n)
    //Total Complexity:
    //  O(n) + O(n²) = O(n²) ❌ (Quadratic Time Complexity)
    //
    //Optimization Issue:
    //  Nested loop (O(n²)) makes this method inefficient for large inputs.
    //  Instead of counting in a second loop, we should use a single-pass hashmap.
    //
    //3. countLettersOptimal(String input) (ChatGPT's Optimized Method)
    //Complexity Analysis:
    //  Converting to lowercase → O(n)
    //  Single pass through the string (toCharArray() and iteration) → O(n)
    //  HashMap operations (getOrDefault() runs in O(1)) → O(n)
    //Total Complexity:
    //  O(n) + O(n) = O(n) ✅ (Linear Time Complexity)
    //
    //Why is this optimal?
    //  Uses a single loop (O(n))
    //  No extra lists
    //  getOrDefault() runs in constant time (O(1))
    //  --->
    // default V getOrDefault(Object key, V defaultValue) {
    //        V v;
    //        return (((v = get(key)) != null) || containsKey(key))
    //            ? v
    //            : defaultValue;
    //    }

    // public interface Map<K, V> --> type parameter V/K extends Object

    // get(key) -->
    // Returns:
    //  the value to which the specified key is mapped, or null if this map contains no mapping for the key
}
