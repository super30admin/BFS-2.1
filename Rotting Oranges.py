# TC : O(RXC)
# SC : O(RXC)
class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        
        rows = len(grid)
        if rows == 0:  
            return -1
        
        cols = len(grid[0])
        
        fresh_cnt = 0
        rotten = deque()
        

        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 2:
                    rotten.append((r, c))
                elif grid[r][c] == 1:
                    fresh_cnt += 1
        
        time = 0
        directions = [(1,0), (-1,0), (0,1), (0,-1)]
        while rotten and fresh_cnt > 0:
            time += 1            
            for _ in range(len(rotten)):
                x, y = rotten.popleft()                
                for dx, dy in directions:
                    xx, yy = x + dx, y + dy
                    if xx < 0 or xx == rows or yy < 0 or yy == cols:
                        continue
                    if grid[xx][yy] == 0 or grid[xx][yy] == 2:
                        continue                    
                    fresh_cnt -= 1  
                    grid[xx][yy] = 2
                    rotten.append((xx, yy))
                    
        return time if fresh_cnt == 0 else -1