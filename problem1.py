from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
       
        allfreshcount=0
        allrotten=deque()
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]==1:
                    allfreshcount+=1
                if grid[i][j]==2:
                    allrotten.append([i,j])
        count=0
        dirs=[(-1,0),(0,-1),(1,0),(0,1)]
        
        if allfreshcount==0:
            return 0
        while(len(allrotten)>0):
            sz=len(allrotten)
            for i in range(sz):
                r,c=allrotten.popleft()
                for r1,c1 in dirs:
                    xr=r+r1
                    xc=c+c1
                    if (0<=xr<len(grid) and 0<=xc<len(grid[0]) and grid[xr][xc]==1):
                        grid[xr][xc]=2
                        allrotten.append([xr,xc])
                        allfreshcount-=1
            count+=1
        
        if allfreshcount>0:
            return -1
        return count-1
    #Time O(n*m)
    #Space O(n*m)
                
                        
                
