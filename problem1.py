'''
994. Rotting Oranges

APPROACH 1: BFS
TIME COMPLEXITY: O(M*N)
SPACE COMPLEXITY: O(M*N)
LEETCODE: YES
DIFFICULTIES: A bit. After the class.

APPROACH 2: DFS
TIME COMPLEXITY: O(M*N) ** 2
SPACE COMPLEXITY: O(M*N)
LEETCODE: YES
DIFFICULTIES: A bit. After the class.

'''



from collections import deque
class Solution:
    def orangesRotting(self, ggrid: List[List[int]]) -> int:
        global dirs, grid
        grid = ggrid
        dirs = [(-1,0), (1,0), (0,1), (0,-1)]
        
        # BFS 
        def approach1():
            global grid, dirs
            two = [] # stores original location of rotten oranges
            
            m, n = len(grid), len(grid[0])
            
            for i in range(0, m):
                for j in range(0, n):
                    if grid[i][j] == 2:
                        two.append((i, j))
                    elif grid[i][j] == 1:
                        grid[i][j] = -1
            
            
            for tmp in two:
                q = deque()
                q.append(tmp)
                while len(q) != 0:
                    i, j = q.popleft()
                    for dirr, dirc in dirs:
                        nr = dirr + i
                        nc = dirc + j

                        # bound check
                        if nr >= 0 and nr < m and nc >= 0 and nc < n and grid[nr][nc] != ( 0 or 2):
                            if grid[nr][nc] == -1 or grid[i][j] + 1 < grid[nr][nc]:
                                grid[nr][nc] = grid[i][j] + 1
                                q.append((nr, nc))
            
            
            # checking for left out oranges and to get the highest value
            mmax = 0
            for i in range(0, m):
                for j in range(0, n):
                    if grid[i][j] == -1:
                        return -1
                    if grid[i][j] > 2:
                        grid[i][j] -= 2
                    elif grid[i][j] == (0 or 2):
                        continue
                    
                    if grid[i][j] > mmax:
                        mmax = grid[i][j]
                        
            
            return mmax
        
        # DFS 
        def approach2():
            # count no of 2s in grid
            global m, n, grid
            m = len(grid)
            n = len(grid[0])
            twos = []
            one_found = False
            
            for i in range(0, m):
                for j in range(0, n):
                    if grid[i][j] == 2:
                        twos.append((i,j))
                    elif grid[i][j] == 1:
                        one_found = True
            
            if not one_found: # there are no fresh apples
                return 0
            
            def dfs(r, c):
                global m, n, dirs, grid
                # base
                # base case is handled in the logic
            
                # logic
                for dr, dc in dirs:
                    nr = dr + r
                    nc = dc + c
                    
                    if nr >= 0 and nc >= 0 and nr < m and nc < n:
                        if grid[nr][nc] == 1:
                            grid[nr][nc] = grid[r][c] + 1
                            dfs(nr, nc)
                        elif grid[nr][nc] != (2 or 0) and grid[r][c] + 1 < grid[nr][nc]:
                            grid[nr][nc] = grid[r][c] + 1
                            dfs(nr, nc)
            
            for r, c in twos:
                dfs( r, c)
            
            mmax = 0
            for i in range(0, m):
                for j in range(0, n):
                    if grid[i][j] == 1:
                        return -1
                    elif grid[i][j] == (2 or 0):
                        continue
                    else:
                        mmax = max(grid[i][j], mmax) 
            
            return mmax - 2         
        
        return approach2()
        # return approach1()
    
