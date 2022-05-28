# Time Complexity: O(m^2n^2)
# Space Complexity: O(mn)

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if grid is None and len(grid) == 0:
            return 0
        
        dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        m = len(grid)
        n = len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    self.dfs(grid,i,j,m,n,dirs,2)
        
        print(grid)
        ma = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    return -1
                else:
                    ma = max(ma, grid[i][j]-2)
        
        return ma
        
    def dfs(self,grid,i,j,m,n,dirs,time):
        if i < 0 or i >= m or j < 0 or j >= n or grid[i][j] == 0:
            return
        if grid[i][j] > 1 and grid[i][j] < time:
            return
        else:
            grid[i][j] = time
            for di in dirs:
                r = di[0] + i
                c = di[1] + j
                self.dfs(grid,r,c,m,n,dirs,grid[i][j]+1)


# Time Complexity: O(mn)
# Space Complexity: O(mn)

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if grid is None and len(grid) == 0:
            return 0
        
        dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        m = len(grid)
        n = len(grid[0])
        q = list()
        fresh = 0
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    fresh += 1
                elif grid[i][j] == 2:
                    q.append([i,j])
        
        if fresh == 0:
            return 0
        
        print(fresh, len(q))
        
        time = 0
        while len(q) != 0:
            size = len(q)
            for i in range(size):
                curr = q.pop(0)
                for di in dirs:
                    r = curr[0] + di[0]
                    c = curr[1] + di[1]
                    if r >= 0 and r < m and c >= 0 and c < n and grid[r][c] == 1:
                        grid[r][c] = 2
                        q.append([r,c])
                        fresh -= 1
            time += 1
        
        if fresh == 0:
            return time - 1
        return -1