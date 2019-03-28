package string;

public class _459_repeatedSubstringPattern {
    public static void main(String[] args) {
        _459_repeatedSubstringPattern test = new _459_repeatedSubstringPattern();
        boolean ret = test.repeatedSubstringPattern("abcabc");
        System.out.println(ret);
    }
    public boolean repeatedSubstringPattern(String str) {
        for (int i = 0; i < str.length() / 2; i ++) {
            // 找到子串的长度，就是找到中间的位置
            if (str.length() % (i + 1) != 0) {
                continue;
            }

            int len = i + 1;
            // 将原字符串的前半部分截取出来
            String substring = str.substring(0, len);

            boolean success = true;
            for (int j = len; success && ((j + len) <= str.length()); j += len) {
                String test = str.substring(j, j + len);
                success &= test.equals(substring);
            }

            if (success) {
                return true;
            }
        }

        return false;
    }
}
