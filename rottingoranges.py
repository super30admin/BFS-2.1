#TC-O(m*n)
#SC-O(m*n)
#logic-create a list with coordinates of all rotten oranges,then for all elements in the list
#check if its neighbours are not rotten and make them rotten and once that level is completed increase time
#by 1
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        #find rotten oranges and add them to list
        fresh=0
        li = []
        time = 0
        m=len(grid)
        n=len(grid[0])
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]==2:
                    li.append((i,j))
                if grid[i][j]==1:
                    fresh+=1
        if fresh==0:
            return 0  
        while li:
            l=len(li)
            for i in range(l):
                x=li.pop(0)
                r=x[0]
                c=x[1]
                if r-1>=0 and r-1<m:
                    if grid[r-1][c]==1:
                        grid[r-1][c]=2
                        li.append((r-1,c))
                if r+1>=0 and r+1<m:
                    if grid[r+1][c]==1:
                        grid[r+1][c]=2
                        li.append((r+1,c))
                if c+1>=0 and c+1<n:
                    if grid[r][c+1]==1:
                        grid[r][c+1]=2
                        li.append((r,c+1))
                if c-1>=0 and c-1<n:
                    if grid[r][c-1]==1:
                        grid[r][c-1]=2
                        li.append((r,c-1))
            time+=1
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    return -1
        return time-1

