// Letter Combinations of a Phone Number - LeetCode-17

// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

// A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

// Example 1:
// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

// Example 2:
// Input: digits = "2"
// Output: ["a","b","c"]

// Constraints:

// 1 <= digits.length <= 4
// digits[i] is a digit in the range ['2', '9'].

package BackTracking;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfPhoneNumber {
    public static void main(String[] args) {
        String digits = "23";
        List<String> res = solve(digits);
        for(String s:res){
            System.out.print(s+" ");
        }
    }

    private static List<String> solve(String digits) {
        List<String> res = new ArrayList<>();
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        if(digits.length()==0){
            return res;
        }
        StringBuilder s = new StringBuilder();
        backtrack(0,digits,s,map,res);
        return res;
    }

    private static void backtrack(int i, String digits, StringBuilder s, Map<Character,String> map, List<String> res) {
        if(digits.length()==s.length()){
            res.add(s.toString());
            return ;
        }
        char c = digits.charAt(i);
        String choices = map.get(c);
        for (char ch : choices.toCharArray()) {
            s.append(ch);
            backtrack(i+1, digits, s, map, res);
            s.deleteCharAt(i);
        }
    }
}
