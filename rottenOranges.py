#bfs
#Time Complexity: 
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        #       up    left   down  right
        dirs=[[-1,0],[0,-1],[1,0],[0,1]]
        m=len(grid)
        n=len(grid[0])
        if grid==None or len(grid)==0:
            return -1
        q=deque()
        fresh=0
        for i in range(m):
            for j in range(n):
                if grid[i][j]==2:
                    q.append((i,j))
                elif grid[i][j]==1:
                    fresh+=1
        if fresh==0: return 0
        time=0
        while q:
            count=0
            size=len(q)
            #Processing levels
            for i in range(size):
                curr=q.popleft()
                for direction in dirs:
                    neighbor_row=curr[0]+direction[0]
                    neighbor_col=curr[1]+direction[1]
                    #Check bounds
                    if neighbor_row>=0 and neighbor_col>=0 and neighbor_row<m and neighbor_col<n and grid[neighbor_row][neighbor_col]==1:
                        grid[neighbor_row][neighbor_col]=2
                        fresh-=1
                        q.append((neighbor_row,neighbor_col))
                        count+=1
                        
            time+=1
        if fresh!=0:
            return -1
        return time-1
            
 #Dfs
#Time Complexity: O((m**2)*(n**2))
#Space Complexity: O(m*n)
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        #       up    left   down  right
        self.dirs=[[-1,0],[0,-1],[1,0],[0,1]]
        self.m=len(grid)
        self.n=len(grid[0])
        if grid==None or len(grid)==0:
            return -1
        q=deque()
        fresh=0
        for i in range(self.m):
            for j in range(self.n):
                if grid[i][j]==2:
                    self.dfs(grid,i,j,2)
        maximum=0
        for i in range(self.m):
            for j in range(self.n):
                if grid[i][j]==1:
                    return -1
                elif grid[i][j]!=0:
                    maximum=max(maximum, grid[i][j]-2)
        return maximum
        
    def dfs(self, grid, row, col, time):
        #base case
        #checking bounds:
        if row<0 or col<0 or row==self.m or col==self.n:
            return 
        if grid[row][col]!=1 and grid[row][col]<time:
            return
            
        #logic
        grid[row][col]=time
        for dir in self.dirs:
            nr=row+dir[0]
            nc=col+dir[1]
            self.dfs(grid, nr, nc, time+1)
            
            
        
        
        
        
                        
                    
                    
                    
                               
                    
                    
                    
            