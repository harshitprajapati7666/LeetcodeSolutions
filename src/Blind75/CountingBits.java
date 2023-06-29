/*
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
Example 1:
Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10
Example 2:
Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
 */

package Blind75;

public class CountingBits {
    public int[] countBitsBitManipulation(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            result[i] = countOnes(i);
        }
        return result;
    }

    private int countOnes(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public int[] countBitsDPMostSignificantBit(int n) {
        int[] result = new int[n + 1];
        int msb = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                msb = i;
            }
            result[i] = result[i - msb] + 1;
        }
        return result;
    }

    public int[] countBitsDPLeastSignificantBit(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }
}
