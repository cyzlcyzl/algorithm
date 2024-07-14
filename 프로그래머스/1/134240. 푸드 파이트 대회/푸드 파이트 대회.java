import java.lang.StringBuilder;

class Solution {
    public String solution(int[] food) {        
        StringBuilder answer = new StringBuilder();
        for(int i = 1; i<food.length; i++) {
            int num = food[i] / 2;
            for(int k = 0; k<num; k++) answer.append(i);
        }
        answer.append("0");
        
        StringBuilder rev = new StringBuilder();
        for(int i = answer.length()-2; i>=0; i--) rev.append(answer.charAt(i));
        answer.append(rev);
        
        return answer.toString();
    }
}