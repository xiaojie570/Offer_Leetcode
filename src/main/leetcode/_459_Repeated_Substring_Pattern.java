public class _459_Repeated_Substring_Pattern {
    public boolean repeatedSubstringPattern(String s) {
        String s1 = s + s;
        System.out.println(s1.substring(1,s1.length() - 1));
        return s1.substring(1,s1.length() - 1).contains(s);
    }

    public static void main(String[] args) {
        _459_Repeated_Substring_Pattern repeated_substring_pattern = new _459_Repeated_Substring_Pattern();
        boolean ret = repeated_substring_pattern.repeatedSubstringPattern("abcabcabcabc");
        System.out.println(ret);
    }
}
