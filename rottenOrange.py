import queue
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        q = deque()
        fresh = 0
        dir = [[-1,0],[1,0],[0,-1],[0,1]]
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    q.append([i,j])
                elif grid[i][j] == 1:
                    fresh += 1
        if fresh == 0:
            return 0
        level = 0
        
        while q:
            s = len(q)
            for i in range(s):
                curr = q.popleft()
                for d in dir:
                    nr = curr[0] + d[0]
                    nc = curr[1] + d[1]
                    if nr >= 0 and nr < m and nc >=0 and nc < n and grid[nr][nc] == 1:
                        print(q)
                        q.append([nr,nc])
                        fresh -= 1
                        grid[nr][nc] = 2
            level += 1
        if fresh != 0:
            return -1
        return level -1
    
#TC:O(n*m)
#SC:O(n*m)