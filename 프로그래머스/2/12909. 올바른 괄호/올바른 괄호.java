import java.util.*;

class Solution {
    boolean solution(String s) {
        char[] arr = s.toCharArray();
        
        boolean answer = false;
        Stack<Character> stack = new Stack<>();
        for(char c : arr){
            if(stack.isEmpty() && c == ')') return answer;
            if(c == '(') stack.push(c);
            else if (c == ')') stack.pop();
        }
        
        if(stack.isEmpty()) answer = true;
        return answer;
    }
}