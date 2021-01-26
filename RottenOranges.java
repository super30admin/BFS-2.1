/*
time complexity: O(m*n)
space complexity: O(n)
*/
class Solution {
    /*
    0- empty
    1- fresh orange
    2 - rotten orange
    */
    
    int[]rows= {1,-1,0,0};
    int[]cols = {0,0,1,-1};
    int m;
    int n;
    public int orangesRotting(int[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        
        this.m = grid.length;
        this.n = grid[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        
        int freshcount =0;
        for(int i =0; i < m; i++){
            for(int j = 0; j < n;j++){
                if(grid[i][j] == 2){
                   queue.add(new int[]{i,j});
                }else if(grid[i][j] == 1){
                    freshcount++;
                }
            }
        }
        
        
        if(freshcount == 0)return 0;
        
        int count =0;
        
        while(!queue.isEmpty()){
            count++;
            int size = queue.size();
            for(int i =0; i < size;i++){
                int[]point = queue.poll();
                
                int x = point[0];
                int y = point[1];
                
                for(int k = 0;k < 4;k++){
                    int nr = x+rows[k];
                    int nc = y+cols[k];
                    
                    if(nr < 0 || nc < 0 || nr >= m || nc >= n || grid[nr][nc] == 0 || grid[nr][nc] == 2)
                    {
                        continue;
                    }
                    
                    grid[nr][nc] =2;
                    queue.add(new int[]{nr,nc});
                    freshcount--;
                }
            }
        }
        
        return freshcount == 0 ? count-1 : -1;
    }
    
    
    
    
}