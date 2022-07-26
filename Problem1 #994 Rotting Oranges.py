# Time Complexity: O(m*n)
# Space Complexity: O(m*n)

import collections


class Solution:
    def orangesRotting(self, grid):
        if grid is None:
            return 0

        fresh = 0
        q = collections.deque()
        m = len(grid)
        n = len(grid[0])
        dirs = [[0,1], [0,-1], [1,0], [-1,0]]
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    fresh += 1
                elif grid[i][j] == 2:
                    q.append([i,j])

        if fresh == 0:
            return 0
        
        rottenTime = 0
        # BFS
        while q:
            qlen = len(q)
            for i in range(qlen):
                curr = q.popleft()
                for dir in dirs:
                    nr = curr[0] + dir[0]
                    nc = curr[1] + dir[1]
                    if nr >= 0 and nr < m and nc >= 0 and nc < n and grid[nr][nc] == 1:
                        fresh -= 1
                        q.append([nr,nc])
                        grid[nr][nc] = 2
            rottenTime += 1

        if fresh != 0:
            return -1
        else:
            return rottenTime - 1