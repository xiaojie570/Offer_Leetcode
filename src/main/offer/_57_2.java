import java.util.ArrayList;
import java.util.List;

public class _57_2 {
    List<Integer> list = new ArrayList<>();
    public static void findList(int sum, int n) {

    }
    public static void main(String[] args) {
        _57_2 test = new _57_2();
        System.out.println(_57_2.checkValidString("((()))"));
    }
    public static boolean checkValidString(String s) {
        int l = 0;
        int r = 0;
        for(char c: s.toCharArray()) {
            l = c == '(' ? 1: -1;
            r = c == ')' ? -1 : 1;
            if(l < r) return false;
            l = Math.max(l, 0);
        }
        return l == r;
    }

}
