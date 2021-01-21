#Time: O(mxn)
#Space: O(mxn)
#leetcode: Yes

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if (grid==None or len(grid)==0):
            return 0
        fresh=0
        time=0
        q=deque()
        row=len(grid)
        columns=len(grid[0])
        for i in range(row):
            for j in range(columns):
                if(grid[i][j]==2):
                    q.append([i,j])
                elif(grid[i][j]==1):
                    fresh+=1
        if(fresh==0):
            return 0

        while(q!=deque()):
            d=[[0,1],[1,0],[-1,0],[0,-1]]
            for i in range(len(q)):
                r,c=q.popleft()
                for v in d:
                    i=r+v[0]
                    j=c+v[1]
                    if(i>=0 and i<row and j>=0 and j<columns and grid[i][j]==1):
                        q.append([i,j])
                        fresh-=1
                        grid[i][j]=2
            time+=1
 
        if (fresh!=0):
            return -1
        else:
            return time-1
            
                        
                        

                    
            
        
        
                