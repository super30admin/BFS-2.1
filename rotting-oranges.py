# BFS
# Time Complexity: O(mn)
# Space Complexity: O(mn)
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        # None Condition check
        if (len(grid) == 0 or grid == None):
            return 0
        
        # Obtain the number of rows and cols
        rows = len(grid)
        cols = len(grid[0])
        
        # Fresh and time variable to count the fresh oranges and time to rot
        fresh = 0
        time = 0
        q = deque()
        
        
        for i in range(rows):
            for j in range(cols):
                # if grid value is 1, increment fresh by 1
                # This is to keep track of fresh
                if grid[i][j] == 1:
                    fresh += 1
                
                # If the val is 2, append row and col in the queue
                if grid[i][j] ==2:
                    q.append(i)
                    q.append(j)
    
        # Check if there are no fresh, return 0
        if fresh == 0: return 0
        
        # Declare in the dirs array for traversing four directions
        dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        while q:
            size = len(q)
            time += 1
            
            # For each level, pop the element and check if it is fresh
            # If it is fresh, make it rotten
            # Append it in the queue
            for i in range(0,size,2):
                r = q.popleft()
                c = q.popleft()
                for dir in dirs:
                    nr = r + dir[0]
                    nc = c + dir[1]
                
                if nr >= 0 and nr < rows and nc >= 0 and nc < cols and grid[nr][nc] == 1:
                        
                        grid[nr][nc] = 2
                        fresh -= 1
                        q.append(nr)
                        q.append(nc)
                        
        # If fresh are available, return -1 as we could not make all fresh rotten        
        if fresh > 0:
            return -1
        
        # Subtract one as we are incrementing for the last level as well
        return time - 1
                        
                
            
                    
                    
        