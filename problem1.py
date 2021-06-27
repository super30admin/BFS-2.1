from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if not grid or len(grid)==0 or len(grid[0])==0 or not grid[0]:
            return 
        q = deque()
        count = 0
        fresh = 0
        dirs = [[1,0], [-1, 0], [0,1], [0,-1]]
        m = len(grid)
        n = len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    q.append([i,j])
                if grid[i][j] == 1:
                    fresh +=1
        if fresh == 0: return 0 # this would mean there were no fresh oranges
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                for d in dirs:
                    r = curr[0] + d[0]
                    c = curr[1] + d[1]
                    if r >=0 and r < m and c>=0 and c<n and grid[r][c] == 1:
                        q.append([r,c])
                        grid[r][c] = 2
                        fresh -=1
            count +=1
        if fresh != 0:
            return -1
        return count-1

#Time complexity is O(m*n) and space complexity is O(m*n)
#BFS approach for adding oranges after marking them rotten and pulling out of the queue at each level 