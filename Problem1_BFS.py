# Time complexity : O(n*m)
# Space complexity : O(n*m)
# Leetcode : Solved and submitted

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        # return 0 if the grid is empty
        if not grid or len(grid) == 0:
            return 0
        # direction set to check the 4 neighbors of each cell
        dirs = [(0,1),(1,0),(-1,0),(0,-1)]
        rows = len(grid)
        cols = len(grid[0])
        fresh = 0
        
        q = deque([])
        # calculate the fresh oranges, and add the rotten oranges to the queue
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == 2:
                    q.append((i,j))
                elif grid[i][j] == 1:
                    fresh += 1
        # initialize time to 0 and check if fresh is 0, then we return 0 as there are no fresh ones to rot
        time = 0
        if fresh == 0:
            return 0
   # start traversing until queue is empty     
        while q:
        # at each level, we process each element in the queue
            for i in range(len(q)):
                # popping the queue would give us the row and col
                ro,co = q.popleft()
                # check for neighbor in each direction
                for di in dirs:
                    r = di[0] + ro
                    c = di[1] + co
                    # check for boundaries and then for fresh oranges
                    if r >= 0 and r < rows and c >=0 and c < cols and grid[r][c] == 1:
                        # if fresh found, make it rotten, decrement the fresn
                        # check if fresh is 0, then return the time +1
                        # add the rotten one to the queue
                        grid[r][c] = 2
                        fresh -= 1
                        if fresh == 0:
                            return time + 1
                        q.append((r,c))
            # increment the timer after each level
            time += 1
        # return -1 if there remains fresh ones after processing all the oranges
        return -1
        
