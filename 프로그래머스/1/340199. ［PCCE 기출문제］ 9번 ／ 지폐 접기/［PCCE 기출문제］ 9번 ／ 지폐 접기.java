class Solution {
    public int solution(int[] wallet, int[] bill) {
        
        int w_max;
        int w_min;
        int b_max;
        int b_min;
        
        if (wallet[0] > wallet[1]) {
            w_max = wallet[0];
            w_min = wallet[1];
        } else {
            w_max = wallet[1];
            w_min = wallet[0];
        }
        
        if (bill[0] > bill[1]) {
            b_max = bill[0];
            b_min = bill[1];
        } else {
            b_max = bill[1];
            b_min = bill[0];
        }
        
        int answer = 0;
        
        while (w_max < b_max || w_min < b_min) {
            b_max = b_max / 2;
            answer++;
            
            if (b_max < b_min) {
                int tmp = b_max;
                b_max = b_min;
                b_min = tmp;
            }
        }
        
        return answer;
    }
}