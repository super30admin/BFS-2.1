#Time complexity: O((mn)^2)
#Space complexity: O(nm)
from collections import deque


class Solution:
    def orangesRotting(self, grid) -> int:
        dirs=[(-1,0),(1,0),(0,1),(0,-1)]
        q=deque()
        m,n=len(grid),len(grid[0])
        steps,fresh_count=0,0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 2:
                    q.append((i,j))
                elif grid[i][j]==1:
                    fresh_count+=1
           
        if fresh_count==0:
            return 0
        
        while q:
            length=len(q)
            for i in range(length):
                row,col=q.popleft()
                for d in dirs:
                    r,c= row+d[0],col+d[1]
                    if r>=0 and r< m and c >=0 and c<n and grid[r][c]==1:
                        q.append((r,c))
                        fresh_count-=1
                        grid[r][c]=2
            steps+=1
        if fresh_count==0:
            return steps-1
        return -1
            
            
        
