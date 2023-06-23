# Time and space complexity : O(m*n)
# Using BFS
from queue import Queue
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        rows = len(grid)
        columns = len(grid[0])
        print("Rows are",rows,"and columns are",columns)
        dirs = [[-1, 0], [0, -1], [1, 0], [0, 1]] #Left Up Right Down consider (x,y)
        q = Queue()
        fresh = 0 # Taking the count of fresh oranges at the begining
        # Going over the matrix to take the count of fresh and rotten oranges
        for i in range(rows):
            for j in range(columns):
                if(grid[i][j]==2): #If it is rotten then put into the queue
                    q.put([i, j])
                elif grid[i][j]==1: #If it is not rotten; increase the fresh count
                    fresh+=1
        time =0
        if fresh ==0:
            return 0 
        while not q.empty():
            size = q.qsize()
            for i in range(size):
                curr = q.get()      #Getting the current element in the queue
                for dir in dirs:    #Finding all the neighbouring elements of curr
                    nr = dir[0]+curr[0]
                    nc = dir[1]+curr[1]
                    if(nr>=0 and nc>=0 and nr<rows and nc<columns and grid[nr][nc]==1): #If the neighbour is in bounds and is fresh
                        q.put([nr,nc])          # Add it to queue
                        grid[nr][nc] = 2        # Make the orange as rotten
                        fresh-=1                # Reduce the fresh count
            time+=1 #Increase the time for next level 
        if fresh==0:
            return time-1
        else:
            return -1              



