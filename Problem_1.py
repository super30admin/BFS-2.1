# Time Complexity : O(M * N)
# Space Complexity : O(M * N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Is a hard problem

from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        
        dirs = [(-1, 0), (1, 0), (0, 1), (0, -1)]
        
        numRows = len(grid)
        numCols = len(grid[0])
        
        q = deque([])
        freshOranges = 0
        
        for i in range(numRows):
            for j in range(numCols):
                if grid[i][j] == 1:
                    freshOranges += 1
                elif grid[i][j] == 2:
                    q.append((i, j))
        
        q.append((-1, -1)) 
        
        time = 0 
        while q:
            row, col = q.popleft()
            if row == -1:
                time += 1 
                if q:
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
    