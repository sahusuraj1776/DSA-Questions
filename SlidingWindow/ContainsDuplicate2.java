// Contains Duplicate II  - Leetcode - 219

// Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

// Example 1:
// Input: nums = [1,2,3,1], k = 3
// Output: true

// Example 2:
// Input: nums = [1,0,1,1], k = 1
// Output: true

// Example 3:
// Input: nums = [1,2,3,1,2,3], k = 2
// Output: false

// Constraints:
// 1 <= nums.length <= 105
// -109 <= nums[i] <= 109
// 0 <= k <= 105

package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate2 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer>set = new HashSet<>();
        for(int i=0;i<Math.min(nums.length,k);i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        for(int i=k;i<nums.length;i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
            set.remove(nums[i-k]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3,4};
        int k=3;
        boolean res = containsNearbyDuplicate(nums, k);
        System.out.println("Output: "+res);
    }
}
