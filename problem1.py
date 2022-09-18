'''
994. Rotting Oranges

TIME COMPLEXITY: O(M*N)
SPACE COMPLEXITY: O(M*N)
APPROACH: BFS
LEETCODE: YES
DIFFICULTIES: A bit. After the class.

'''



from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        
        dirs = [(-1,0), (1,0), (0,1), (0,-1)]
        
        # BFS 
        def approach1(grid, dirs):
            
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
        
        return approach1(grid, dirs)
