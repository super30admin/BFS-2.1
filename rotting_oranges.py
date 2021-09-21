# Did this code successfully run on Leetcode : YES

# TC: O(M*N)
# SC: O(M*N)

from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        dirs = [
            [1, 0], [-1, 0], [0, 1], [0, -1]
        ]
        m = len(grid)
        n = len(grid[0])
        fresh = 0
        q = deque()
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    fresh += 1
                elif grid[i][j] == 2:
                    q.append([i, j])
        time = 0
        if fresh == 0:
            return time
        while q:
            for _ in range(len(q)):
                [x, y] = q.popleft()
                for dir in dirs:
                    _x = dir[0] + x
                    _y = dir[1] + y
                    if 0 <= _x < m and 0 <= _y < n and grid[_x][_y] == 1:
                        # print((_x, _y, grid[_x][_y]))
                        q.append([_x, _y])
                        grid[_x][_y] = 2
                        fresh -= 1
            time += 1
        return time-1 if fresh == 0 else -1