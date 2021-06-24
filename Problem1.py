# Time Complexity : 
# Space Complexity : 
# Did this code successfully run on Leetcode : 
# Any problem you faced while coding this : 

#bfs and make rotten when adding into queue so we don't add same neighbour again and again
from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        fresh = 0
        queue = deque()
        time = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    queue.append([i,j])
                if grid[i][j] == 1:
                    fresh += 1
        if fresh == 0:
            return 0
        while len(queue) != 0:
            size = len(queue)
            dirs = [[-1,0],[1,0],[0,1],[0,-1]]
            for i in range(size):
                node = queue.popleft()
                for j in dirs:
                    x = node[0] + j[0]
                    y = node[1] + j[1]
                    if x >= 0 and x < m and y >= 0 and y < n and grid[x][y] == 1:
                        grid[x][y] = 2
                        queue.append([x,y])
                        fresh -= 1
            time += 1
        if fresh != 0:
            return -1
        return time - 1
        