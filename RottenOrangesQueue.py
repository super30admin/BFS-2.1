# Time Complexity : O(M * N)
# Space Complexity : O(M * N)
# M, N are numROWS and numCOLS respectively.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        
        dirs = [(-1, 0), (1, 0), (0, 1), (0, -1)]
        
        numRows = len(grid)
        numCols = len(grid[0])
        
        q = deque([])
        freshOranges = 0 # will keep count to check if all oranges are rotten in the end
        
        for i in range(numRows): # need to put all possible starts of my BFS in queue at minute 0
            for j in range(numCols):
                if grid[i][j] == 1:
                    freshOranges += 1
                elif grid[i][j] == 2:
                    q.append((i, j))
        
        q.append((-1, -1)) # use this marker for time
        
        time = 0 
        while q:
            row, col = q.popleft()
            if row == -1:
                time += 1 
                # when 0th minute is over our time becomes 1. Hence, we are counting 1 extra minute.
                # there for return time - 1
                if q:
                    # adding a time marker only when there is something in the queue
                    # because there is another minute that is going to occur
                    # also avoids infinite loop
                    q.append((-1, -1))
            else:
                for d in dirs:
                    adjRow, adjCol = row + d[0], col + d[1]
                    if 0 <= adjRow < numRows and 0 <= adjCol < numCols:
                        if grid[adjRow][adjCol] == 1:
                            freshOranges -= 1
                            q.append((adjRow, adjCol))
                            grid[adjRow][adjCol] = 2

        if freshOranges == 0:
            return time - 1
        else:
            return -1
    