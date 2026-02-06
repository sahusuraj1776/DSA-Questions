// Max Sum Subarray of size K - GeeksforGeeks 
// Difficulty: EasyAccuracy: 49.6%Submissions: 254K+Points: 2
// Given an array of integers arr[]  and a number k. Return the maximum sum of a subarray of size k.

// Note: A subarray is a contiguous part of any given array.

// Examples:

// Input: arr[] = [100, 200, 300, 400], k = 2
// Output: 700
// Explanation: arr2 + arr3 = 700, which is maximum.
// Input: arr[] = [1, 4, 2, 10, 23, 3, 1, 0, 20], k = 4
// Output: 39
// Explanation: arr1 + arr2 + arr3 + arr4 = 39, which is maximum.
// Input: arr[] = [100, 200, 300, 400], k = 1
// Output: 400
// Explanation: arr3 = 400, which is maximum.
// Constraints:
// 1 ≤ arr.size() ≤ 106
// 1 ≤ arr[i] ≤ 106
// 1 ≤ k ≤ arr.size()



package SlidingWindow;

public class MaxSumSubarrayOfSizeK {
    public static void main(String[] args) {
        int [] arr = {100, 200, 300, 400};
        int k = 2;
        int max = solve(arr,k);
        System.out.println("Max Sum of sub array: "+max);
    }

    private static int solve(int[] arr, int k) {
        int sum=0,max=0;
        // calculating initial window
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        max = sum;
        for(int i=k;i<arr.length;i++){
            // adding new value to prev
            sum+=arr[i];
            // removing start element to slide window
            sum-=arr[i-k];
            // checking max
            if(sum>max){
                max = sum;
            }
        }
        return max;
    }
}
