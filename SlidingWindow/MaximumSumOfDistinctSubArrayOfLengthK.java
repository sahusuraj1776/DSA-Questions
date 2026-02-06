// Maximum Sum of Distinct Subarrays With Length K - LeetCode - 2461

// You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:

// The length of the subarray is k, and
// All the elements of the subarray are distinct.
// Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.

// A subarray is a contiguous non-empty sequence of elements within an array.

 
// Example 1:
// Input: nums = [1,5,4,2,9,9,9], k = 3
// Output: 15
// Explanation: The subarrays of nums with length 3 are:
// - [1,5,4] which meets the requirements and has a sum of 10.
// - [5,4,2] which meets the requirements and has a sum of 11.
// - [4,2,9] which meets the requirements and has a sum of 15.
// - [2,9,9] which does not meet the requirements because the element 9 is repeated.
// - [9,9,9] which does not meet the requirements because the element 9 is repeated.
// We return 15 because it is the maximum subarray sum of all the subarrays that meet the conditions

// Example 2:
// Input: nums = [4,4,4], k = 3
// Output: 0
// Explanation: The subarrays of nums with length 3 are:
// - [4,4,4] which does not meet the requirements because the element 4 is repeated.
// We return 0 because no subarrays meet the conditions.
 

// Constraints:
// 1 <= k <= nums.length <= 105
// 1 <= nums[i] <= 105

package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class MaximumSumOfDistinctSubArrayOfLengthK {
    public static long maximumSubarraySum(int[] nums, int k) {

        // Fast Approach
        Set<Integer> set = new HashSet<>();
        long sum = 0, max = 0;
        int i = 0;

        for (int j = 0; j < nums.length; j++) {

            // Remove duplicates by shrinking window
            while (set.contains(nums[j])) {
                set.remove(nums[i]);
                sum -= nums[i];
                i++;
            }

            set.add(nums[j]);
            sum += nums[j];

            // When window size reaches k
            if (j - i + 1 == k) {
                max = Math.max(max, sum);

                // Slide window forward
                set.remove(nums[i]);
                sum -= nums[i];
                i++;
            }
        }
        return max;

        // Slow Approach
        // long sum=0,max=0;
        // Map<Integer,Integer> map = new HashMap<>();
        // int duplicate=0;
        
        // for(int i=0;i<k;i++){
        //     if(!map.containsKey(nums[i])){
        //         map.put(nums[i],0);
        //     }
        //     map.put(nums[i],map.get(nums[i])+1);
        //     sum+=nums[i];
        //     if(map.get(nums[i])>1){
        //         duplicate+=1;
        //     }
        // }
        // if(duplicate==0){
        //     max=Math.max(sum,max);
        // }

        // for(int i=k;i<nums.length;i++){
        //     int numToAdd = nums[i],numToRemove=nums[i-k];
        //     if(!map.containsKey(numToAdd)){
        //         map.put(numToAdd,0);
        //     }
        //     map.put(numToAdd,map.get(numToAdd)+1);
        //     if(map.get(numToAdd)>1){
        //         duplicate+=1;
        //     }
        //     sum += numToAdd;
        //     if(map.get(numToRemove)>1){
        //         duplicate-=1;
        //     }
        //     map.put(numToRemove,map.get(numToRemove)-1);

        //     sum-=numToRemove;
        //     if(duplicate==0){
        //         max=Math.max(sum,max);
        //     }
        // }
        // return max;
    }

    public static void main(String[] args) {
        int [] arr = {1,5,4,2,9,9,9};
        int k = 3;
        long max = maximumSubarraySum(arr,k);
        System.out.println("Max Sum of sub array: "+max);
    }
}
