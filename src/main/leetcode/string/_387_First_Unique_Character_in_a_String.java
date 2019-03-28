package string;

public class _387_First_Unique_Character_in_a_String {
    public int firstUniqChar(String s) {
        int min = Integer.MAX_VALUE;
        int temp = 0;
        for(int i = 97; i<123; i++){
            temp = s.indexOf(i); // 返回对应的字符a-z所在的下标
            // 从前往后和从后往前找这个字符是不是一个位置
            if(temp != -1 && s.lastIndexOf(i) == temp){
                min = Math.min(min, temp);
            }
        }
        return min != Integer.MAX_VALUE ? min : -1;
    }

    public static void main(String[] args) {
        _387_First_Unique_Character_in_a_String test = new _387_First_Unique_Character_in_a_String();
        int ret = test.firstUniqChar("loveleetcode");

        String s = "abcdefg";
        StringBuilder temp = new StringBuilder(s.substring(0,2));
        StringBuilder sb = new StringBuilder(s);
        sb.replace(0,2,temp.reverse().toString());
        System.out.println(sb);

        System.out.println(s.substring(0,1));

    }
}
