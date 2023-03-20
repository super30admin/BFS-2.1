//TC: O(m*n)
//SC: O(m*n)
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        Queue<int[]> qu = new LinkedList<>();
      
        for(int i =0; i<m;i++){
            for(int j=0; j<n;j++){
                if(grid[i][j] == 2){
                    qu.add(new int[]{i,j});
                }
                if(grid[i][j] == 1) fresh++;
            }     
        }
        if(fresh == 0) return 0;
        int time = 0;
        int[][] dirs = new int[][] {{-1,0}, {0,-1}, {1,0}, {0,1}};
        
        //bfs
        while(!qu.isEmpty()){
          int size = qu.size();
            for(int i=0; i< size; i++){
                int[] curr = qu.poll();
                for(int[] dir: dirs){
                    int r = dir[0] + curr[0];
                    int c = dir[1] + curr[1];
                    if(r>=0 && r<m && c>=0 && c<n && grid[r][c] == 1){
                        grid[r][c] = 2;
                        fresh--;
                        qu.add(new int[]{r,c});
                }
               
                }    
            }
             time++;
        }
        if(fresh != 0) return -1;
        return time-1;
        
    }
}
