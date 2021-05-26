from queue import Queue

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        q = Queue()
        fresh = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]==2:
                    q.put((i,j))
                elif grid[i][j]==1:
                    fresh = fresh + 1
        dirs =[[-1,0],[1,0],[0,1],[0,-1]]
        time = 0
        if fresh == 0:
            return time
        while(q.empty()!=True):
            size = q.qsize()
            for l in range(size):
                r,c = q.get()
                for k in dirs:
                    row = r + k[0]
                    column = c + k[1]
                    if((row>=0 and row<len(grid) and (column>=0 and column<len(grid[0])) and    grid[row][column]==1)):
                        grid[row][column]=2
                        q.put((row,column))
                        fresh = fresh - 1
            time = time + 1
        if fresh == 0:
            return time-1
        return -1






        
