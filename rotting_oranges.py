# Time complexity: O(mn)
# space complexity: O(mn)
# Approach: check for number of fresh oranges and insert rotten ones into queue
# traverse the queue and check for fresh ones
# add the freshones into queue and make them rotten in the matrix
# decrease the fresh oranges count whenver u make the fresh one into rotten
# return -1 if there are still fresh oranges left
# else return time if no fresh oranges left


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        from queue import Queue
        q = Queue()
        if grid == 0:
            return 0
        fresh = 0
        dirs = [[0,-1],[0,1],[-1,0],[1,0]]
        m = len(grid)
        n = len(grid[0])
        #check for number of fresh oranges and insert rotten ones into queue
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    fresh += 1
                elif grid[i][j] == 2:
                    q.put([i,j])
        if fresh == 0:
            return 0
        time = 0
        # do bfs
        while not q.empty():
            size = q.qsize()
            for i in range(size):
                curr = q.get()
                for dir in dirs:
                    nr = curr[0]+dir[0]
                    nc = curr[1]+dir[1]
                    if(nr >=0 and nr<m and nc>=0 and nc< n and grid[nr][nc]== 1):
                        q.put([nr,nc])
                        grid[nr][nc]=2
                        fresh = fresh -1
            time = time + 1
        # return -1 if there are still fresh oranges left
        if fresh != 0:
            return -1
        # else return time if no fresh oranges left
        else:
            return time-1
                    
            
            
                    
                    
        