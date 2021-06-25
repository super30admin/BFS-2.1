# // Time Complexity : O(m*n)
# // Space Complexity : O(m*n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach

class Solution:
    def orangesRotting(self, grid):
        if grid == None or len(grid) == 0:
            return 0
        fresh = 0
        time = 0
        m = 0
        n = 0
        m = len(grid)
        n = len(grid[0])
        q = deque()

        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:     # Append Rotten oranges to the queue
                    q.append((i, j))
                if grid[i][j] == 1:
                    fresh += 1          #Calculate Total fresh ones

        dirs = [(0, 1), (0, -1), (-1, 0), (1, 0)]  # 4 direction array
        if fresh == 0:
            return 0
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                for d in dirs:
                    r = d[0] + curr[0]      #Considering 4 arrays
                    c = d[1] + curr[1]
                    #rot if fresh,
                    #Append rotten to queue
                    if r >= 0 and r < m and c >= 0 and c < n and grid[r][c] == 1:
                        grid[r][c] = 2
                        q.append((r, c))
                        fresh -= 1  #Decrement Fresh ones
            time += 1
        if fresh != 0:
            return -1
        return time - 1



