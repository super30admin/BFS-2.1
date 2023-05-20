## Problem 1

# Rotting Oranges(https://leetcode.com/problems/rotting-oranges)

# Time Complexity: O(m*n)
# Space Complexity: O(m*n)
# Did this code successfully run on Leetcode: Yes
# Approach: BFS

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if not grid:
            return 0
        queue = deque()
        fresh = 0
        m = len(grid)
        n = len(grid[0])
        time = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    queue.append((i, j))
                elif grid[i][j] == 1:
                    fresh += 1
        if fresh == 0:
            return 0
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        while queue:
            size = len(queue)
            for i in range(size):
                curr = queue.popleft()
                for d in dirs:
                    r = curr[0] + d[0]
                    c = curr[1] + d[1]
                    if r >= 0 and r < m and c >= 0 and c < n and grid[r][c] == 1:
                        grid[r][c] = 2
                        queue.append((r, c))
                        fresh -= 1
            time += 1
        if fresh != 0:
            return -1
        return time - 1