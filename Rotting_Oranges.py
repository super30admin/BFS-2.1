from queue import Queue

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        
        m = len(grid)
        n = len(grid[0])
        minutes = 0
        
        direction = [(-1, 0), (1, 0), (0, -1), (0, 1)] # UpDownLeftRight
        rottenOranges = Queue()
        
        freshCount = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 2:
                    rottenOranges.put((i, j))
                elif grid[i][j] == 1:
                    freshCount += 1
                
        if freshCount == 0:
            return 0
        
        while not rottenOranges.empty():
            size = rottenOranges.qsize()
            
            for i in range(size):
                curr = rottenOranges.get()
                
                for dir in direction:
                    nr = curr[0] + dir[0]
                    nc = curr[1] + dir[1]
                    if nr >= 0 and nr <= m - 1 and nc >= 0 and nc <= n - 1 and grid[nr][nc] == 1:
                        grid[nr][nc] = 2
                        freshCount -= 1
                        rottenOranges.put((nr, nc))
                
            minutes += 1
            
        if freshCount != 0:
            return -1
        return minutes - 1
