import java.util.HashMap;
import java.util.Map;

class Solution {
    char[] spells = {'A', 'E', 'I', 'O', 'U'};
    Map<Character, Integer> spell;

    public int solution(String word) {
        spell = new HashMap();
        for (int i = 0; i < spells.length; i++) {
            spell.put(spells[i], i);
        }

        StringBuffer curWord = new StringBuffer();
        curWord.append('A');
        int i = 1;
        while (curWord.length() > 0) {
            if (word.equals(curWord.toString())) {
                break;
            }

            if (curWord.length() < 5) {
                curWord.append('A');
            } else {
                nextWord(curWord, curWord.length() - 1);
            }

            i++;
        }

        return i;
    }

    private void nextWord(StringBuffer word, int index) {
        if (index < 0) {
            return;
        }
        char c = word.charAt(index);
        int k = spell.get(c);
        if (k == 4) {
            word.deleteCharAt(index);
            nextWord(word, index - 1);
        } else {
            word.setCharAt(index, spells[k + 1]);
        }
    }
}