
# Time Complexity : O(n) - n = size of grid
# Space Complexity : O(n) - n= size of grid
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        fresh = 0
        if grid is None:
            return 0
        q = deque()
        m,n = len(grid),len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    fresh+=1
                elif grid[i][j] == 2:
                    q.append((i,j))
        if fresh == 0:
            return 0;
        dirs = [(0,1),(0,-1),(1,0),(-1,0)]
        time = 0
        while q:
            size = len(q)
            for j in range(size):
                curr = q.popleft()
                for i in dirs:
                    r,c = i[0]+curr[0],i[1]+curr[1]
                    if m>r>=0 and n>c>= 0:
                        if grid[r][c] == 1:
                            grid[r][c]=2
                            fresh-=1
                            q.append((r,c))
            time+=1
        return time-1 if fresh == 0 else -1
            
