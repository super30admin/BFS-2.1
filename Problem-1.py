# 994. Rotting Oranges

'''
Leetcode all test cases passed: Yes
Solution:
    def orangesRotting(self, grid):
        m is the no of rows in the grid
        n is the no of cols in the grid
        Time Complexity: O(m * n) 
        Space Complexity: O(m * n)
'''
class Solution:
    def orangesRotting(self, grid):
        r = [(-1,0),(1,0),(0,-1),(0,1)]
        rows = len(grid)
        cols = len(grid[0])
        count = 0
        rotten_count = 0
        fresh_count = 0

        
        queue = []
        for m in range(rows):
            for n in range(cols):
                if grid[m][n] == 2:
                    queue.append((m,n,0))
                    
                elif grid[m][n] == 1:
                    fresh_count += 1 
        while queue:
                a,b,c = queue.pop(0)
                for x,y in r:
                    if a+x >= 0 and b+y >= 0 and a+x < rows and b+y < cols and grid[a+x][b+y] == 1:
                        grid[a+x][b+y] = 2
                        fresh_count -= 1
                        queue.append((a+x,b+y,c + 1))
                count = max(c,count)
        
        return count if fresh_count == 0 else -1
