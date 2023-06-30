/*
Given an integer array nums, return the length of the longest strictly increasing subsequence.
Example 1:
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:
Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:
Input: nums = [7,7,7,7,7,7,7]
Output: 1
 */

package Blind75;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {
    public int lengthOfLISBinarySearch(int[] nums) {
        List<Integer> subsequence = new ArrayList<>();
        for (int num : nums) {
            int insertIndex = binarySearch(subsequence, num);
            if (insertIndex == subsequence.size()) {
                subsequence.add(num);
            } else {
                subsequence.set(insertIndex, num);
            }
        }
        return subsequence.size();
    }

    private int binarySearch(List<Integer> subsequence, int target) {
        int left = 0;
        int right = subsequence.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (subsequence.get(mid) < target) {
                left = mid + 1;
            } else if (subsequence.get(mid) > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
