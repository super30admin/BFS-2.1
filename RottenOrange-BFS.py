Time Complexity: O(m*n)
Space Complexity:O(m*n)
from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if len(grid) == 0 or grid is None:
            return 0
        q = deque()
        m = len(grid)
        n = len(grid[0])
        dirs = [[0,1], [1,0], [0,-1], [-1,0]]
        fresh = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    q.append((i,j))
                elif grid[i][j] == 1:
                    fresh += 1
                    
        time = 0
        if fresh == 0:
            return 0
        
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                for d in dirs:
                    nr = curr[0] + d[0]
                    nc = curr[1] + d[1]
                    if nr >=0 and nc >=0 and nr < m and nc < n and grid[nr][nc] == 1:
                        q.append((nr,nc))
                        grid[nr][nc] = 2
                        fresh -= 1
            time += 1
            
        if fresh == 0:
            return time - 1
        return -1
                    
                    
            
                
        
        
