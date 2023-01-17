#BFS - TC & SC - (m*n)
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if grid == None or len(grid) == 0:
            return 0
        
        m = len(grid)
        n = len(grid[0])
        queue = deque()
        fresh = 0
        for i in range(0,m):
            for j in range(0,n):
                if grid[i][j] == 2:
                    queue.append([i,j])
                if grid[i][j] == 1:
                    fresh += 1
        
        time = 0
        if fresh == 0: return 0
        while queue:
            size = len(queue)
            for i in range(0,size):
                r, c = queue.popleft()
                if r > 0 and grid[r - 1][c] == 1: #up
                    grid[r - 1][c] = 2
                    fresh -= 1
                    queue.append([r - 1, c])
                if r < m - 1 and grid[r + 1][c] == 1: #down
                    grid[r + 1][c] = 2
                    fresh -= 1
                    queue.append([r + 1, c]) 
                if c > 0 and grid[r][c - 1] == 1: #left
                    grid[r][c - 1] = 2
                    fresh -= 1
                    queue.append([r, c - 1])
                if c < n - 1 and grid[r][c + 1] == 1: #right
                    grid[r][c + 1] = 2
                    fresh -= 1
                    queue.append([r, c + 1])
            time += 1
        if fresh == 0:
            return time - 1
        else:
            return -1

#DFS 
# TC -O(m*n)^2
# SC - O(m*n)
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if grid == None or len(grid) == 0:
            return 0
        dirs = [(1, 0),(0, 1),(-1 ,0), (0, -1)]
        m = len(grid)
        n = len(grid[0])

        def dfs(grid,r,c,time,m,n):
        #base
            if r<0 or r==m or c<0 or c==n or grid[r][c]==0:
                return
            if grid[r][c] != 1 and grid[r][c] < time:
                return

        #logic
            grid[r][c] = time
            for d in dirs:
                nr = r + d[0]
                nc = c + d[1]
                dfs(grid,nr,nc,time+1,m,n)


        for i in range(0,m):
            for j in range(0,n):
                if grid[i][j] == 2:
                    dfs(grid,i,j,2,m,n)
        max_val = 0
        for i in range(0,m):
            for j in range(0,n):
                if grid[i][j] == 1: 
                    return -1
                if grid[i][j] > 0:
                    max_val = max(max_val,grid[i][j] - 2)
        return max_val

    
     

        
        
    