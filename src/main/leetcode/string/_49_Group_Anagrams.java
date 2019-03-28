package string;

import java.util.*;

public class _49_Group_Anagrams {
    private static final String[] starters = {"", "+*-", "+**-", "+***-"};
    public static void main(String[] args) {
        String S = "86-(10)12345678";
        System.out.println( _49_Group_Anagrams.maskPhone(S));
        String b = "1234";
        StringBuilder a = new StringBuilder(b);
        System.out.println(a.replace(a.length() - 1,a.length()," "));
    }
    private static  String maskPhone(String S) {
        String phonePlain = S.replaceAll("[\\+\\-\\(\\)\\s]", "");
        /// 获取电话号码后四位
        String lastFour = phonePlain.substring(phonePlain.length() - 4, phonePlain.length());
        // 获取电话号码的前几位
        String start = starters[phonePlain.length() - 10];
        return start + "***-***-" + lastFour;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ar = s.toCharArray();
            Arrays.sort(ar);
            String sorted = String.valueOf(ar);
            List<String> list = map.get(sorted);
            if (list == null) list = new ArrayList<String>();
            list.add(s);
            map.put(sorted, list);
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> l : map.values()) {
            Collections.sort(l);
            res.add(l);
        }
        return res;
    }

    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> result = new ArrayList<>();
        int[] bMax = new int[26];
        for(String b : B) {
            int bCount[] = count(b);
            for(int i = 0 ; i < 26 ; i++)
                bMax[i] = Math.max(bMax[i], bCount[i]);
        }
        for(String a : A) {
            int[] aCount = count(a);
            for(int i = 0 ; i < 26 ; i++) {
                if(aCount[i] < bMax[i])
                    break;
                if(i == 25)
                    result.add(a);
            }
        }
        return result;
    }
    private int[] count(String b) {
        int[] count = new int[26];
        for(char c : b.toCharArray()) {
            count[c - 'a']++;
        }
        return count;

    }
}
