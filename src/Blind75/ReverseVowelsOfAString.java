/*
Given a string s, reverse only all the vowels in the string and return it.
The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
Example 1:
Input: s = "hello"
Output: "holle"
Example 2:
Input: s = "leetcode"
Output: "leotcede"
 */

package Blind75;

public class ReverseVowelsOfAString {
    public String reverseVowelsStringBuilder(String s) {
        StringBuilder sb = new StringBuilder(s);
        String vowels = "aeiouAEIOU";
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !vowels.contains(sb.charAt(left) + "")) {
                left++;
            }
            while (left < right && !vowels.contains(sb.charAt(right) + "")) {
                right--;
            }
            if (left < right) {
                char temp = sb.charAt(left);
                sb.setCharAt(left, sb.charAt(right));
                sb.setCharAt(right, temp);
                left++;
                right--;
            }
        }
        return sb.toString();
    }

    public String reverseVowelsSwap(String s) {
        StringBuilder sb = new StringBuilder(s);
        String vowels = "aeiouAEIOU";
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !vowels.contains(sb.charAt(left) + "")) {
                left++;
            }

            while (left < right && !vowels.contains(sb.charAt(right) + "")) {
                right--;
            }

            if (left < right) {
                char temp = sb.charAt(left);
                sb.setCharAt(left, sb.charAt(right));
                sb.setCharAt(right, temp);
                left++;
                right--;
            }
        }
        return sb.toString();
    }
}