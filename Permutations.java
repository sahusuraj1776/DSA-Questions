// Permutations - LeetCode-46
// Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

// Example 1:
// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

// Example 2:
// Input: nums = [0,1]
// Output: [[0,1],[1,0]]

// Example 3:
// Input: nums = [1]
// Output: [[1]]
 
// Constraints:
// 1 <= nums.length <= 6
// -10 <= nums[i] <= 10
// All the integers of nums are unique.

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int [] nums = {1,2,3};
        List<List<Integer>> res = solve(nums);
        for (List<Integer> list : res) {
            System.out.print(list+" ");
        }
    }

    private static List<List<Integer>> solve(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        backtrack(lst,nums,res);
        return res;
    }

    private static void backtrack(List<Integer> lst, int[] nums, List<List<Integer>> res) {
        if(lst.size()==nums.length){
            res.add(new ArrayList<>(lst));
            return ;
        }
        for(int i=0; i<nums.length ;i++){
            if(!lst.contains(nums[i])){
                lst.add(nums[i]);
                backtrack(lst, nums, res);
                lst.remove(lst.size()-1);
            }
        }
    }
}
