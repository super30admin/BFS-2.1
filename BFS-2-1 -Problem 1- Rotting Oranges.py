"""
FAANMG Problem #63 {Medium}

994. Rotting Oranges

Time Complexity : O(M*N)


Space Complexity : O(M*N)


Did this code successfully run on Leetcode : Yes

BFS Solution

@name: Rahul Govindkumar_RN27JUL2022
"""

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        
        if not grid or len(grid)==0:
            return 0
        
        
        q = collections.deque()
        
        time=0
        fresh=0
        
        rows = len(grid)
        cols=len(grid[0])
        
        #Iterating the grid to store the fresh and rotten oranges
        for r in range(rows):
            for c in range(cols):
                #Counting the fresh oranges
                if grid[r][c] == 1:
                    fresh +=1
                
                #Adding rotten oranges to the queue
                if grid[r][c] == 2:
                    q.append([r,c])
        
        #When there is no Fresh oranges
        if(fresh==0):
            return 0
        
       
        directions = [[0,1], [0,-1], [-1,0], [1,0]]
        while q :
            size = len(q)
            
            for i in range(size):
                r,c= q.popleft()
               
                
                for dr, dc in directions:
                    #new adjacent rows
                    row = dr + r
                    col = dc + c
                    
                    #if new row and col is inbound and Fresh: then malke it rotten 
                    if( 0 <= row < rows and 0 <= col < cols and grid[row][col] ==1):
                        grid[row][col] = 2
                        fresh -=1
                        if(fresh ==0):
                            return time + 1
                        q.append([row,col])
            time +=1
         
        if(fresh==0):
            return time-1
        else:
            return -1
            
"""
FAANMG Problem #63 {Medium}

994. Rotting Oranges

Time Complexity : O(m^2 * n^2)


Space Complexity : O(M*N)


Did this code successfully run on Leetcode : Yes

DFS Solution

@name: Rahul Govindkumar_RN27JUL2022
                    
"""

class Solution:
    def dfs(self,grid, r, c, time, rows, cols):
        #base
        #Check if empty cell or the row and col is out of bound
        if( 0 > r or r == rows or 0 > c or c == cols or grid[r][c] ==0 ):
            return
        
        #if the cell is not fresh and the time present in the cell is less than the curr time i.e  already processed
        if(grid[r][c] != 1 and grid[r][c] < time):
            return
        
        
        #logic
        grid[r][c] = time
        
        #adding the directions to the current grid cell and calling the dfs
        for dr, dc in self.directions:
            row = dr + r
            col = dc + c
            
            self.dfs(grid, row, col, time+1, rows, cols)
        
        
        
    def orangesRotting(self, grid: List[List[int]]) -> int:
        
        self.directions = [[0,1], [0,-1], [-1,0], [1,0]]
        
        if not grid or len(grid)==0:
            return 0
        
        rows = len(grid)
        cols=len(grid[0])
        
        #Iterating the grid to store the fresh and rotten oranges
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] ==2:
                    self.dfs(grid, r, c, 2, rows, cols)
        
        maxT = 0
        for r in range(rows):
            for c in range(cols):
                
                if(grid[r][c] == 1):
                    return -1
                
                if(grid[r][c] > 0):
                    maxT = max(maxT, grid[r][c] - 2)
                    
        return maxT
                    
                    
        
                           
                
            
                    
                
        
        