from collections import deque
class Solution:
    """BFS implementation
    Time complexity-O(m*n)
    Space complexity-O(m*n) as in worst case we may have mn/2 elements in queue at same time if rotten oranges are in middle of matrix"""
    def orangesRotting(self, grid: List[List[int]]) -> int:
        q=deque()
        time=0
        fresh=0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]==1:
                    fresh+=1
                if grid[i][j]==2:
                    q.append(i)
                    q.append(j)
        if fresh==0:
            return 0
        dirs=[[1,0],[0,1],[-1,0],[0,-1]]
        while q:
            size=len(q)
            for k in range(0,size, 2):
                row=q.popleft()
                column=q.popleft()
                for dir in dirs:
                    r=row+dir[0]
                    c=column+dir[1]
                    if r>=0 and r<len(grid) and c>=0 and c<len(grid[0]) and grid[r][c]==1:
                        grid[r][c]=2
                        fresh-=1
                        q.append(r)
                        q.append(c)
            time+=1
        if fresh==0:
            return time-1
        return -1
                
                
            
            
                    
        
        