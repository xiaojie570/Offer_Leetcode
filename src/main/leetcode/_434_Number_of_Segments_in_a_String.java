public class _434_Number_of_Segments_in_a_String {
    // 找到给定字符串中，单词的个数
    public int countSegments(String s) {
        int ret = 0;
        if(s == null || s.length() == 0) return ret;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) != ' ' && s.charAt(i - 1) == ' ')
                ret ++;
        }
        if(s.charAt(0) != ' ')
            ret ++;
        return ret;
    }
}
