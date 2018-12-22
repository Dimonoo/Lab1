package com.company;

import java.util.*;

public class FreqTable
{
    private static List<Character> letter = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
    public static Map<Integer, Character> frequency(ArrayList<Character> file)
    {
        Map<Integer, Character> map = new HashMap();
        ArrayList<Integer> val = new ArrayList<>();
        for(int i = 0; i<26;i++)
        {
            val.add(Collections.frequency(file, letter.get(i)));
        }

        for(int i = 0; i<26; i++)
        {
            int temp = val.get(i);
            char c = letter.get(i);
            for(int j = 0; j<26; j++)
            {
                    if(val.get(j) > temp)
                    {
                    temp = val.get(j);
                    c = letter.get(j);
                    }
            }

            map.put(i, c);
            val.set(letter.indexOf(c), -1);
        }
        return map;
    }
}