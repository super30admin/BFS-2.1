from ast import List


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        rows = len(grid)
        cols = len(grid[0])
        maxDis = 2
        dirs = [[1, 0], [0, 1], [-1, 0], [0, -1]]

        def helper(r, c, dis):
            # base
            if not (0 <= r < rows) or not (0 <= c < cols) or grid[r][c] == 0:
                return
            if grid[r][c] != 1 and grid[r][c] < dis:
                return 

            # main logic
            grid[r][c] = dis
            for d in dirs:
                nr = r + d[0]
                nc = c + d[1]
                helper(nr, nc, dis+1)

        for row in range(rows):
            for col in range(cols):
                if grid[row][col] == 2:
                   helper(row, col, 2)

        for row in range(rows):
            for col in range(cols):
                if grid[row][col] == 1:
                    return -1
                maxDis = max(grid[row][col], maxDis)
        return maxDis-2
      
