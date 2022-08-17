// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

//994. Rotting Oranges (Medium) - https://leetcode.com/problems/rotting-oranges/
// Time Complexity : O(m*n), Space Complexity : O(m*n)
class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int m = grid.length, n = grid[0].length, freshOranges = 0;
        Queue<int []> queue = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] {i, j});
                }
                
                if (grid[i][j] == 1) freshOranges++;
            }
        }
        
        if (freshOranges == 0) return 0;
        
        int time = 0;
        int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                
                for (int[] dir : dirs) {
                    int row = curr[0] + dir[0];
                    int col = curr[1] + dir[1];
                    
                    if (row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        freshOranges--;
                        queue.add(new int[] {row, col});
                    }
                }
            }
            time++;
        }
        
        return freshOranges != 0 ? -1 : time - 1;
    }
}