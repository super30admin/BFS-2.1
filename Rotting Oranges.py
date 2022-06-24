# time complexity is o(mn), where m, n is the number of rows and columns in the grid.
# space complexity is o(mn), where m, n is the number of rows and columns in the grid.
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        r = len(grid)
        c = len(grid[0])
        from collections import deque
        q  = deque()
        fresh = 0
        time = 0
        for i in range(r):
            for j in range(c):
                if(grid[i][j] == 2):
                    q.append([i,j])
                if(grid[i][j] == 1):
                    fresh += 1
        if(fresh == 0):
            return fresh
        direc = [[-1,0], [1,0], [0,1], [0,-1]]
        while(len(q) != 0):
            l = len(q)
            for i in range(l):
                curr = q.popleft()
                for d in direc:
                    nr = curr[0] + d[0]
                    nc = curr[1] + d[1]
                    if(nr >= 0 and nc >= 0 and nr < r and nc < c and grid[nr][nc] == 1):
                        fresh -= 1
                        grid[nr][nc] = 2
                        q.append([nr, nc])
            time += 1
        if(fresh == 0):
            return time - 1
        else:
            return -1
    
        
                    
        
                    
        
        
        