/*
For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).
Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
Example 1:
Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"
Example 2:
Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"
Example 3:
Input: str1 = "LEET", str2 = "CODE"
Output: ""
Constraints:
1 <= str1.length, str2.length <= 1000
str1 and str2 consist of English uppercase letters.
 */
package Blind75;

public class GreatestCommonDivisorOfStrings {
    public String gcdOfStringsBrute(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        for (int i = length; i >= 1; i--) {
            String gcdStr = str1.substring(0, i);
            if (isDivisor(gcdStr, str1) && isDivisor(gcdStr, str2)) {
                return gcdStr;
            }
        }
        return "";
    }

    private boolean isDivisor(String divisor, String str) {
        int numRepeats = str.length() / divisor.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRepeats; i++) {
            stringBuilder.append(divisor);
        }
        return stringBuilder.toString().equals(str);
    }

    public String gcdOfStringsIterative(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int gcdLength = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLength);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public String gcdOfStringsRecursive(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        return str1.substring(0, gcd2(str1.length(), str2.length()));
    }

    private int gcd2(int a, int b) {
        return b == 0 ? a : gcd2(b, a % b);
    }
}
