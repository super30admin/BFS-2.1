// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null||grid.length==0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][] {{-1,0},{0,1},{0,-1},{1,0}};
        int fresh = 0;
        int time = 0;
        int size = 0;
        for(int i =0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                    size++;
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        
        if(fresh==0) return 0;
        
        while(!q.isEmpty()){
            for(int i =0;i<size;i++){
                int[] curr = q.poll();
                for(int[] dir: dirs){
                    int nr = dir[0]+curr[0];
                    int nc = dir[1]+curr[1];
                    if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1){
                        grid[nr][nc] = 2;
                        q.add(new int[]{nr,nc});
                        fresh--;
                    }
                }
            }
            time++;
            size = q.size();
        }
        if(fresh!=0) return -1;
        return time-1;
    }
}