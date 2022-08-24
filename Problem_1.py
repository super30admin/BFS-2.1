"""
Problem 1

Rotting Oranges(https://leetcode.com/problems/rotting-oranges)
"""

from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        """
        Using BFS, taking  ALL the rotten oranges in the queue first and then processing them one by one. we will
        maintain the counnt of fresh oranges and every time it gets rotten we will dec it.
        Time Complexity : O(M*N), size of the grid
        Space Complexity : O(M*N), size of the grid
        """
        m = len(grid)
        n = len(grid[0])
        q = deque()
        time = 0
        fresh_count = 0
        # initializing the four direction : down, right, up, left
        directions = [(1, 0),(0, 1),(-1 ,0), (0, -1)]
        
        for i in range(m):
            for j in range(n):
                # adding all the rotten oranges in the queue
                if grid[i][j] == 2:
                    q.append((i,j))
                # maintaing the count of fresh oranges
                elif grid[i][j] == 1:
                     fresh_count += 1
        if  fresh_count == 0: return 0               
        while q:
            _size = len(q)
            
            for i in range(_size):
                curr = q.popleft()
                for d in directions:
                    nr = d[0] + curr[0]
                    nc = d[1] + curr[1]
                    
                    # checking boundary conditions
                    if nr >= 0 and nr < m and nc >= 0 and nc < n and grid[nr][nc] == 1:
                        grid[nr][nc] = 2
                        fresh_count -= 1
                        
                        if fresh_count == 0:
                            return time + 1
                        
                        q.append((nr,nc))
                        
            time += 1
            
        return -1


# Approach - 2

from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        """
        DFS approach, first by changing the time at each rotten orange by time + 1 and then recursively reducing
        it by 2
        Tinme Complexity : O(M^2 * N^2)
        Space Complexity : O(M*N)M=row, N=col
        """
        m = len(grid)
        n = len(grid[0])
        max_value = 0
    
        # initializing the four direction : down, right, up, left
        directions = [(1, 0),(0, 1),(-1 ,0), (0, -1)]
        
        def dfs_helper(grid, r, c, time, m, n):
            # base case
            if (r < 0 or r == m or c < 0 or c==n or grid[r][c]==0): return
            if (grid[r][c] != 1 and grid[r][c] < time) : return
            
            # logic 
            grid[r][c] = time
            for d in directions:
                nr = d[0] + r
                nc = d[1] + c
                dfs_helper(grid, nr, nc, time + 1, m, n)
                
            
        
        for i in range(m):
            for j in range(n):
                # adding all the rotten oranges in the queue
                if grid[i][j] == 2:
                    dfs_helper(grid, i, j, 2, m, n)
                    
               
        for i in range(m):
            for j in range(n):
                
                if grid[i][j] == 1: return -1
                if grid[i][j] > 0 : 
                    max_value = max(max_value, grid[i][j] -2)
                    
        return max_value
        
                        
                    
                
        
                        
                



                
            
                        
                
