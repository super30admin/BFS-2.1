// Time complexity - O(mxn)
// Space complexity - O(mxn) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
    int time;
    public int orangesRotting(int[][] grid) {
        
        if(grid.length == 0 || grid == null){
            
            return -1;
        }
    //    if(grid.length == 1 && grid[0].length == 1 && grid[0][0] == 0){
            
      //      return 0;
      //  }
       // int time = 0;
        int r = grid.length;
        int c = grid[0].length;
        
        int fresh = 0;
        Queue<Integer> q1 = new LinkedList<>();
        
        for(int i = 0; i < r ; i ++){
            
            for(int j = 0; j < c ; j ++){
                
                if(grid[i][j] == 1){
                    
                    fresh ++;
                }
                
                 if(grid[i][j] == 2){
                    
                    q1.add(i);
                    q1.add(j);
                }
            }
        }
       // time ++;
        if(fresh == 0 && q1.isEmpty()){
            return 0;
        }
         bfs(grid, r, c, fresh, q1);
        return time;
        
    }
    
    private void bfs(int[][] grid, int r, int c, int fresh, Queue<Integer> q1){
        
        int[] dx = new int[]{-1,0,0,1};
        int[] dy = new int[]{0,1,-1,0};
        int x;
        int y;
        
        while(!q1.isEmpty()){
            //time ++;
            int queueSize = q1.size();
        for(int k = 0; k < queueSize/2; k ++){
            
            int i = q1.poll();
            int j = q1.poll();
            
            for(int z = 0; z < 4; z ++){
                
                x = i + dx[z];
                y = j + dy[z];
                
                if(isValid(r ,c ,x ,y)){
                    
                    if(grid[x][y] == 1){
                    //    System.out.println(grid[x][y]);
                        grid[x][y] = 2;
                        q1.add(x);
                        q1.add(y);
                        fresh --;
                       // time ++;
                    }
                }
                
            }
            
        }
            time ++;
    }
        if(fresh != 0){
            
            time = -1;
        }
        else {
            
            time = time - 1;
        }
        
    }
    
    private boolean isValid(int r, int c, int x, int y){
        
        if(x > -1 && x < r && y > -1 && y < c){
            
            return true;
        }
        
        return false;
    }
}