public class _387_First_Unique_Character_in_a_String {
    public static void firstUniqChar(String s) {
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a'] ++;
        }
        for(int i = 0; i < s.length(); i++) {
            if(arr[i] == 1) {
                System.out.println(i);
                break;
            }
        }
    }

    public static void main(String[] args) {
        _387_First_Unique_Character_in_a_String.firstUniqChar("abcba");
    }
}
