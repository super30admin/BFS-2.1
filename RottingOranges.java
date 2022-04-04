class RottingOranges {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        int[][] dirs = new int[][] {{-1,0},{0,-1},{1,0},{0,1}};
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j]==1){
                    fresh++;
                }else if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
            }    
        }
        
        int time = 0;
        if(q.isEmpty()&&fresh==0) return 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size; i++){
                
                int[] curr = q.poll();

                for(int[] dir : dirs){
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    if(r >=0 && c >= 0 && r < grid.length && c < grid[r].length && grid[r][c]==1) {
                        q.add(new int[]{r,c});
                        grid[r][c] = 2;                        
                        fresh--;
                    }
                }                
                
            }
            
            time++;
        }
        
        if(fresh>0) return -1;
        
        return time-1;
    }
}
