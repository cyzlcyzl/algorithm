import java.lang.StringBuilder;
import java.lang.Math;

class Solution {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        while (n>0) {
            sb.append(n%3);
            n /= 3;     
        }
        
        String n_3 = sb.reverse().toString();
        int answer = 0;
        for (int i = 0; i<n_3.length(); i++) {
            answer += Character.getNumericValue(n_3.charAt(i)) * Math.pow(3, i);
        }

        return answer;
    }
}