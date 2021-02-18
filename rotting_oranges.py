# O(M * N) TIME AND O(M * N) SPACE WHERE M IS NO.OF ROWS AND N IS NO.OF COLS
from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        fresh_oranges = 0
        que = deque()
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 2:
                    que.append([i,j])
                elif grid[i][j] == 1:
                    fresh_oranges += 1
        if fresh_oranges == 0:
            return 0
        return self.getMinMinutes(grid,que,fresh_oranges)
    
    def getMinMinutes(self,grid,que,fresh_oranges):
        minutes = 0
        while que:
            size = len(que)
            for _ in range(size):
                row,col = que.popleft()
                directions = [[0,1],[1,0],[0,-1],[-1,0]]
                for direction in directions:
                    i = row + direction[0]
                    j = col + direction[1]
                    if i >= 0 and i < len(grid) and j >= 0 and j < len(grid[0]) and grid[i][j] == 1:
                        que.append([i,j])
                        grid[i][j] = 2
                        fresh_oranges -= 1
            minutes += 1
        return minutes - 1 if fresh_oranges == 0 else -1