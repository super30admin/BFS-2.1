from typing import List
import queue
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if grid == None or len(grid) == 0 or len(grid[0]) == 0 or grid[0] == None:
            return 0
        fresh = 0
        time = 0
        m = len(grid)
        n = len(grid[0])
        q = queue.Queue()
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    q.put([i,j])
                if grid[i][j] == 1:
                    fresh += 1

        if fresh == 0:
            return 0
        
        dirs = [[-1,0], [1,0], [0,-1], [0,1]]
        
        while not q.empty():
            size = q.qsize()
            
            for i in range(size):
                curr = q.get()

                for direx in dirs:
                    r = curr[0] + direx[0]
                    c = curr[1] + direx[1]
                    if r >= 0 and c >=0 and r < m and c < n and grid[r][c] == 1:
                        grid[r][c] = 2
                        q.put([r,c])
                        fresh -= 1
                        
            time += 1
            
        if fresh != 0:
            return -1
        return time - 1

obj = Solution()
print(obj.orangesRotting([[2,1,1],[1,1,0],[0,1,1]]))
print(obj.orangesRotting([[2,1,1],[0,1,1],[1,0,1]]))
print(obj.orangesRotting([[0,2]]))

# Time Complexity : O(m * n) where m = rows and n = cols
# Space Complexity : O(m * n) where m = rows and n = cols
