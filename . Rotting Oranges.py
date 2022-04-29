class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if(grid==None and len(grid)==0):return 0
        q=[]
        fresh=0
        m=len(grid)
        n=len(grid[0])
        dirs=[[0,1],[1,0],[0,-1],[-1,0]]
        for i in range(m):
            for j in range(n):
                if(grid[i][j]==2):
                    q.append([i,j])
                elif(grid[i][j]==1):
                    fresh+=1
        if(fresh==0):return 0
        time=0
        while(len(q)!=0):
            size=len(q)
            for i in range(size):
                curr=q.pop(0)
                for dir1 in dirs:
                    r=curr[0]+dir1[0]
                    c=curr[1]+dir1[1]
                    if(r>=0 and r<m and c>=0 and c<n and grid[r][c]==1):
                        grid[r][c]=2
                        q.append([r,c])
                        fresh-=1
            time+=1
        if(fresh!=0):return -1
        return time-1
        