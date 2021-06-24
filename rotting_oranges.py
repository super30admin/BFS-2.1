class Solution:
    '''
    Time Complexity: O(n) since we go through the grid using a bfs
    Space Complexity: O(1) this is the in place solution
    '''
    def orangesRotting(self, grid: List[List[int]]) -> int:
        
        # get the length of rows and columns
        rows, cols = len(grid), len(grid[0])
        
        # make a map of all possible directions
        directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]
        
        def rotting_simulation(timestamp):
            # run this simulation to see if you should continue running the rotting sim
            cont = False
            
            for r in range(rows):
                for c in range(cols):
                    
                    if grid[r][c] == timestamp:
                        
                        for d in directions:
                            n_row = r + d[0]
                            
                            n_col = c + d[1]
                            
                            if rows > n_row >= 0 and cols > n_col >= 0:
                                if grid[n_row][n_col] == 1:
                                    
                                    grid[n_row][n_col] = timestamp + 1
                                    cont = True
            return cont
        
        t = 2
        
        while rotting_simulation(t):
            t += 1
            
        for r in grid:
            for c in r:
                if c == 1: return -1 # found a fresh orange
        
        return t - 2
        