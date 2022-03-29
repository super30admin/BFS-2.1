/**
 * space complexity is O(m*n)
 * time complexity is O(m*n)
 */
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int orangesRotting(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        Set<Integer> seen = new HashSet<>();
        
        Queue<Integer> queue = new LinkedList<>();
        
        int[][] dirs = new int[][] {{-1,0}, {0,-1}, {0,1}, {1,0}};
        
        int result = -1;
        boolean hasFreshOranges = false;
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {

                if(grid[row][col] == 2) {
                    int pt = row*cols + col;
                    queue.add(pt);
                }
                else if(grid[row][col] == 1) {
                    hasFreshOranges = true;
                }
            }
        }
        if(queue.isEmpty() && !hasFreshOranges) {
            return 0;
        }
        while(!queue.isEmpty()) {
            result++;
            int size = queue.size();
            for(int k = 0; k < size; k++) {
                int currPt = queue.remove();
                seen.add(currPt);
                int i = currPt/cols;
                int j = currPt%cols;
                            
                for(int[] dir : dirs) {
                    int ii = i + dir[0];
                    int jj = j + dir[1];
                    if(ii >= 0 && ii < rows && jj >= 0 && jj < cols && grid[ii][jj] == 1) {
                        grid[ii][jj] = 2;
                        queue.add(ii*cols + jj);
                    }
                }
            }
        }
        
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(grid[row][col] == 1) {
                    return -1;
                }
            }
        }
        return result;
    }
}