# Time Complexity: O(m^2 * n^2)
# Space Complexity: O(1); Auxillary space
  
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        # if len(grid) == 0 or grid is None:
        #     return 0
        m = len(grid)
        n = len(grid[0])
        dirs = [[1,0], [0,1], [-1,0], [0,-1]]
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    self.dfs(grid, i, j, 2, dirs)
        
        maxT = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    return -1
                maxT = max(maxT, grid[i][j]-2)
        return maxT
    
    def dfs(self, grid, i, j, time, dirs):
        #base
        if i < 0 or j < 0 or i == len(grid) or j == len(grid[0]):
            return
        if grid[i][j] != 1 and grid[i][j] < time:
            return 
        
        #logic
        grid[i][j] = time
        
        for d in dirs:
            nr = i + d[0]
            nc = j + d[1]
            self.dfs(grid, nr, nc, time+1, dirs)
            
        
    
                    
