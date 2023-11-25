class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i = 0; i<prices.length-1; i++){
            int now = prices[i];
            int k = i + 1;
            int res = 0;
            while(k < prices.length){
                if(now <= prices[k]) {
                    res++;
                    k++;
                }
                else {
                    res++;
                    break;
                }
            }
            answer[i] = res;
        }
        answer[prices.length-1] = 0;
        
        return answer;
    }
}