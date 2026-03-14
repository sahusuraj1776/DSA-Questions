// Repeated DNA Sequences - Leetcode - 187

// The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.

// For example, "ACGAATTCCG" is a DNA sequence.
// When studying DNA, it is useful to identify repeated sequences within the DNA.

// Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.

// Example 1:
// Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
// Output: ["AAAAACCCCC","CCCCCAAAAA"]

// Example 2:
// Input: s = "AAAAAAAAAAAAA"
// Output: ["AAAAAAAAAA"]
 

// Constraints:
// 1 <= s.length <= 105
// s[i] is either 'A', 'C', 'G', or 'T'.


package SlidingWindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequence {
    public static List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> res = new HashSet<>();
        for(int i=0;i<s.length()-9;i++){
            String str = s.substring(i,i+10);
            if(seen.contains(str)){
                res.add(str);
            }
            seen.add(str);
        }
        return new ArrayList<String>(res);


        // Rabin carp Algo
        // if(s.length()<10) return new ArrayList<String>();
        // Set<Integer> seen = new HashSet<>();
        // Set<String> res = new HashSet<>();
        // int K=10,rep=0;
        // Map<Character,Integer> map = new HashMap<>();
        // map.put('A',0);
        // map.put('C',1);
        // map.put('G',2);
        // map.put('T',3);

        // for(int i=0;i<K;i++){
        //     int pow = K-i-1;
        //     rep += (int)Math.pow(4,pow)*map.get(s.charAt(i));
        // }
        // seen.add(rep);
        // for(int i=K;i<s.length();i++){
        //     rep -= (int)Math.pow(4,K-1)* map.get(s.charAt(i-K));
        //     rep *= 4;
        //     rep += map.get(s.charAt(i));
        //     if(seen.contains(rep)){
        //         res.add(s.substring(i-K+1,i+1));
        //     }
        //     seen.add(rep);
        // }
        // return new ArrayList<String>(res);
    }
    public static void main(String[] args) {
        List<String> res = findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        res.forEach(s->System.out.println(s));
    }
}
