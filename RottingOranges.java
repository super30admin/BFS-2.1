// Time Complexity : O(m*n) where m, n are rows and columns respectively
// Space Complexity :  O(m*n) where m, n are rows and columns respectively
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I was starting from only one rotten orange. should start from all

import java.util.*;

class RottingOranges{
    int [][] dirs;
    int m; int n;
    public int orangesRotting(int[][] grid) {
        if(grid==null||grid.length==0){
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        Queue<int[]>q = new LinkedList<>();
        int fresh = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0) return 0;
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[]curr = q.poll();
                for(int[] dir:dirs){
                    int nr = curr[0]+dir[0];
                    int nc = curr[1]+dir[1];
                    if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]==1){
                        grid[nr][nc] = 2;
                        fresh--;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            time++;
        }
        if(fresh==0){
            return time-1;
        }
        else{
            return -1;
        }
    }

    public static void main(String [] args){
        int [][] grid = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        RottingOranges ro = new RottingOranges();
        System.out.println(ro.orangesRotting(grid));
    }
}