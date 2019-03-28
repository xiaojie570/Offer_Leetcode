package string;

public class _647_Palindromic_Substrings {

    public int countSubstrings(String s) {
        int result = 0;
        if((s == null) || (s.length() == 0)){ return result; }
        for(int itr=0; itr<s.length(); itr++){
            result += isPalindromeRange(s, itr, itr);   //奇数 length substrings
            result += isPalindromeRange(s, itr, itr+1); //偶数 length substrings
        }
        return result;
    }

    // 检查给定范围内的字符串是否为回文，并返回此范围内回文子字符串的计数。
    public static int isPalindromeRange(String string, int start, int end){
        int count = 0;
        while((start >= 0) && (end < string.length()) && (string.charAt(start) == string.charAt(end))){
            count++; start--; end++;
        }
        return count;
    }

    public static void main(String[] args) {
        _647_Palindromic_Substrings test = new _647_Palindromic_Substrings();
        int ret = test.countSubstrings("aba");
        System.out.println(ret);

    }
}
