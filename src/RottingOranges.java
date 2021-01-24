// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
/*
 * This approach is by using BFS method.
 * Firstly, we will traverse the grid to get the positions of all the rotten oranges and store then in the queue.
 * If there are fresh oranges then keep a counter for them.
 * Next, we will rotten all the neighboring oranges using the directions array list and the elements popped from the queue and 
 * reduce the fresh count respectively.
 * When the neighbor oranges are made rotten then increase the count of the time.
 * 
 */

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
	public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int fresh = 0;
        int time = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int []> q = new LinkedList<>();
        //get all the rotten oranges inside q
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    q.add(new int []{i,j});
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0) return 0;
        int [][] dirs = {{0,1},{-1,0},{0,-1},{1,0}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                for(int[] dir : dirs){
                    int r = dir[0] + curr[0];
                    int c = dir[1] + curr[1];
                    if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1){
                        q.add(new int []{r,c});
                        grid[r][c] = 2;
                        fresh--;
                    }
                }
            }
            time++;
        }
        if(fresh != 0) return -1;
        return time - 1;
    }
}
