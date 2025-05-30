package org.example.DSA_Course.Algorithms.Sort;

public class Sort_Comparison {
    public static void main(String[] args) {
        // | Sort Algorithm     | Advantages                                                                    | Disadvantages                                                                  |
        //| ------------------ | ----------------------------------------------------------------------------- | ------------------------------------------------------------------------------ |
        //| **Bubble Sort**    | - Very simple to implement                                                    | - Very inefficient (O(n²))                                                     |
        //|                    | - Can detect already sorted arrays (with optimization)                        | - Too many swaps                                                               |
        //|                    | - Stable sort                                                                 | - Not used in practice                                                         |
        //|                    |                                                                               | - Poor performance even on partially sorted data                               |
        //| -----------------  | ----------------------------------------------------------------------------- | ------------------------------------------------------------------------------ |
        //| **Selection Sort** | - Simple to implement                                                         | - Always O(n²), even if the array is sorted                                    |
        //|                    | - Fewest number of swaps (O(n))                                               | - Not stable (unless modified)                                                 |
        //|                    | - Good when memory write is expensive (e.g., flash memory)                    | - Doesn't adapt to sorted/partially sorted data                                |
        //| -----------------  | ----------------------------------------------------------------------------- | ------------------------------------------------------------------------------ |
        //| **Insertion Sort** | - Efficient for small or nearly sorted arrays                                 | - Worst-case time is O(n²)                                                     |
        //|                    | - Stable sort                                                                 | - Not suitable for large datasets                                              |
        //|                    | - Less number of swaps (more shifts),                                         |
        //|                    | - It performs a single insertion (final swap) after finding the position.     |                                                                                |
        //|                    | - Used in hybrid sorting (e.g., Timsort, introsort)                           |                                                                                |


        // ✅ 1. What does "Good when memory write is expensive" mean?
        //Some hardware (like flash memory, EEPROM, or SSDs) has limited write cycles or slow write speeds. That means:
        //Each time you write (save/update) something, it wears the memory out a little bit.
        //Reading from memory is cheap, but writing should be minimized.
        //
        //💡 Why Selection Sort is good in this case:
        //Selection sort always does exactly n-1 swaps, regardless of the input data. It finds the minimum element and swaps only once per outer loop. (Indexe gore duzur)
        //🟢 Fewer writes = good for memory with limited endurance
        //❌ In contrast, Bubble sort or Insertion sort may do many swaps or shifts, depending on how unsorted the data is.


        // ✅ 2. What does "Stable sort" mean?
        //A stable sorting algorithm maintains the relative order of equal elements.
        //
        //📌 For example:
        //Suppose you're sorting people by age:
        //[ Alice(25), Bob(30), Charlie(25) ]
        //If you use a stable sort, sorting by age gives:
        //[ Alice(25), Charlie(25), Bob(30) ]
        //
        //Note that Alice comes before Charlie because she was first in the original list, and their age is equal.
        //But if the sort is not stable, the order of Alice and Charlie might be switched, which could break logic in some applications.

        // 3. Why Selection is not stable?
        // Buble ve Insertion 2 elementi muqayise edir eger beraberdirse swap etmir --> Stable -> Order is reserved
        // Selection max elementi taparken ilk tapdigi max elementi arr-in axirina atir, meselen
        // [ Alice(25), Charlie(25), Bob(30) ] -> ilk 30-u sort etdi, sonra alice 25-i sondan 1-ci index-e shift edecek
        // -->  Not stable (unless modified)

        // ✅ 4. Sort algoritms in Java called behind the scenes
        //Arrays.sort() and Collections.sort() — What’s under the hood?
        //🔹 For primitive types (e.g., int[], double[]):
        //Uses Dual-Pivot QuickSort
        //✅ Very fast and efficient
        //❌ Not stable
        //
        //🔹 For objects (e.g., Integer[], String[] or custom objects):
        //Uses TimSort (a hybrid of Merge Sort + Insertion Sort)
        //✅ Stable
        //✅ Good for partially sorted arrays
        //
        //🔹 TimSort is stable and optimized for real-world data with partially sorted structure.
        // Uses TimSort
        //String[] arr = {"banana", "apple", "banana"};
        //Arrays.sort(arr); // Keeps relative order of duplicate "banana"
    }
}
