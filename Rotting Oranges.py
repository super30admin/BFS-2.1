class Solution:
    
    #BFS
    # TC: O(M*N)
    # SC: O(M*N) --> If initially all the oranges are rotten
    
    def orangesRotting(self, grid: List[List[int]]) -> int:
        
        fresh = 0
        timer = 0
        
        m = len(grid)
        n = len(grid[0])
        
        dirs = [[0, -1], [0, 1], [-1, 0], [1, 0]]
        
        import queue
        q = queue.Queue()
        
        for i in range(m):
            for j in range(n):
                
                if (grid[i][j] == 2):
                    q.put([i,j])
                    
                if (grid[i][j] == 1):
                    fresh += 1
                    
        if (q.empty() and fresh == 0):
            return timer
                    
        while (not q.empty()):
            
            size = q.qsize()
            
            for i in range(size):
                
                curr = q.get()
                currRow = curr[0]
                currCol = curr[1]

                for dir in dirs:
                    nextRow =  currRow + dir[0]
                    nextCol = currCol + dir[1]

                    if (nextRow >= 0 and nextRow < m and nextCol >= 0 and nextCol < n 
                        and grid[nextRow][nextCol] == 1):
                        grid[nextRow][nextCol] = 2
                        q.put([nextRow, nextCol])
                        fresh -= 1
                    
            timer += 1
            
        if (fresh != 0):
            return -1

        return timer - 1