package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _17_Letter_Combinations_of_a_Phone_Number {
    public static void main(String[] args) {
        List<String> s = new ArrayList<>();
        _17_Letter_Combinations_of_a_Phone_Number test = new _17_Letter_Combinations_of_a_Phone_Number();
        s = test.letterCombinations("23");
        for(String l:s) {
            System.out.println(l);
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) // 如果给定的串为空，则返回空
            return new ArrayList<String>();
        // 将电话上面对应数字的字符放到hashmap中，key为电话号，value为对应的字母
        HashMap<Character, String> map = new HashMap<Character, String>();
        map.put('0',"");
        map.put('1',"");
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");


        List<String> result = new ArrayList<String>();
        StringBuilder sublist = new StringBuilder();
        // digits：给定的数字，  sublist：中间的过程，result：最后的结果， map：号码与字符的对应关系
        getCombo(digits, sublist, result, map);
        return result;

    }
    public void getCombo(String digits, StringBuilder sublist, List<String> result, HashMap<Character, String> map){
        if(digits.length()==0){ // 因为返回的字符的个数应该和传递进来的数字的个数一样，所以以字符==数字的个数作为终止条件
            //add sublist to the result
            result.add(sublist.toString());
            return;
        } // 当前号码中的第一个数字
        char currDigit = digits.charAt(0);
        String possibleLetters = map.get(currDigit); // 从hashmap中取出这个数字对应的字符
        for(int i = 0; i < possibleLetters.length(); i++){
            sublist.append( possibleLetters.charAt(i) );  // 从hashmap中取出来一个字符加到中间字符里面
            // 刨除当前数字串中的第一个元素，然后递归
            getCombo(digits.substring(1), sublist, result, map);
            sublist.replace(sublist.length() - 1, sublist.length(), ""); // 将中间字符串中最后一个字符移除，然后进入下一次循环
        }
    }
}
