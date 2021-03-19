// TC - O(n), SC - O(n)

class Solution {
    public int orangesRotting(int[][] grid) {
        // Sanity check
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        // Initialise a queue
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        
        // keep the count of fresh oranges, add rotten oranges to queue
        
        int freshOranges = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                }else if(grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }
        
        int time = 0;
        // dirs array
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        // Iterate while q is not empty and inside, iterate over dirs array. When we travel in any direction, convert a normal orange to rotten.
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int x=0; x<size; x++){
                int[] pair = q.poll();
                
                for(int[] dir : dirs){
                    int i = dir[0] + pair[0];
                    int j = dir[1] + pair[1];
                    
                    if(i >=0 && i < n && j >= 0 && j < m && grid[i][j] == 1){
                        grid[i][j] = 2;
                        q.add(new int[]{i, j});
                        freshOranges--;
                    }   
                }
            }
            time++;
        }
        
        if(freshOranges != 0){
            return -1;
        }
        return time > 0 ? time - 1 : time;
        
    }
}