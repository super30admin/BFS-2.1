#Space:O(n) queue can have all oranges as rotten
#Time: O(n)
from collections import deque
class Solution:
    def orangesRotting(self, grid):
        n, m = len(grid), len(grid[0])
        queue = deque()
        cnt = 0

        for i in range(n):
            for j in range(m):
                if grid[i][j] == 1:
                    cnt += 1
                if grid[i][j] == 2:
                    queue.append((i,j, 0)) #row, col, timestamp

        res = 0
        while queue:
            i, j, time_stamp = queue.popleft()
            res = time_stamp
            for x, y in [(i+1,j), (i-1,j), (i,j+1), (i,j-1)]:
                if 0<=x<n and 0<=y<m and grid[x][y] == 1:
                    grid[x][y] = 2
                    cnt -= 1
                    queue.append((x,y, time_stamp + 1))
        
        return res if cnt == 0 else -1