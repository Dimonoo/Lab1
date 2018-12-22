package com.company;

import java.util.*;

public class Bigramm
{
    private static List<Character> letter = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
    public static Map<Integer, String> frequency_big(ArrayList<Character> file)
    {
        ArrayList<String> bigramms = new ArrayList<>();
        for (int i = 0; i < 26; i++)
        {
            for (int j = 0; j < 26; j++)
            {
                String crbig = String.valueOf(letter.get(i).toString() + letter.get(j).toString());
                bigramms.add(crbig);
            }
        }

        Map<Integer, String> big_map = new HashMap();
        int[] value = new int[676];
        for(int i=0; i<676; i++)
        {
            value[i] = 0;
        }
        for(int i = 0; i<file.size()-1;i++)
        {
            String buff = String.valueOf(file.get(i).toString() + file.get(i+1).toString());
            for(int j = 0; j<676; j++)
            {
                if(buff.equals(bigramms.get(j)))
                {
                    value[j]++;
                    break;
                }
            }
        }
        for(int i=0; i<10;i++)
        {
            int temp = value[i];
            String c = bigramms.get(i);
            int st = 0;
            for(int j = 0; j<676; j++)
            {
                if(value[j]>temp)
                {
                    temp = value[j];
                    c = bigramms.get(j);
                    st = j;
                }
            }
            big_map.put(i, c);
            value[st] = 0;
        }
        return big_map;
    }
}