#BFS
#Time Complexity: O(m*n)
#Space Complexity: O(m*n)
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        row = len(grid)
        col = len(grid[0])
        dirs = [[-1,0],[0,-1],[1,0],[0,1]]
        fresh = 0
        queue = []
        time = 0
        for i in range(row):
            for j in range(col):
                if grid[i][j] == 1:
                    fresh += 1
                if grid[i][j] == 2:
                    queue.append([i,j])
                    
        if fresh == 0:
            return 0
                    
        while queue:
            size = len(queue)
            for i in range(size):
                curr = queue.pop(0)
                for d in dirs:
                    r = d[0] + curr[0]
                    c = d[1] + curr[1]
                    if r<0 or c < 0 or r >= row or c >=col or grid[r][c] != 1:
                        continue
                   
                    queue.append([r,c])
                    grid[r][c] = 2
                    fresh -=1
                        
            time +=1
        if fresh !=0:
            return -1
        else:
            return time - 1


#DFS
#Time Complexity: O(m*n)
#Space Complexity: O(m*n)
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        row = len(grid)
        col = len(grid[0])
        self.dirs = [[-1,0],[0,-1],[1,0],[0,1]]
        for i in range(row):
            for j in range(col):
                if grid[i][j] == 2:
                    self.helper(grid,row,col,i,j,2)
        time = 2
        for i in range(row):
            for j in range(col):
                if grid[i][j] == 1:
                    return -1
                time = max(time,grid[i][j])
                
        return time - 2
    def helper(self,grid,row,col,i,j,time):
        #base
        if i < 0 or j < 0 or i>=row or j >=col or grid[i][j] == 0:
            return None
        if grid[i][j] > 1 and grid[i][j] < time:
            return None
        grid[i][j] = time
        #logic
        for k in self.dirs:
            r = k[0] + i
            c = k[1] + j
            
            self.helper(grid,row,col,r,c,time+1)