#Using BFS solution
#Time O(m+n)
#Space O(m*n)


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
           
        if len(grid) == 0 or not grid:
            return -1
        
        row = len(grid)
        col = len(grid[0])
        fresh = 0
        time = 0
        
        q = collections.deque()
        
        for i in range(row):
            for j in range(col):
                if grid[i][j] == 2:
                    q.append((i, j))
                    
                elif grid[i][j] == 1:
                    
                    fresh += 1
                    
        
        
        dirArr = [[0,1],[0,-1],[-1, 0],[1,0]]
        
        if fresh == 0:
            return 0
                
        while q:
            
            size = len(q)
            
            for i in range(size):
                
                curr = q.popleft()
                
                for d in dirArr:
                    
                    r = d[0]+curr[0]
                    c = d[1]+curr[1]
                    
                    if r >= 0 and r < row and c >= 0 and c < col and grid[r][c] == 1:
                        fresh -= 1
                        grid[r][c] = 2
                        q.append((r,c))
                        
                
            time +=1    
            
        
        if fresh != 0 :
            return -1
        
        return time-1
                        
