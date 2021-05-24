class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        
        if grid is None:
            return None
        
        q = list()
        fresh = 0
        for i in range(0,len(grid)):
            for j in range(0, len(grid[0])):
                if grid[i][j] == 2:
                    q.append((i,j))
                
                if grid[i][j] == 1:
                    fresh+=1
        
        if fresh==0:
            return 0
        
        dirs = ((1,0),(-1,0),(0,1),(0,-1))
        time = 0
        
        while q:
            size = len(q)
            for i in range(size):
                curr = q.pop(0)
                print(curr, time)
                for direct in dirs:
                    r = direct[0]+curr[0]
                    c = direct[1]+curr[1]
                    
                    if r<len(grid) and r>=0 and c<len(grid[0]) and c>=0 and grid[r][c]==1:
                        grid[r][c] = 2
                        q.append((r,c))
                        fresh-=1
                
            time+=1
    
        if fresh>0:
            return -1
        
        return time-1
    
#  BFS solution - apprach is st forward using dirs array
#  time complexity is o(mn) and space complexity is o(mn)
        
        
                        
                    
                
