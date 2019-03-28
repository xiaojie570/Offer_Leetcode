public class _383_Ransom_Note {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] a = new int[26];
        for(int i = 0; i < ransomNote.length(); i++)
            a[ransomNote.charAt(i) - 'a'] ++;
        for(int i = 0; i < magazine.length(); i++) {
            if(--a[magazine.charAt(i)] < 0) return false;
        }
        return true;
    }
}
