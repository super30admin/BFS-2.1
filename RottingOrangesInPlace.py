

'''We can use time stamp to mark the current rotten oranges.'''


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        
        dirs = [(-1, 0), (1, 0), (0, 1), (0, -1)]
        
        numRows = len(grid)
        numCols = len(grid[0])
        
        timeStamp = 2
        nextIter = True
        while nextIter:
            nextIter = False
            for row in range(numRows):
                for col in range(numCols):
                    if grid[row][col] == timeStamp:
                        for d in dirs:
                            adjRow, adjCol = row + d[0], col + d[1]
                            if 0 <= adjRow < numRows and 0 <= adjCol < numCols:
                                if grid[adjRow][adjCol] == 1:
                                    nextIter = True # we found a new rot. Hence, we must iter again.
                                    grid[adjRow][adjCol] = timeStamp + 1
            
            # intuitively add minute when iteration is done.
            # however, we count extra iteration because we iter again every time we find a new rotten orange.
            # however, this find could be the last rotten orange.
            # in this case we have gone through an extra increment. This extra increment is invariant.
            # hence, actual time = timeStamp - 2 (that was our zero) - 1 (extra increment).
            timeStamp += 1
        
        # check if the grid is all rotten at the end
        for i in range(numRows):
            for j in range(numCols):
                if grid[i][j] == 1:
                    return -1
        return timeStamp - 3 

        # because my timestamp is incremented at the end of the iteration. I count one extra minute.
        # Hence, reduce by 3.