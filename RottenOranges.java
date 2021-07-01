/*TC - 0(M*N) SC (M*N)
 * */




class Solution {
    public int orangesRotting(int[][] grid) {
        
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0 ; 
        for(int i  = 0 ; i < grid.length; i++) {
            for(int j = 0 ; j  < grid[0].length; j++){
                if (grid[i][j] == 2){
                    // add to queue
                    queue.add(new int[] {i,j});
                } 
                if (grid[i][j] == 1){
                    fresh +=1;
                }
            }
        }
        if (fresh ==0) return 0;
        
        int time = 0 ;
        int m = grid.length;
        int n = grid[0].length;
        int [][] dirs = new int[][] {{-1,0}, {1,0}, {0,1}, {0,-1}};
        
        while(!queue.isEmpty()){
            time +=1;
            int size = queue.size();
             for (int i =  0; i < size; i++){
            int[] curr = queue.poll();
            
           
            for(int[] dir: dirs){
                int nr = curr[0] + dir[0];
                int nc = curr[1]+ dir[1];
                if (nr < m && nc < n && nr >= 0 && nc >= 0 && grid[nr][nc] == 1){
                    // if its fresh add to queue and make it rotten
                    queue.add(new int[]{nr, nc});
                    grid[nr][nc] = 2;
                    fresh --;
                }
            } 
            
        }
        }
	// if not all fresh are converted to rotten
        if(fresh !=0) return -1;
        
	// accounting for the last level
        return time-1;
        
        
    }
}
