import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        for (int i = 0; i<=t.length()-p.length(); i++) {
            Long s = Long.parseLong(t.substring(i, i + p.length()));
            if (s <= Long.parseLong(p)) answer++;
        }
        
        return answer;
    }
}