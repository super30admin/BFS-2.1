# Time Complexity: O(m*n)
# Space Complexity: O(m*n)
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        fresh=0
        time=0
        directions=[[0,1],[1,0],[-1,0],[0,-1]]
        from collections import deque
        q=deque()
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]==2:
                    q.append((i,j))
                if grid[i][j]==1:
                    fresh+=1
        if fresh==0: return 0
        while len(q)!=0:
            for i in range(len(q)):
                cur=q.popleft()
                for d in directions:
                    r=cur[0]+d[0]
                    c=cur[1]+d[1]
                    if r>=0 and c>=0 and r<len(grid) and c<len(grid[0]) and grid[r][c]==1:
                        fresh-=1
                        q.append((r,c))
                        grid[r][c]=2
            time+=1
        if fresh!=0: return -1
        return time-1
    # DFS solution
    # Time Complexity: O((m*n)**2)
    # Space Complexity: O(m*n)
    # def orangesRotting(self, grid: List[List[int]]) -> int:
    #     self.directions=[[0,1],[1,0],[-1,0],[0,-1]]
    #     maxi=0
    #     for i in range(len(grid)):
    #         for j in range(len(grid[0])):
    #             if grid[i][j]==2:
    #                 self.dfs(grid,i,j,2)
    #     for i in range(len(grid)):
    #         for j in range(len(grid[0])):
    #             if grid[i][j]==1: return -1
    #             elif grid[i][j]!=0 :
    #                 maxi=max(maxi,grid[i][j]-2)
    #     return maxi
    # def dfs(self,grid:List[List[int]],i:int,j:int,time:int):
    #     if i>=len(grid) or j>=len(grid[0]) or i<0 or j<0: return
    #     if grid[i][j]!=1 and grid[i][j]<time: return
    #     grid[i][j]=time
    #     print(grid)
    #     for d in self.directions:
    #         r=i+d[0]
    #         c=j+d[1]
    #         self.dfs(grid,r,c,time+1)
            
            
                
        