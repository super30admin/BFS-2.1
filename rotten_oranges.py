# Time : O(M * N)
# Space: O(M * N)

from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:

        # base case
        if not grid or len(grid) == 0:
            return 0

        queue = deque()
        fresh_oranges = 0

        rows = len(grid)
        cols = len(grid[0])

        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == 2:
                    # rotten oranges are independant nodes so add to queue
                    queue.append((i, j))

                elif grid[i][j] == 1:
                    # add to fresh count 
                    fresh_oranges += 1

        if fresh_oranges == 0:
            return 0

        time = 0
        dirs = [(-1, 0), (0, -1), (0, 1), (1, 0)]

        while queue:

            size = len(queue)
            for idx in range(size):
                coordinate = queue.popleft()

                for dir in dirs:
                    r = coordinate[0] + dir[0]
                    c = coordinate[1] + dir[1]

                    if r >= 0 and r < rows and c >= 0 and c < cols and grid[r][c] == 1:
                        grid[r][c] = 2
                        # add rotten to queue
                        queue.append((r,c))
                        fresh_oranges -= 1

            time += 1
        
        if fresh_oranges != 0:
            return -1

        return time - 1

