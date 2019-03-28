package string;

import java.util.Hashtable;
import java.util.Stack;

public class _443_String_Compression {
    public int compress(char[] A){
        int index = 0;
        for(int i = 0, count = 0; i < A.length; i++){
            count++;
            if(i == A.length - 1 || A[i] != A[i + 1]){
                A[index++] = A[i];
                if(count > 1){
                    for(char c : String.valueOf(count).toCharArray()){
                        A[index++] = c;
                    }
                }
                count = 0;
            }
        }
        return index;
    }

    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<Character>();
        Hashtable<Character, Character> hashtable=new Hashtable<>();
        hashtable.put('(', ')');
        hashtable.put('{', '}');
        hashtable.put('[', ']');
        char[] input=s.toCharArray();
        for(int i=input.length-1;i>=0;i--)
        {
            if(input[i]==')'||input[i]=='}'||input[i]==']')
            {
                stack.push(input[i]);
            }
            else {
                Character temp=null;
                if(stack.empty())
                    return false;
                else {
                    temp=stack.pop();
                }
                if(hashtable.get(input[i])!=temp)
                    return false;

            }
        }
        if(stack.empty())
            return true;
        else {
            return false;
        }



    }

    public static void main(String[] args) {
        char[] a = {'a','a','b','b','c','c','c'};
        System.out.println("0:"+ '\u0000' +":0");
    }

    public int repeatedStringMatch(String A, String B) {
        int alen = A.length();
        int blen = B.length();
        int count = blen / alen;
        if(blen % alen != 0) count++;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < count; i++){
            sb.append(A);
        }
        if(!sb.toString().contains(B)){
            sb.append(A);
            count++;
            if(!sb.toString().contains(B)) return -1;
        }
        return count;
    }
}
