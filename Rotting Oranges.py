from collections import deque

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        #Approach: BFS, level-order traversal
        #Time Complexity: O(n)
        #Space Complexity: O(n) // deque
        
        dirs = [(-1, 0), (0, -1), (0, 1), (1, 0)]
        
        de = deque()
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 2:
                    de.append((i,j))
        
        if len(de) == 0:
            minutes = 0
        else:
            minutes = -1
            
        while de:
            minutes += 1
            sz = len(de)
            
            for i in range(sz):
                cell = de.popleft()
                for d in dirs:
                    x = cell[0] + d[0]
                    y = cell[1] + d[1]
                    
                    if x >= 0 and x < len(grid) and y >= 0 and y < len(grid[0]) and grid[x][y] == 1:
                        de.append((x, y))
                        grid[x][y] = 2
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    return -1
        
        return minutes