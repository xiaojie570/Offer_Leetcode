package string;

import java.util.ArrayList;
import java.util.List;

public class _842_Split_Array_into_Fibonacci_Sequence {
    public List<Integer> splitIntoFibonacci(String S) {
        ArrayList result = new ArrayList<>();
        splitIntoFibonacci(S, 0, result);
        return result;
    }
    private boolean splitIntoFibonacci(String S, int start, List<Integer> result){
        if(start >= S.length()  && result.size() >= 3)return true;
        if(start >= S.length() && result.size() < 3)return false;
        for(int i = start; i < Math.min(S.length(), start + 10); i++){
            String s = S.substring(start, i+1);
            if(s.charAt(0) == '0' && s.length() > 1 )return false;
            long a = Long.valueOf(s);
            if(a > Integer.MAX_VALUE)return false;
            if(result.size() >=2 && !(a == (result.get(result.size() -1) + result.get(result.size() -2)))){
                continue;
            }
            result.add(new Integer((int)a));
            if(splitIntoFibonacci(S, i+1, result))return true;
            else result.remove(result.size() -1);
        }
        return false;
    }
}
