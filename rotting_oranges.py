// Time: O(n*m)
// Space: O(n*m)
// Passed on Leetcode: Yes
// Approach: Make use of BFS queue to keep track of rotten oranges in one state and keep coverting fresh to rotten as we iterate 
// the neighbors of the queue elements. Also keep updating the time after each level.

class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        if(len(grid)==0 or len(grid[0])==0):
            return(-1)
        time=0
        
        n=len(grid)
        m=len(grid[0])
        
        fresh=0
        queue=[]
        
        for i in range(n):
            for j in range(m):
                if(grid[i][j]==2):
                    queue.append((i,j))
                if(grid[i][j]==1):
                    fresh+=1
        
        dir=[[0,-1],[0,1],[1,0],[-1,0]]
        
        while(queue):
            
            size=len(queue)
            print(queue)
            for i in range(size):
                popped=queue.pop(0)
            
                for d in dir:
                    x=popped[0]+d[0]
                    y=popped[1]+d[1]

                    if(x>=0 and x<n and y>=0 and y<m and grid[x][y]==1):
                        grid[x][y]=2
                        fresh-=1
                        queue.append((x,y))
                
            time+=1
        
        if(fresh!=0):
            return(-1)
        
        if(time>0):
            return(time-1)
        else:
            return(time)
                    
        
        
        
        
                
                
        
        