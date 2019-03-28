public class leetcode_5_ {
    // 最大回文子串
    public static void main(String[] args) {
        System.out.println(leetcode_5_.longestPalindrome("abcbadasdsdacbasda"));
    }
    public static String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        String ret = null;
        for(int i = s.length() - 1; i >= 0; i--) {
            for(int j = i; j < s.length(); j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) &&(j - i < 3 || dp[i + 1][j - 1]);
                if(dp[i][j] && (ret == null || j - i + 1> ret.length()))
                    ret = s.substring(i,j+1);
            }
        }
        return ret;
    }

    class Solution {
        private int start;
        private int maxLength;
        public String longestPalindrome(String s) {
            for(int i = 0; i < s.length(); i++) {
                expand(s, i, i);
                expand(s, i, i + 1);
            }

            return s.substring(start, start + maxLength);
        }

        private void expand(String s, int left, int right) {
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left --;
                right ++;
            }

            if(right - left - 1 > maxLength) {
                this.maxLength = right - left - 1;
                this.start = left + 1;
            }
        }
    }
}
