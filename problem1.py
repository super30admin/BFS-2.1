// Time Complexity : O(n*m)
// Space Complexity :O(n*m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if not grid or len(grid)==0 or not grid[0] or len(grid[0])==0:      #Check null conditions
            return 0
        queue=deque()
        fresh=0             //keep a track of fresh oranges
        n=len(grid)
        m=len(grid[0])
        
        for i in range(n):          //traverse grid and append the indices of rotton oranges and compute total fresh oranges
            for j in range(m):
                if grid[i][j]==2:
                    queue.append((i,j))
                elif grid[i][j]==1:
                    fresh+=1
                    
        level=0         //set the initial level to 0
        
        dirs=[[1,0],[-1,0],[0,1],[0,-1]]        //all the 4 directions which we need to check for fresh oranges
        
        while len(queue)!=0:    //repeat till the queue will not become empty
            
            size=len(queue)
            
            while size>0:       //traverse each level
                size-=1
                front=queue.popleft()   //pop the top element from queue
                
                for dir in dirs:        //check for the fresh oranges in all the directions 
                    i=front[0]+dir[0]
                    j=front[1]+dir[1]
                    if i>=0 and i<n and j>=0 and j<m and grid[i][j]==1: //if found the make it rotton and reduce the count of fresh oranges by 1 and also append that element in the queue
                        grid[i][j]=2
                        queue.append((i,j))
                        fresh-=1
            level+=1    //after each level increment the level by 1
        
                
        if fresh!=0:    //check for fresh oranges if found return -1
            return -1
        
        if level>0:     //othewise check the level if it is >0 =>return level-1
            return level-1
        return level    //if level==0 return level
    
