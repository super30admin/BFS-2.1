from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        row=len(grid)
        col=len(grid[0])
        queue = deque()
        neigbours=[[0,1],[1,0],[-1,0],[0,-1]]
        fresh,time=0,0
        for i in range(row):
            for j in range(col):
                if grid[i][j]==1:
                    fresh+=1
                elif grid[i][j]==2:
                    queue.append((i,j))
        print(fresh)
        if fresh==0:
            return 0
        while queue:
            size=len(queue)
            for s in range(size):
                r,c=queue.popleft()
                for i in neigbours:  
                    nr=r+i[0]
                    nc=c+i[1]
                    if nr>=0 and nr<row and nc>=0 and nc<col and grid[nr][nc]==1:
                        grid[nr][nc]=2
                        fresh-=1
                        queue.append((nr,nc))
            time+=1
        print(fresh)
        if fresh!=0:
            return -1
        return time-1
                
