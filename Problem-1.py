"""
Approach: do BFS, keep track of the levels and return levels

For both approaches
TC: O(mxn)
SC: O(mxn)
"""


from collections import deque
class Solution:
    # approach 1: BFS - using size to maintain level
    """
    def orangesRotting(self, grid: List[List[int]]) -> int:
        mins = -1
        m = len(grid)
        n = len(grid[0])
        fresh = 0
        if not grid:
            return 0

        q = deque()
        for i,row in enumerate(grid):
            for j, cell in enumerate(row):
                if cell == 2:
                    q.append([i,j])
                elif cell == 1:
                    fresh += 1
        if not fresh:
            return 0
        dirs = [[0, 1], [0, -1], [-1, 0], [1, 0]]
        while q:
            size = len(q)
            for _ in range(size):
                curr = q.popleft()
                #grid[curr[0]][curr[1]] = -1
                for r,c in dirs:
                    nr = r + curr[0]
                    nc = c + curr[1]
                    if 0 <= nr < m and 0 <= nc < n and grid[nr][nc] == 1:
                        grid[nr][nc] = 2
                        q.append([nr,nc])
                        fresh -= 1
            mins += 1

        if fresh:
            return -1
        return mins
        """

    # approach 2: Using pushing level into the queue
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if not grid:
            return 0

        mins = 0
        m = len(grid)
        n = len(grid[0])
        fresh = 0
        dirs = [[0, 1], [0, -1], [-1, 0], [1, 0]]
        q = deque()

        for i, row in enumerate(grid):
            for j, cell in enumerate(row):
                if cell == 2:
                    q.append([i, j, mins])
                elif cell == 1:
                    fresh += 1

        while q:
            sr, sc, mins = q.popleft()
            for r, c in dirs:
                nr = r + sr
                nc = c + sc
                if 0 <= nr < m and 0 <= nc < n and grid[nr][nc] == 1:
                    grid[nr][nc] = 2
                    q.append([nr, nc, mins + 1])
                    fresh -= 1

        if fresh:
            return -1
        return mins
