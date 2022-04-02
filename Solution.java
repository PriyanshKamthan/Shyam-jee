import java.util.*;
import java.lang.*;
import java.io.*;

/*
 * 
 */
public class Solution
{
    public static String CountFrequency (String word)
{
    String answer = "";
    
    // Write your code here
    
    String[] words = word.split(" ");
    
    HashMap<String, Integer> hs = new HashMap<String, Integer>();
    
    for(int i=0; i<words.length; i++) {
    
    String w = words [i].toLowerCase(); if(hs. containsKey (w)) hs.put(w, hs.get(w) + 1);
    
    else hs.put(w, 1);
    
    }
    
    Set<Map.Entry<String, Integer>> set = hs.entrySet();
    
    int count = 0;
    
    for (Map.Entry<String, Integer> curr: set) { if (curr.getValue() > count) {
    
    count = curr.getValue();
    
    answer = curr.getKey();
    
    }
    
    else if(curr.getValue() == count && (curr.getKey()).length() > answer.length()) { answer = curr.getKey();
    
    }
    
    }
    
    if (count == 1) return words [0].toLowerCase() + Integer.toString (count);
    
    return answer + Integer.toString (count);
    
    }
    
    public static void main(String[] args)
    
    {
    
    Scanner in = new Scanner(System.in);
    
    String word = in.nextLine();
    
    String result = CountFrequency (word);
    
    System.out.print (result);
}
}