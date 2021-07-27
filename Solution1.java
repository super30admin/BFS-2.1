// Time complexity: O(m*n), where m*n is the size of the grid. 
// Space complexity: O(m*n)

import java.util.*;

class Solution1 {
    public int orangesRotting(int[][] grid) {
        int m = grid.length; 
        int n = grid[0].length; 
        
        Queue<Integer> queue = new LinkedList<>(); 
        
        int freshOranges = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 2) {
                    int cell = i*n + j;
                    queue.offer(cell); 
                } else if(grid[i][j] == 1) {
                    freshOranges++; 
                }
            }
        }
        if(freshOranges == 0) return 0; 
        
        int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        int minutes = 0;
        //bfs
        while(!queue.isEmpty()) {
            int size = queue.size(); 
            while(size > 0) {
                int cell = queue.poll(); 
                int row = cell/n;
                int col = cell%n; 
                for(int[] d : directions) {
                    int neighborRow = row + d[0];
                    int neighborCol = col + d[1];
                    if (neighborRow >= 0 && neighborRow < m && neighborCol >= 0 && neighborCol < n && grid[neighborRow][neighborCol] == 1) {
                        grid[neighborRow][neighborCol] = 2;
                        freshOranges--;
                        int neighborCell = neighborRow*n + neighborCol;
                        queue.offer(neighborCell);
                    }
                }
                size--; 
            }
            minutes++;      
        }
                
        return freshOranges > 0?-1:minutes-1; 
    }
}