from collections import deque

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:

        if not grid :
            return -1
        
        
        m = len(grid)
        n = len(grid[0])
        fresh = 0
        time = 0
        queue = deque()
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1: 
                    fresh+=1
                elif grid[i][j] == 2:
                    queue.append((i,j))
        
        if fresh == 0:
            return 0
        
        dirs = [[0,1],[1,0],[-1,0],[0,-1]]
        
        while queue :
            size = len(queue)
            for i in range(size):
                temp = queue.popleft()
                for d in dirs:
                    r = temp[0] + d[0]
                    c = temp[1] + d[1]
                    if r>=0 and r<m and c>=0 and c<n and grid[r][c] == 1:
                        grid[r][c] = 2
                        fresh -=1
                        queue.append((r,c))
            time +=1
        
        if fresh > 0:
            return -1
        else:
            return time-1
                
                
                    
                    
        