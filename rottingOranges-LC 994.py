# Time Complexity = O(m * n)
# Space Complexity = O(m * n)


class Solution:
    def orangesRotting(self, grid: list[list[int]]) -> int:
        if grid == None or len(grid) == 0:
            return 0
        
        # No. of rows and cols
        m = len(grid)
        n = len(grid[0])
        
        # Declaring the variables and queue
        fresh = 0
        time = 0
        q = []
        
        # Declaring the directions array: 4 directions - up, down, right, left
        dirs = [[0, 1], [1, 0], [-1, 0], [0, -1]]
        
        # Capturing the number of fresh oranges and appending the coordinates of the rotten oranges at the start, into queue
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    fresh += 1
                    
                elif grid[i][j] == 2:
                    q.append([i, j])
                   
                
        # If there were no fresh oranges, time will be 0
        if fresh == 0:
            return 0
       
        
        while q:
            size = len(q)
            for i in range(size):
                curr = q.pop(0)
                # curr[0] = row, # curr[1] = col of rotten
                for d in dirs:
                    # d[0] = direction for row, d[1] = direction for col
                    nr = curr[0] + d[0]
                    nc = curr[1] + d[1]
                    
                    # Checking if the adjacent orange is a fresh one + Boundary conditions for row & col
                    if (nr >= 0 and nr < m and nc >= 0 and nc < n and grid[nr][nc] == 1):
                        fresh -= 1
                        q.append([nr, nc])
                        grid[nr][nc] = 2
                        

            # Increment time after each level traversal            
            time += 1
            
            
                
        # It means not all oranges can be rotten
        if fresh != 0:
            return -1
                
        return (time - 1)           # Coz our calculations are done by last level - 1
                        
                    