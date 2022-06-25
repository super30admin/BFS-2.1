#TC:O(m*n)
#SC:O(m*n) as we will be moving all the elements in the queue
class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        q=[]
        col=len(grid[0])
        row=len(grid)
        dir1=[[-1,0],[0,-1],[1,0],[0,1]]
        fresh=0
        for i in range(row):
            for j in range(col):
                if grid[i][j]==2:
                    q.append([i,j])
                if grid[i][j]==1:
                    fresh+=1
        t=0
        size=len(q)
        while q:
            if(size==0): 
                t+=1
                size=len(q)
            curr=q.pop(0)
            size-=1
            
                
            for i in range(len(dir1)):
                
                if row>curr[0]+dir1[i][0]>=0 and col>curr[1]+dir1[i][1]>=0:
                    if grid[curr[0]+dir1[i][0]][curr[1]+dir1[i][1]]==2 or grid[curr[0]+dir1[i][0]][curr[1]+dir1[i][1]]==0:
                        continue
                    elif grid[curr[0]+dir1[i][0]][curr[1]+dir1[i][1]]==1:
                        q.append([curr[0]+dir1[i][0],curr[1]+dir1[i][1]])
                        grid[curr[0]+dir1[i][0]][curr[1]+dir1[i][1]]=2
                        fresh-=1
        print(grid)
        if fresh>0: return -1
        return t
            
'''
#TC:O(m^2*n^2)
#SC:O(1) as we will be moving all the elements in the queue
class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        #q=[]
        col=len(grid[0])
        row=len(grid)
        print(row,col)
        dir1=[[-1,0],[0,-1],[1,0],[0,1]]
        #fresh=0
        def dfs(grid,i,j,time):
            if i<0 or j<0 or i==row or j==col:return
            if grid[i][j]!=1 and grid[i][j]<time: return 
            grid[i][j]=time
            
            for k in range(len(dir1)):
                nr=i+dir1[k][0]
                nc=j+dir1[k][1]
                dfs(grid,nr,nc,time+1)
        
        for i in range(row):
            for j in range(col):
                if grid[i][j]==2:
                    dfs(grid,i,j,2)
        #print(grid)
        max1=0
        for i in range(row):
            for j in range(col):
                if grid[i][j]==1: 
                    #print(i,j) 
                    return -1
                elif grid[i][j]!=0:
                    max1=max(max1,grid[i][j]-2)
        return max1
'''