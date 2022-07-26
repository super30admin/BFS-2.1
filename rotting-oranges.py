"""
Runtime Complexity:
O(m*n) - where 'm' is the number of rows and 'n' is the number of columns. We traverse each row and column and therefore te runtime complexity is O(m*n).
Space Complexity:
O(m*n) - we use a queue and dirs 2D array. In the worst case they might endup having all the elements in it.
Yes, the code worked on leetocde.
Issues while coding - No 
"""


from queue import Queue
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if len(grid)==0:
            return 0
        fresh_oranges = 0
        q = Queue()
        
        m = len(grid)
        n = len(grid[0])
        dirs = [[0,-1],[0,1],[-1,0],[1,0]]
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    fresh_oranges+=1
                elif grid[i][j] == 2:
                    q.put([i,j])
        if fresh_oranges == 0:
            return 0
        time = 0
        
        while not q.empty():
            size = q.qsize()
            for i in range(size):
                curr = q.get()
                for dir_ in dirs:
                    nr = dir_[0]+ curr[0]
                    nc = dir_[1] + curr[1]
                    
                    if nr>=0 and nr<m and nc>=0 and nc<n and grid[nr][nc]==1:
                        q.put([nr,nc])
                        grid[nr][nc] = 2
                        fresh_oranges-=1
            time+=1
        if fresh_oranges>0:
            return -1
        else:
            return time-1
        
        