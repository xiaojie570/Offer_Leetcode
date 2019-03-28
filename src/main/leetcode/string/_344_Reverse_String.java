package string;

public class _344_Reverse_String {
    public String reverseString(String s) {
        char[] str = s.toCharArray();
        int begin = 0;
        int end = s.length() - 1;
        while (begin < end) {
            str[begin] = (char) (str[begin] ^ str[end]);
            str[end] = (char) (str[begin] ^ str[end]);
            str[begin] = (char) (str[end] ^ str[begin]);
            begin++;
            end--;
        }
        return new String(str);
    }

    public static void main(String[] args) {
        _344_Reverse_String reverse_string = new _344_Reverse_String();
        System.out.println("hello");
        System.out.println(reverse_string.reverseString("hello"));

    }
}
