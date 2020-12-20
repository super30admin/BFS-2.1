/*
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if grid is None or len(grid) == 0:
            return -1
        
        fresh = 0
        time = 0
        rows, cols = len(grid), len(grid[0])
        q = collections.deque()
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == 2:
                    q.append((i,j))
                    
                elif grid[i][j] == 1:
                    fresh += 1
        
        if fresh == 0:
            return 0
        
        dirs = [(0,1), (0,-1), (1,0), (-1,0)]
        while len(q) > 0:
            size = len(q)
            
            for i in range(size):
                rottenOrangeRow, rottenOrangeCol = q.popleft()
                
                for r,c in dirs:
                    newRow = rottenOrangeRow + r
                    newCol = rottenOrangeCol + c
                    
                    if newRow >= 0 and newRow < len(grid) and newCol >= 0 and newCol < len(grid[0]) and grid[newRow][newCol] ==  1:
                        grid[newRow][newCol] = 2
                        q.append((newRow, newCol))
                        fresh -= 1
            
            time += 1
            
        if fresh > 0:
            return -1
        
        return time - 1
*/

// Time Complexity : O(rows x cols)
// Space Complexity : O(rows x cols)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: I put all the rotten orange in the queue and did bfs to rot other orange
// every time I passed one level I increased time by 1
class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0)
            return -1;
        
        int fresh = 0, rows = grid.length, cols = grid[0].length, time = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                if (grid[i][j] == 2){
                    q.add(new int[] {i, j});
                }
                else if (grid[i][j] == 1){
                    fresh ++;
                }
            }
        }
        
        if (fresh == 0)
            return 0;
        
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        
        while (!q.isEmpty()){
            int size = q.size();
            
            for (int i=0; i<size; i++){
                int [] orange = q.poll();
                
                for (int[] dir: dirs){
                    int newRow = orange[0] + dir[0];
                    int newCol = orange[1] + dir[1];
                    
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] ==  1){
                        grid[newRow][newCol] = 2;
                        fresh --;
                        q.add(new int[] {newRow, newCol});
                    }
                }
            }
            time++;
        }
        
        if (fresh > 0)
            return -1;
        
        return time -1;
    }
}