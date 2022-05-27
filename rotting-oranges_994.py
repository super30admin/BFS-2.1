#Approach: BFS
#Counting total fresh and checking rotten and adding it to queue, for every level maintain time and reduce fresh count
#Time Complexity O(MN) M= rows, N=columns of grod
#Space Complexity O(MN)
#It successfully runs on leetcode   
from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if len(grid) == 0: return 0
        q = deque()
        r,c = len(grid), len(grid[0])
        direction = {(0,1),(0,-1),(1,0),(-1,0)}
        fresh = 0
        for i in range(r):
            for j in range(c):
                if grid[i][j]==2:
                    q.append((i,j))
                if grid[i][j]==1:
                    fresh+=1
        time = 0
        if fresh==0: return 0
        while q:
            for _ in range(len(q)):
                curr, curc = q.popleft()
                for x,y in direction:
                    if curr+x>=0 and curr+x<r and curc+y>=0 and curc+y<c:
                        nr = curr + x
                        nc = curc + y
                        if grid[nr][nc]==1:
                            grid[nr][nc]=2
                            q.append((nr,nc))
                            fresh -=1
                            
            time+=1 
            
        if fresh!=0: return -1              
        return time-1
                    
#Approach: DFS
#DFS starting with time as 2 and changing all neighbours to 2+1 and then doing dfs for all nodes
#Time Complexity O(M^2*N^2) M= rows, N=columns of grod
#Space Complexity O(MN)
#It successfully runs on leetcode    

from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if len(grid) == 0: return 0
        self.r,self.c = len(grid), len(grid[0])
        self.direction = {(0,1),(0,-1),(1,0),(-1,0)}
        for i in range(self.r):
            for j in range(self.c):
                if grid[i][j]==2:
                    self.dfs(grid,i,j,2)
        maxi = 0
        for i in range(self.r):
            for j in range(self.c):
                if grid[i][j]==1: return -1
                maxi= max(maxi,grid[i][j]-2)
                
        return maxi
        
    def dfs(self,grid, i,j,time):
            if i<0 or i==self.r or j<0 or j==self.c or grid[i][j]== 0:
                return
            if grid[i][j] > 1 and grid[i][j] < time: return
            else:
                grid[i][j]=time
                for x,y in self.direction:
                    self.dfs(grid, i+x, j+y, grid[i][j]+1)
 