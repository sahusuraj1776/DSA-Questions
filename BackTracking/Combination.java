// Combinations - LeetCode-77

// Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
// You may return the answer in any order.

// Example 1:

// Input: n = 4, k = 2
// Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
// Explanation: There are 4 choose 2 = 6 total combinations.
// Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.

// Example 2:
// Input: n = 1, k = 1
// Output: [[1]]
// Explanation: There is 1 choose 1 = 1 total combination.

// Constraints:

// 1 <= n <= 20
// 1 <= k <= n

package BackTracking;
import java.util.ArrayList;
import java.util.List;

public class Combination {
    public static void main(String[] args) {
        int n=4;
        int k=2;
        List<List<Integer>> res = solve(n,k);
        for(List<Integer> r:res){
            System.out.println(r);
        }
    }

    private static List<List<Integer>> solve(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        int f=1;
        backtrack(f,n,k,lst,res);
        return res;
    }

    private static void backtrack(int f, int n, int k, List<Integer> lst, List<List<Integer>> res) {
        if(lst.size()==k){
            res.add(new ArrayList<>(lst));
            return;
        }
        int aSL = k - lst.size();
        int options = n - f + 1;
        //Options
        for(int i = f; i <= f + (options-aSL); i++){
            lst.add(i);
            backtrack(i+1,n,k,lst,res);
            lst.remove(lst.size()-1);
        }
    }
}