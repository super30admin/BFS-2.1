class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        time = -1 
        fresh_oranges = 0
        row = len(grid) 
        col = len(grid[0]) 
        q = deque()
        for r in range(row):
            for c in range(col):
                if grid[r][c] == 1:
                    fresh_oranges += 1
                elif grid[r][c] == 2:
                    q.append((r,c))
        directions = [(1,0) , (-1, 0) , (0,-1) , (0, 1)]  
        q.append( ( -1,-1) )
        while q:
            curr = q.popleft()
            if curr == (-1, -1):
                time += 1
                if q:
                    q.append( ( -1,-1) )
            else:
                for i , j in directions:
                    if 0 <= curr[0]+i < row and 0 <= curr[1]+j < col :
                        if grid[curr[0]+i ][curr[1]+j] == 1:
                            fresh_oranges -= 1
                            grid[curr[0]+i ][curr[1]+j] = 2
                            q.append( ( curr[0]+i , curr[1]+j ) )
        if fresh_oranges == 0 :
            return time
        else: 
            return -1
