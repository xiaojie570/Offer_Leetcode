package string;

import java.util.Stack;

public class _791_Custom_Sort_String {
    public String customSortString(String S, String T) {
        int[] set = new int[26];
        for(int i = 0; i < S.length(); i++)
            set[S.charAt(i) - 'a'] = i + 1;
        StringBuilder res = new StringBuilder();
        StringBuilder[] sbs = new StringBuilder[S.length()];
        for(int i = 0; i < sbs.length; i++){
            sbs[i] = new StringBuilder();
        }
        for(int i = 0; i < T.length(); i++){
            if(set[T.charAt(i) - 'a'] == 0)
                res.append(T.charAt(i));
            else{
                sbs[set[T.charAt(i) - 'a'] - 1].append(T.charAt(i));
            }
        }
        for(StringBuilder sb : sbs){
            if(sb.length() > 0)
                res.append(sb.toString());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Stack<int[]> generate = new Stack<int[]>();
        int[] m = new int[]{3,0};
        generate.push(m);
        System.out.println(generate.pop()[1]);
    }
}
