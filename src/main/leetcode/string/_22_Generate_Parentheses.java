package string;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _22_Generate_Parentheses {
    List<String> res;
    _22_Generate_Parentheses()
    {
        res=new ArrayList<String>();
    }

    void fun(String st,int m,int n)
    {
        if(m==0 && n==0)
        {
            res.add(st);
            return;
        }
        if(m>0)
        {
            st=st+"(";
            fun(st,m-1,n);
            st=st.substring(0,st.length()-1);
        }
        if(n>0 && n>m)
        {
            st=st+")";
            fun(st,m,n-1);
            st=st.substring(0,st.length()-1);
        }
    }

    public List<String> generateParenthesis(int n) {
        String st="";
        fun(st,n,n);
        return res;
    }
    public boolean isValid(String S) {
        char[] t = new char[S.length()];
        int pos = 0;
        for(char c:S.toCharArray()){
            if(c == 'c'){
                if(pos == 0 || t[--pos]!='b'){return false;}
                if(pos == 0 || t[--pos]!='a'){return false;}
            }else{
                t[pos++] = c;
            }
        }
        return pos == 0;
    }

    public static void main(String[] args) {
        /*List<String> ret = new ArrayList<>();
        _22_Generate_Parentheses r = new _22_Generate_Parentheses();
        ret = r.generateParenthesis(2);*/
        System.out.println("abc".substring(0,2));
    }
}
