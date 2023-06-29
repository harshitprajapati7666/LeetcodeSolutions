/*
Given two integers a and b, return the sum of the two integers without using the operators + and -.
Example 1:
Input: a = 1, b = 2
Output: 3
Example 2:
Input: a = 2, b = 3
Output: 5
 */

package Blind75;

public class SumoFTwoIntegers {
    public int getSumExact(int a, int b) {
        return Math.addExact(a, b);
    }

    public int getSumBitManipulationIterative(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }

    public int getSumRecursive(int a, int b) {
        if (b == 0) {
            return a;
        }
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return getSumRecursive(sum, carry);
    }
}
