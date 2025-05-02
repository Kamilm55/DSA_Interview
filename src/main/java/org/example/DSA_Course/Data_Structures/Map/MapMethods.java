package org.example.DSA_Course.Data_Structures.Map;

import java.util.HashMap;
import java.util.Map;

public class MapMethods {
    public static void main(String[] args) {
        Map<String,Integer> examMap = new HashMap<>();

        // 1. V put(K key, V value); -->  Returns previous value or null. (after adding0
        examMap.put("Physics",80);
        examMap.put("Programming",Integer.parseInt("99"));
        examMap.put("Programming",Integer.valueOf("89"));// Bu key-i hash ile tapir ve yeni value-nu put edir

        System.out.println(examMap); // {Programming=89, Physics=80}

        // 2. void putAll(Map<? extends K, ? extends V> m);
        examMap.putAll(
             Map.ofEntries(
                Map.entry("PM",55),
                Map.entry("Math",60)
        ));

        System.out.println(examMap);// {Programming=89, Math=60, PM=55, Physics=80}

        // 3.  void clear()
        examMap.clear();
        System.out.println(examMap); // {}


        // 4. boolean containsKey(Object key) -> Returns whether key is in map.
        System.out.println(examMap.containsKey("Math")); // false
        System.out.println(examMap.containsKey(45));// type-i sehv verdim warning verdi amma exception yoxdu, result false hemise
        System.out.println(examMap.containsKey(null));// no exception
        // Throws:
        // ClassCastException – if the key is of an inappropriate type for this map (optional)
        // NullPointerException – if the specified key is null and this map does not permit null keys (optional)
        // Notes.md - Niye exception vermedi docs-da yazilan kimi (Bu map-in interface metodu-dur hashmapdeki impl-da bu yoxdu)


        // 5.boolean isEmpty()
    }
}
