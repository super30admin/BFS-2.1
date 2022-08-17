############## BFS Solugtion, Optimal O(m*n) time and O(m*n) space #############
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if not grid:
            return -1
        m = len(grid)
        n = len(grid[0])
        
        q = collections.deque()
        fresh = 0
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    q.appendleft([i,j])
                if grid[i][j] == 1:
                    fresh += 1
        dirs = [[-1,0],[0,-1],[1,0],[0,1]]
        time = 0
        if not fresh:
            return 0 # No fresh oranges to put in the queue
        while q:
            size = len(q)
            
            for i in range(size):
                curr = q.pop()
                
                for d in dirs:
                    r = curr[0] + d[0]
                    c = curr[1] + d[1]
                    # print(curr)
                    # print(r,c)
                    if(r >= 0 and r<m and c>=0 and c<n and grid[r][c]==1):
                        grid[r][c] = 2
                        fresh -= 1
                        q.appendleft([r,c])
            time += 1
        
        if fresh!= 0:
            return -1
        
        return time-1
    
############## DFS Solution, Optimal O(m^2 * n^2) time and O(m*n) space #############
# class Solution:
#     def orangesRotting(self, grid: List[List[int]]) -> int:
#         if not grid:
#             return -1
#         m = len(grid)
#         n = len(grid[0])
        
#         fresh = 0
#         dirs = [[-1,0],[0,-1],[1,0],[0,1]]
        
#         def dfs(r,c,time,m,n):
        
#             if r < 0 or r >= m or c < 0 or c >= n or grid[r][c] == 0:
#                 return
#             if grid[r][c] != 1 and grid[r][c] < time:
#                 return
            
#             # print(grid)
#             # print(grid[r][c])

#             grid[r][c] = time

#             for d in dirs:
#                 nr = r + d[0]
#                 nc = c + d[1]

#                 dfs(nr,nc,time+1,m,n)
#         ####### End of dfs function #########
        
#         for i in range(m):
#             for j in range(n):
#                 if grid[i][j] == 2:
#                     dfs(i,j,2,m,n)
#         maxi = 0
#         for i in range(m):
#             for j in range(n):
#                 if grid[i][j] == 1:
#                     # print('here')
#                     return -1
#                 if grid[i][j] > 0:
#                     maxi = max(maxi,grid[i][j]-2)
#         return maxi
        
    