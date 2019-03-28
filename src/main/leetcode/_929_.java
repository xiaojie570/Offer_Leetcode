import java.util.HashSet;

public class _929_ {
    public String cleanEmail(String email) {
        String clean = email.substring(0,email.indexOf("@")).replace(".","");
        if(clean.contains("+"))
            clean = clean.substring(0,clean.indexOf("+"));
        return clean + email.substring(email.indexOf("@")); // +后面是获取domain
    }
    public int numUniqueEmails(String[] emails) {
        HashSet<String> hashSet = new HashSet<>();
        for(String email:emails)
            hashSet.add(cleanEmail(email));
        return hashSet.size();
    }
    public static void main(String[] args) {
        _929_ test = new _929_();
    }
}
