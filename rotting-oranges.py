# Time complexity: O(m * n)
# Space complexity: O(m * n)

# The code scuessfully ran on Leetcode

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if grid == None or len(grid) == 0:  return -1
        
        m = len(grid)
        n = len(grid[0])
        q = []
        lvl = 0
        dirs = [[-1, 0], [0, -1], [1, 0], [0, 1]]
        freshOranges = 0
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    q.append([i, j])
                elif grid[i][j] == 1:
                    freshOranges += 1
                    
        if freshOranges == 0:   return 0
            
        while q:
            size = len(q)
            
            for i in range(size):
                curr = q.pop(0)
                
                for d in dirs:
                    nr = curr[0] + d[0]
                    nc = curr[1] + d[1]
                    
                    if nr >= 0 and nc >= 0 and nr < m and nc < n and grid[nr][nc] == 1:
                        q.append([nr, nc])
                        grid[nr][nc] = 2
                        freshOranges -= 1
            lvl += 1
            
        if freshOranges > 0:    return -1
        return lvl - 1
        