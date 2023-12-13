// Time Complexity : O(M*N) | for DFS, O(M*N)^2
// Space Complexity : O(M*N) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Explain your approach: this problem can be done using bith BFS and DFS
// using BFS, we keep count of fresh oranges and we push all the rotten oranges into the queue
// keeping track of size / level, at every level, we check 4 neighbours of each rotten orange in queue
// if any of the in biund neightbours are fresh, we rot them. At the end of each level, we increase time
// in the end, if fresh count has become 0, we return time - 1, else return -1
// one edge case, before iterating over queue elements, if fresh count is 0, from there itself return 0
// it means there are no fresh oranges present to rot.


import java.util.*;
class Solution{
    public int rottenOranges(int[][] grid){
        if(grid == null || grid.length == 0) return 0;
        int m = grid.length; int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) fresh++;
                else if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                }
            }
        }
        int time = 0;
        if(fresh == 0) return 0;
        int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                for(int[] dir: dirs){
                    int r = dir[0] + curr[0];
                    int c = dir[1] + curr[1];
                    if(r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == 1){
                        grid[r][c] = 2;
                        q.add(new int[]{r, c});
                        fresh--;
                    }
                }

            }
            time++;
        }
        if(fresh > 0) return -1;
        return time - 1;
    }
}