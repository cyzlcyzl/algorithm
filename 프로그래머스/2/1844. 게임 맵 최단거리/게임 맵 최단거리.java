import java.util.*;

class Solution {
    
    public int bfs(int[][] maps){
        
        int n = maps.length;
        int m = maps[0].length;
        
        int[] moveX = {-1,1,0,0};
        int[] moveY = {0,0,-1,1};
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        
        while(! queue.isEmpty()){
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            
            for(int i = 0; i<4; i++){
                int nextX = nowX + moveX[i];
                int nextY = nowY + moveY[i];
                
                if(nextX>=0 && nextY>=0 && nextX<n && nextY<m){
                    if(maps[nextX][nextY] == 1){
                        maps[nextX][nextY] = maps[nowX][nowY] + 1;
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }
        if(maps[n-1][m-1] == 1) return -1;
        return maps[n-1][m-1];
        
    }
    
    public int solution(int[][] maps) {
        return bfs(maps);
    }
}