import java.util.*;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> noteCount = new HashMap<>();
        Map<Character, Integer> magazineCount = new HashMap<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int cur = ransomNote.length();
            ransomNote = ransomNote.replace(String.valueOf(ch), "");
            
            noteCount.put(ch, cur - ransomNote.length());
            
            cur = magazine.length();
            magazine = magazine.replace(String.valueOf(ch), "");
            magazineCount.put(ch, cur - magazine.length());
        }
        
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (noteCount.get(ch) > magazineCount.get(ch)) {
                return false;
            }
        }
        return true;
    }
}