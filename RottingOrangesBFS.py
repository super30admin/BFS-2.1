'''
BFS:-
TC: O(m*n)
SC: O(m*n)
'''
from typing import List
import collections

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        #BFS
        ROWS, COLS = len(grid), len(grid[0])
        dirs = [(-1,0),(0,-1),(1,0),(0,1)]
        fresh = 0
        q = collections.deque()
        for i in range(ROWS):
            for j in range(COLS):
                if grid[i][j] == 2:
                    q.append((i,j))
                elif grid[i][j] == 1:
                    fresh += 1
        time = 0
        if fresh == 0:
            return 0
        while q:
            l = len(q)
            while l!=0:
                x,y = q.popleft()
                for dir_ in dirs:
                    nx,ny = x+dir_[0], y+dir_[1]
                    if nx>=0 and ny>=0 and nx<ROWS and ny<COLS:
                        if grid[nx][ny] == 1:
                            grid[nx][ny] = 2
                            fresh -= 1
                            if fresh == 0:
                                return time+1
                            q.append((nx,ny))
                l -= 1 
            time += 1
        return -1
s = Solution()
print(s.orangesRotting([[2,1,1],[1,1,0],[0,1,1]]))
print(s.orangesRotting([[2,1,1],[0,1,1],[1,0,1]]))
print(s.orangesRotting([[0,2]]))