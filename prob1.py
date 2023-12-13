# Time Complexity : O(M*N) as we got through all matrix elements in 2 for loops
# Space Complexity : O(M*N) for the queue
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : made the mistake of popping the element out of the level
# Your code here along with comments explaining your approach

# implement bfs, first keep a count of the fresh oranges, 
# and add rotten oranges to queue
# if at this point, fresh=0, return 0 as no oranges there to rot
# now from queue, keep track of size as we need the level here
# in that level find neighboring oranges in all 4 directions and if they 
# are fresh, rot them , add to queue and reduce fresh by 1
# in the end if fresh > 0, return -1, else return (time-1) as we increment the time 
# one extra after the last level 


from collections import deque

class Solution:

    def orangesRotting(self, grid):

        if grid is None or len(grid) == 0:
            return 0
        m, n = len(grid), len(grid[0])

        fresh = 0
        time = 0
        q = deque()
            
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    fresh += 1
                if grid[i][j] == 2:
                    q.append([i, j])
            
        if fresh == 0:
            return 0
            
        dirs = [[-1, 0], [0, -1], [1, 0], [0, 1]]

        while len(q) != 0:
            size = len(q)
                
            for i in range(size):
                curr = q.popleft()
                for d in dirs:
                    r = curr[0] + d[0]
                    c = curr[1] + d[1]
                    if r >= 0 and c >= 0 and r < m and c < n and grid[r][c] == 1:
                        grid[r][c] = 2
                        fresh -= 1
                        q.append([r, c])
            time += 1
            
        if fresh > 0:
            return -1
        return (time -1)
        
