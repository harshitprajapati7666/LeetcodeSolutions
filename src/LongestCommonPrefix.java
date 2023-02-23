/*
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".
Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Constraints:
1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder longestCommonPrefix = new StringBuilder();
        if (strs == null || strs.length == 0) {
            return longestCommonPrefix.toString();
        }
        int minimunLength = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            minimunLength = Math.min(minimunLength, strs[i].length());
        }
        for (int i = 0; i < minimunLength; i++) {
            char currentCharacter = strs[0].charAt(i);
            for (String str : strs) {
                if (str.charAt(i) != currentCharacter) {
                    return longestCommonPrefix.toString();
                }
            }
            longestCommonPrefix.append(currentCharacter);
        }
        return longestCommonPrefix.toString();
    }

    public String longestCommonPrefixUsingBinarySearch(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minimumLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minimumLength = Math.min(minimumLength, strs.length);
        }
        int low = 1;
        int high = minimumLength;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle)) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int length) {
        String string = strs[0].substring(0, length);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(string))
                return false;
        return true;
    }
    ///error at line 58 on passing empty string i.e. ""
}
