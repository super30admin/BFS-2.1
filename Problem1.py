class Solution:
    # Time Complexity:O(m*n)
    # Space Complexity:O(m*n)
    def orangesRotting(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        fresh = 0
        queue = []
        time = 0
        for i in range(0, m):
            for j in range(0, n):
                if grid[i][j] == 1:
                    fresh += 1
                elif grid[i][j] == 2:
                    queue.append((i, j))
        dirs = [[-1, 0], [0, -1], [1, 0], [0, 1]]
        if fresh == 0:
            return time
        while queue:
            size = len(queue)
            for i in range(0, size):
                curr = queue.pop(0)
                for j in dirs:
                    nr = curr[0] + j[0]
                    nc = curr[1] + j[1]
                    if nr >= 0 and nc >= 0 and nr < m and nc < n and grid[nr][nc] == 1:
                        grid[nr][nc] = 2
                        queue.append((nr, nc))
                        fresh -= 1
                        if fresh == 0:
                            return time + 1
            time += 1
        return -1
