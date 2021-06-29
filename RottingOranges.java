//bfs solution

// time complexity: O(mxn)
// space complexity: O(mxn) for queue
// run on Leetcode:
// issues faced:

class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        int freshOranges = 0;
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i, j});
                }
                if(grid[i][j] == 1)
                    freshOranges++;
            }
        }
        if(queue.isEmpty() && freshOranges == 0)
            return 0;
        int counter = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
            for(int i=0; i<size; i++){
                int curr[] = queue.poll();
                for(int[] dir: dirs){
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if(x>=0 && y>=0 && x<m && y<n && grid[x][y] == 1){
                        freshOranges--;
                        grid[x][y] = 2;
                        queue.add(new int[]{x,y});
                    }   
                }          
            }
            counter++;    
        }
        
        if(freshOranges == 0)
            return counter-1;
        else
            return -1;
    }
}
