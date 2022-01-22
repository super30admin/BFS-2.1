'''
TC: O(m*n)
SC: O(m*n)
'''
from collections import deque

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        
        rlen = len(grid)
        if not rlen:
            return -1
        clen = len(grid[0])
        ro = 0
        fo = 0
        queue = deque()
        xdir = [0, 0, 1, -1]
        ydir = [1, -1, 0, 0]
        t = 0
        
        for i in range(rlen):
            for j in range(clen):
                if grid[i][j] == 2:
                    ro += 1
                    queue.append((i, j))
                elif grid[i][j] == 1:
                    fo += 1
        
        if ro == 0 and fo > 0:
            return -1
        
        queue.append(None)
        def isSafe(x, y, r, c):
            if x >= 0 and y >=0 and x < r and y < c:
                return True
            return False

        while queue:
            top = queue.popleft()
            if not top:
                if not queue:
                    break
                queue.append(None)
                t += 1
                continue
            
            x, y = top[0], top[1]
            for i in range(4):
                newx = x + xdir[i]
                newy = y + ydir[i]
                
                if isSafe(newx, newy, rlen, clen) and grid[newx][newy] == 1:
                    grid[newx][newy] = 2
                    queue.append((newx, newy))
            
        
        for i in range(rlen):
            for j in range(clen): 
                if grid[i][j] == 1:
                    return -1
                
        return t
                
            
        