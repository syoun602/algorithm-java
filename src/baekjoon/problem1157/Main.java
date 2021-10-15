package baekjoon.problem1157;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char arr[] = s.toUpperCase().toCharArray();

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for(int i = 0; i < 26; i++)
            map.put((char) ('A' + i), 0);

        for(int i = 0; i < arr.length; i++)
            map.put(arr[i], map.get(arr[i]) + 1);

        List<Map.Entry<Character, Integer>> listEntries = new ArrayList<Map.Entry<Character, Integer>>(map.entrySet());
        Collections.sort(listEntries, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        if(listEntries.size() > 1) {
            if (listEntries.get(0).getValue().equals(listEntries.get(1).getValue())) {
                System.out.println("?");
            } else
                System.out.println(listEntries.get(0).getKey());
        }
        else
            System.out.println(listEntries);
    }
}
