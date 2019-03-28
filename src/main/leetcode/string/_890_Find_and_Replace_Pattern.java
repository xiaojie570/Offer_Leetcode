package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _890_Find_and_Replace_Pattern {
    private boolean is_PatternMatch(char[] word,char[] pattern){
        int[] word_lis=new int[26];
        int[] pattern_lis=new int[26];
        for(int i=0;i<word.length;i++){
            int w_idx = word[i] - 97; //  97 =‘a’
            int p_idx=  pattern[i] - 97;
            if(word_lis[w_idx]!=pattern_lis[p_idx]){
                return false;
            }
            word_lis[word[i]-97]=i+1;
            pattern_lis[pattern[i]-97]=i+1;
        }
        return true;
    }

    public static void main(String[] args) {
        _890_Find_and_Replace_Pattern test = new _890_Find_and_Replace_Pattern();
        char[] a= {'a','a','a'};
        char[] b= {'b','b','b'};

        boolean ret = test.is_PatternMatch(a,b);
        System.out.println(ret);
        System.out.println('c' - 97);
    }
}
