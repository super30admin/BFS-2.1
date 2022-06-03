// Time Complexity : O(m*n)
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : yes

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][]{{0,1},{0,-1},{-1,0}, {1,0}};
        int count =0;
        for(int i =0; i<m; i++){
            for(int j =0; j<n ; j++){
                if(grid[i][j] ==2){
                    q.add(new int[]{i,j});
                }
                if(grid[i][j] ==1){
                    count++;
                }
            } 
        }
        if(count ==0) return 0;
        int rotten = 0;
        int minutes =0;
        while(!q.isEmpty()){
            int size = q.size();
    
            for(int i = 0; i< size; i++){
                int[] rc = q.poll();
                for(int[] dir : dirs){
                    int r = rc[0] + dir[0];
                    int c = rc[1] + dir[1];
                    if(r>=0 && c>=0 && r<m && c<n && grid[r][c] ==1){
                        grid[r][c] = -1; 
                        q.add(new int[]{r,c});
                        rotten++;
                    }
                    if(rotten == count) break;
                }
                    if(rotten == count) break;

            }
            
            minutes++;
            if(rotten == count) break;
            
        }
        if(rotten!=count) return -1;
        return minutes;
    }
}