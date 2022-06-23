# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# BFS
from collections import deque


class Solution:
    def orangesRotting(self, grid: list[list[int]]) -> int:
        fresh = 0
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        m = len(grid)
        n = len(grid[-1])
        queue = deque()
        time = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    fresh += 1
                if grid[i][j] == 2:
                    queue.append((i, j))
        if fresh == 0:
            return 0
        while queue:
            size = len(queue)
            for i in range(size):
                pop = queue.popleft()
                for x in dirs:
                    nr = x[0] + pop[0]
                    nc = x[1] + pop[1]
                    if 0 <= nr < m and 0 <= nc < n and grid[nr][nc] == 1:
                        queue.append((nr, nc))
                        grid[nr][nc] = 2
                        fresh -= 1
            time += 1
        if fresh != 0:
            return -1
        return time - 1


print(Solution().orangesRotting([[2, 1, 1], [1, 1, 0], [0, 1, 1]]))

# DFS
# TC: O((m*n)^2); SC: O(1)
# class Solution:
#     def __init__(self):
#         self.dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
#         self.maxi = 0
#
#     def dfs(self, grid, i, j, time):
#         if (grid[i][j] < time and grid[i][j] != 1) or grid[i][j] == 0:
#             return
#         grid[i][j] = time
#         for x in self.dirs:
#             nr = x[0] + i
#             nc = x[1] + j
#             if 0 <= nr < self.m and 0 <= nc < self.n:
#                 self.dfs(grid, nr, nc, time + 1)
#
#     def orangesRotting(self, grid: list[list[int]]) -> int:
#         self.m = len(grid)
#         self.n = len(grid[-1])
#         for i in range(self.m):
#             for j in range(self.n):
#                 if grid[i][j] == 2:
#                     self.dfs(grid, i, j, 2)
#         for i in range(self.m):
#             for j in range(self.n):
#                 if grid[i][j] == 1:
#                     return -1
#                 self.maxi = max(self.maxi, grid[i][j]-2)
#         return self.maxi
#
#
# print(Solution().orangesRotting([[2, 1, 1], [0, 1, 1], [1, 0, 1]]))
