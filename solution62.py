#Time Complexity:O(mxn)
#Space Complexity:O(n)
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if not grid:                        #if the grid is empty return 0
            return 0
        m=len(grid)                         #obtain number of rows
        n=len(grid[0])                      #obtain number of columns
        fresh=0                             #keep count of fresh oranges
        d=deque()                           #declare a queue and a time variable to track time
        time=0
        for i in range(m):                  #for every orange in the grid
            row=grid[i]
            for j in range(n):
                if row[j]==2:               #if orange is rotten append its position into the queue
                    d.append([i,j])
                elif row[j]==1:             #if orange is fresh increase fresh count by one
                    fresh+=1
        if fresh==0:                        #if the fresh count remains zero return 0
            return 0
        dirs=[[0,1],[1,0],[-1,0],[0,-1]]    #directions array to obtain 4 adjacent oranges
        while d:                            #until the queue is populated
            l=len(d)                        #obtain length
            for r in range(l):              #for elements in the queue
                curr=d.popleft()            #obtain first element
                for di in dirs:
                    r=curr[0]+di[0]         #find its surrounding oranges
                    c=curr[1]+di[1]
                    if (0<=r<m and 0<=c<n):     #if surrounding orange is in grid
                        orange=grid[r]
                        if orange[c]==1:        #if orange is fresh
                            orange[c]=2         #convert it to rotten
                            fresh-=1            #decrement fresh orange count by one
                            d.append([r,c])     #append the position of rotten orange to queue
            time+=1                             #increment time by one
        if fresh>0:                             #if there are fresh oranges remaining return -1 else return time
            return -1
        return time-1