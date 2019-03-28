package string;

import java.util.Arrays;
import java.util.Comparator;

public class _522_Longest_Uncommon_Subsequence_II {
    public static void main(String[] args) {
        Comparator<String> mycomparator = new Comparator<String>(){  //  写一个比较器，比较两个字符串的长度
            public int compare(String a,String b){
                return a.length() - b.length();
            }
        };
        _522_Longest_Uncommon_Subsequence_II test = new _522_Longest_Uncommon_Subsequence_II();
        String[] strs = {"ae","aea","aa"};
        int ret = test.findLUSlength(strs);
        System.out.println(ret);
    }
    public int findLUSlength(String[] strs) {
        if(strs == null || strs.length == 0)  return 0;
        Comparator<String> mycomparator = new Comparator<String>(){  //  写一个比较器，比较两个字符串的长度
            public int compare(String a,String b){
                return a.length() - b.length();
            }
        };
        Arrays.sort(strs,mycomparator); // 对字符串进行排序，这样只需要从小的开始比较就可以了
        int maxLen = -1;
        for(int i = strs.length-1; i >= 0; i--){  //
            boolean isUs = true;
            for(int j = strs.length-1; j >= 0; j--){
                if(strs[j].length() < strs[i].length())
                    break;
                if(i != j && isSubsequence(strs[i],strs[j])){
                    isUs = false;
                    break;
                }
            }
            if(isUs)
                maxLen = Math.max(maxLen,strs[i].length());
        }
        return maxLen;
    }

    public boolean isSubsequence(String a, String b){
        int start = 0;
        for(int i = 0; i < a.length(); i++){
            int index = b.indexOf(a.charAt(i),start);
            if(index == -1)
                return false;
            else{
                start = index + 1;
            }
        }
        return true;
    }

}
