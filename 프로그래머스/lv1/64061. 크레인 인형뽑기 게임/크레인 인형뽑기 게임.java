import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> res = new Stack<>(); // 결과를 담을 스택 바구니

        for(int i : moves){
            int j = 0;
            while(j<board.length && board[j][i-1]==0) j++;

            if(j==board.length) continue;
            if(res.isEmpty() || ! res.peek().equals(board[j][i-1])) res.push(board[j][i-1]);
            else if (res.peek().equals(board[j][i-1])){
                res.pop();
                answer += 2;
            }
            board[j][i-1] = 0;
        }

        return answer;
    }
}