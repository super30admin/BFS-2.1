// Time Complexity : O(MN)
// Space Complexity : O(MN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.*;
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        
        int m = grid.length, n = grid[0].length;
        int fresh = 0, time = 0;
        
        //count do int[] or pairs as well but we will poll 2 at once
        Queue<Integer> queue = new LinkedList<>();
        
        //find rotten oranges and get fresh count
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1)
                    fresh++;
                else if(grid[i][j] == 2){
                    queue.add(i);
                    queue.add(j);
                }
            }
        }
        
        if(fresh == 0) return 0;
        
        int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        
        while(!queue.isEmpty()){
            int sz = queue.size();
            
            for(int i = 0; i < sz; i+=2){
                int r = queue.poll();
                int c = queue.poll();
                
                for(int[] dir: dirs){
                    int nR = r + dir[0];
                    int nC = c + dir[1];
                    
                    if(nR >= 0 && nR < m && nC >= 0 && nC < n && grid[nR][nC] == 1){
                        grid[nR][nC] = 2;
                        fresh--;
                        queue.add(nR);
                        queue.add(nC);
                    }
                }
            }
            time++;
        }
        
        if(fresh != 0) return -1;
        
        return time - 1;
    }
}