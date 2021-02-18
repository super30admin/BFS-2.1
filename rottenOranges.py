#TimeComplexity:O(N*M) 
#SpaceComplexity: O(N*M) space for queue if all are rotten
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if grid==None and len(grid)==0:
            return None
        queue=[]
        queue1=[]
        output=0
        fresh=0
        x,y=0,0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]==2:
                    queue.append((i,j))
                elif grid[i][j]==1:
                    fresh+=1
        dir=[[1,0],[-1,0],[0,1],[0,-1]]
        while(queue!=[]):
            size=len(queue)
            for i in range(size):
                pair=queue.pop(0)
                for dirs in dir:
                    x=pair[0]+dirs[0]
                    y=pair[1]+dirs[1]
                    if x>=0 and y>=0 and x<len(grid) and y<len(grid[0]) and grid[x][y]==1:
                        grid[x][y]=2
                        fresh-=1
                        queue.append((x,y))
            output+=1
        if fresh!=0:
            return -1
        if output>0:
            return output-1
            
        return output
                        
                        
                        
                
                
                