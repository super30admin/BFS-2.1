
# BFS 
# Time Complexity - O(mn)
# Space Complexity - O(mn)


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if not grid: 
            return 0
        directions = [[-1,0],[0,-1],[1,0],[0,1]]
        m = len(grid)
        n = len(grid[0])
        fresh = 0
        time = 0
        q = []

        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2 : 
                    q.append([i,j])
                if grid[i][j] == 1 :
                    fresh += 1 

        if fresh == 0 : 
            return 0
        while q : 
            size = len(q)
            for i in range(size):
                curr = q.pop(0)
                for each in directions: 
                    r = curr[0] + each[0]
                    c = curr[1] + each[1]

                    if r >= 0 and r < m and c >= 0 and c < n and grid[r][c] == 1 : 
                        grid[r][c] = 2 
                        q.append([r,c])
                        fresh -= 1 
                
            time += 1 
 
        if fresh != 0 : 
            return -1 
        else : 
            return time - 1


#DFS 
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if not grid: 
            return 0
        self.directions = [[-1,0],[0,-1],[1,0],[0,1]]
        m = len(grid)
        n = len(grid[0])
        result = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2 : 
                    self.dfs(grid,i,j,2, m, n)


        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1 : 
                    return -1 

                if grid[i][j] > 2 : 
                    grid[i][j] = grid[i][j]-2
                    result = max(result,grid[i][j])

        return result

               
    def dfs(self,grid,i,j,time, m, n):
        if i < 0 or i == m or j < 0 or j == n or grid[i][j] == 0 : 
            return 
        if grid[i][j]!= 1 and grid[i][j] < time : 
            return

       
        grid[i][j] = time 
        for each in self.directions: 
            r = i + each[0]
            c = j + each[1] 
            self.dfs(grid,r,c,time+1, m, n)