class Solution:
    # Time Complexity - O(m*n)
    # Space Complexity - O(m*n)
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if grid is None or len(grid) == 0:
            return 0
        m = len(grid)
        n = len(grid[0])
        directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        q = deque()
        fresh = 0
        # Loop through the matrix and find all the fresh and rotten oranges.
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    fresh += 1
                elif grid[i][j] == 2:
                    q.append((i, j))

        if fresh == 0:
            return 0

        time = 0
        while len(q):
            qLen = len(q)
            for i in range(qLen):
                curr = q.popleft()
                for direction in directions:
                    new_row = curr[0] + direction[0]
                    new_col = curr[1] + direction[1]
                    if new_row >= 0 and new_row < m and new_col >= 0 and new_col < n and grid[new_row][new_col] == 1:
                        grid[new_row][new_col] = 2
                        fresh -= 1
                        q.append((new_row, new_col))
            time += 1

        if fresh != 0:
            return -1
        return time - 1