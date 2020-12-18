class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        # use bfs not dfs
        #O(m*n) both
        # dfs will keep running depth wise on each cell and we will lose count of time by counting cells multiple times
        # but problem wants to see levels of cells turning rotten
        # start with rotten cell(independent node) -> adjacent cells/"children" become rotten
        # effect continues...level by level traversal so bfs traversal
        
        # use queue to see initial rotten cells
        # track count of fresh
        # turn 1st rotten's neighbors rotten and add to queue -> continue process
        # overall time =(level of traversal-1) as we already set level1=given rotten oranges
        # if empty queue but still some fresh are left  -> then not possible
        # because some fresh not reachable >>return -1
        if not grid :
            return -1
        row = len(grid)
        col = len(grid[0])
        fresh=0
        time=0
        q=deque()
        #maintain count of fresh and put rotten in queue
        for i in range(row):
            for j in range(col):
                if grid[i][j]==1:
                    fresh+=1
                elif grid[i][j]==2:
                    q.append((i,j))
        #edge case>>nothing to rot>so 0minutes
        if fresh==0:
            return 0
        
        dirs=[[0,1],[1,0],[-1,0],[0,-1]]
        while q :
            size=len(q)
            #maintaining levels
            for i in range(size):
                cur=q.popleft()
                #get rotten value>find its neighbours>rot them>add to queue, reduce fresh count
                for dir in dirs:
                    r=cur[0]+dir[0]  
                    c=cur[1]+dir[1]
                    if r>=0 and r<row and c>=0 and c<col and grid[r][c]==1:
                        grid[r][c]=2
                        fresh-=1
                        q.append((r,c))
            #increase level >>increase time
            time+=1
        #if still fresh oranges left >-1
        if fresh>0:return -1
        #else> overall time =(level of traversal-1) as we already set level1=given rotten oranges
        else:return time-1
            
                
        