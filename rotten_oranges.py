#Time Complexity : O(mn) m-> rows n -> cols
#Space Complexity : O(mn) m-> rows n -> cols of queue
#Approach : BFS
#Did your code run on leetcode : yes

from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        
        queue = deque()
        fresh_count = 0
        
       #used to check directions 
        dirs = [[-1,0],[0,-1],[1,0],[0,1]]
        
        #added by default rotten oranges into queue and also took count of fresh oranges
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    queue.append((i,j))
                if grid[i][j] == 1:
                    fresh_count += 1
        
        #if grid doesnt have any fresh oranges
        if fresh_count == 0:
            return 0
        
        #BFS to rot fresh oranges
        time = 0
        while(len(queue) != 0):
            size = len(queue)
            for i in range(size):
                current = queue.popleft()
                #to check elements in 4 directions
                for dire in dirs:
                    r = dire[0] + current[0]
                    c = dire[1] + current[1]
                    #check out of bounds
                    if (r >= 0 and c >= 0 and r < m and c < n):
                        if grid[r][c] == 1:
                            queue.append((r,c))
                            grid[r][c] = 2
                            fresh_count -= 1      
            time += 1
        if fresh_count == 0: return time - 1
        else:  
            return -1
                        
        
        
