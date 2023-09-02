# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if not grid:
            return 0
        m=len(grid)
        n=len(grid[0])
        dirs=[(-1,0),(0,-1),(0,1),(1,0)]
        q=deque()
        fresh=0
        time=0
        for i in range(m):
            for j in range(n):
                if grid[i][j]==1:
                    fresh+=1
                elif grid[i][j]==2:
                    q.append((i,j))
        if fresh==0:
            return 0
        while q:
            qLen=len(q)
            for i in range(qLen):
                curr=q.popleft()
                for dir in dirs:
                    nr=dir[0]+curr[0]
                    nc=dir[1]+curr[1]
                    if nr>=0 and nr<m and nc>=0 and nc<n and grid[nr][nc]==1:
                        grid[nr][nc]=2
                        q.append((nr,nc))
                        fresh-=1
                if fresh==0:
                    return time+1
            time+=1

        return -1


        

