// Minimum Size Subarray Sum  - Leetcode - 209

// Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

// Example 1:
// Input: target = 7, nums = [2,3,1,2,4,3]
// Output: 2
// Explanation: The subarray [4,3] has the minimal length under the problem constraint.4

// Example 2:
// Input: target = 4, nums = [1,4,4]
// Output: 1

// Example 3:
// Input: target = 11, nums = [1,1,1,1,1,1,1,1]
// Output: 0
 

// Constraints:
// 1 <= target <= 109
// 1 <= nums.length <= 105
// 1 <= nums[i] <= 104


package SlidingWindow;

public class MinimumSizeSubarraySum {

    public static int minSubArrayLen(int target, int[] nums) {
        int min=Integer.MAX_VALUE,sum=0,i=0,j=0;
        while(j<nums.length){
            sum+=nums[j];
            while(sum>=target){
                min=Math.min(min,j-i+1);
                sum-=nums[i];
                i++;
            }
            j++;
        }
        return min == Integer.MAX_VALUE?0:min;
    }

    public static void main(String[] args) {
        int [] arr = {2,3,1,2,4,3};
        int target = 7;
        int max = minSubArrayLen(target,arr);
        System.out.println("Output: "+max);
    }
    
}
