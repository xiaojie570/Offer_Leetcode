import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

public class _38_ {

    public static void main(String[] args) {
        String a = "abcdaasdd";
        int hash = 0;
        for(int i = 0; i < a.length(); i++) {
            int temp = 1 << (a.charAt(i) - 'a');
            if(hash >> temp != 0) {
                System.out.println(a.charAt(i));
                return;
            } else {
                hash |= (1 << (a.charAt(i) - 'a'));
            }
        }
        Executors.newCachedThreadPool();

    }
}
