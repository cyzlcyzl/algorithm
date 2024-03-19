import java.util.*;

class Solution {
    public int solution(String s) {
        String[] numbers = {"zero", "one", "two", "three", "four",
                           "five", "six", "seven", "eight", "nine"};
        
        for(int i = 0; i<numbers.length; i++){
            String word = numbers[i];
            if(! s.contains(word)) continue;
            
            s = s.replace(word, Integer.toString(i));
        }
        int answer = Integer.parseInt(s);
        return answer;
    }
}