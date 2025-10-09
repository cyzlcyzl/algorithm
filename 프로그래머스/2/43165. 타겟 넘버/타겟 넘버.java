class Solution {
    
    static int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs (0, 0, numbers, target);
        return answer;
    }
    
    void dfs(int depth, int cal, int[] numbers, int target) {
        
        if (depth == numbers.length) {
            if (cal == target) answer++;
            return;
        }
        
        dfs(depth + 1, cal + numbers[depth], numbers, target);
        dfs(depth + 1, cal - numbers[depth], numbers, target);
        
    }
}