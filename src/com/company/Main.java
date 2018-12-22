package com.company;

import java.io.*;
import java.util.*;

public class Main
{
    private static List<Character> letter = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
    public static void main(String[] args) throws Exception
    {
        ArrayList<Character> book = read("D:\\book.txt");
        ArrayList<Character> chapter = read("D:\\chapter.txt");
        ArrayList<Character> codechapter = coder(chapter);
        Map<Integer, Character> book_frq = FreqTable.frequency(book);
        Map<Integer, Character> chapter_frq = FreqTable.frequency(codechapter);


        for(int i=0;i<codechapter.size();i++)
        {
            for (int j = 0; j < 26; j++)
            {
                if (codechapter.get(i)==book_frq.get(j))
                {
                    codechapter.set(i, chapter_frq.get(j));
                    break;
                }
            }
        }

        File f2 = new File("D:\\ChapterDecode.txt");
        BufferedWriter wrbuf = new BufferedWriter(new FileWriter(f2));

        for(int i = 0; i< codechapter.size();i++)
        {
            wrbuf.write(codechapter.get(i));
        }
        wrbuf.close();

        ArrayList<Character> decode = read("D:\\ChapterDecode.txt");
        Map<Integer, String> book_big = Bigramm.frequency_big(book);
        Map<Integer, String> chapter_big = Bigramm.frequency_big(decode);

        for(int i = 0; i<decode.size() - 1; i++)
        {
            String s = String.valueOf(decode.get(i).toString() + decode.get(i+1).toString());
            for(int j = 0; j < 10; j++)
            {
                if(s.equals(book_big.get(j)))
                {
                    char[] mas = chapter_big.get(j).toCharArray();
                    decode.set(i, mas[0]);
                    decode.set(i+1, mas[1]);
                    break;
                }
            }
        }

        File f3 = new File("D:\\ChapterDecode1.txt");
        BufferedWriter wrbuf1 = new BufferedWriter(new FileWriter(f3));

        for(int i = 0; i< decode.size();i++)
        {
            wrbuf1.write(decode.get(i));
        }
        wrbuf1.close();
    }

    public static ArrayList<Character> read(String filename) throws FileNotFoundException, IOException
    {
        ArrayList<Character> file = new ArrayList<>();
        File f = new File(filename);
        BufferedReader scanner = new BufferedReader(new FileReader(f));
        int c;
        while((c = scanner.read()) != -1)
        {
            file.add(Character.toLowerCase((char) c));
        }
        scanner.close();
        return file;
    }


    public static ArrayList<Character> coder(ArrayList<Character> file) throws Exception
    {
        ArrayList<Character> newFile = (ArrayList<Character>) file.clone();
        for (int i = 0; i < file.size(); i++)
        {
            for (int j = 0; j < 26; j++)
            {
                if (file.get(i) == letter.get(j))
                {
                    newFile.set(i, letter.get(25 - j));
                }
            }
        }

        File f1 = new File("D:\\ChapterEncode.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(f1));

        for(int i = 0; i< newFile.size();i++)
        {
            file.set(i, newFile.get(i));
            writer.write(newFile.get(i));
        }
        writer.close();
        return file;
    }
}
