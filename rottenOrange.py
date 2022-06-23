"""
Approach: BFS 
Described more in comments.

TC: O(m x n)
SC: O(m x n) what if all oranges are rotten, we fill the queue with all elements. hence this SC.
"""

from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        fresh = time = 0
        q = deque()
        
        # go over grid once and find all fresh and rotten oranges initially
        # fresh oranges will be counted by fresh variable
        # rotten oranges are added to the queue for processing
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    fresh+=1
                elif grid[i][j] == 2:
                    q.append((i,j))
        
        # if we don't have any fresh oranges in the grid, then no need to go further, we can't rot any
        # return 0 in that case
        if fresh == 0 :
            return 0
        
        # else create a dirs arr to store all 4 dirs we want to consider
        dirs = [[0,1], [1,0], [0,-1], [-1,0]]  # we only need to consider 4 directions

        # while q is not empty, it holds list of all rotten oranges, we pop them out one by one, level by level(as we are using BFS)
        # and rot all surrounding oranges to it
        while q:
            size = len(q) # get current size of queue to get the idea of how big is the current level
            for i in range(size): # process all elements at the current level by
                curr = q.popleft() # popping each of them from the q
                for d in dirs:  # and checking all 4 directions around them for rotting
                    nr = curr[0] + d[0]
                    nc = curr[1] + d[1]
                    # if nr and nc are valid, and orange is fresh, rot it and add that nr,nc to the q
                    if nr >= 0 and nc >= 0 and nr < m and nc < n and grid[nr][nc] == 1:
                        grid[nr][nc] = 2
                        q.append((nr,nc))
                        fresh -= 1
            time += 1
            if fresh == 0:  # when fresh count becomes 0 stop processing queue and return the time
                return time
        
        return -1
                    

"""
Approach: DFS

TC O((mxn)^2) becuase if we have 1 rotten orange, that can rot all other oranges and we may have to call dfs on all of them
SC O(mxn) for recursive stack
"""

from collections import deque
class Solution:
    dirs = [[0,1], [1,0], [0,-1], [-1,0]]  # we only need to consider 4 directions
    def orangesRotting(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])

        
        # go over grid once and find all fresh and rotten oranges initially
        # fresh oranges will be counted by fresh variable
        # rotten oranges are added to the queue for processing
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    self.dfs(grid, i, j, 2)  # pass time as 2, as 0, 1, are already used for empty cell and fresh oranges

        # else create a dirs arr to store all 4 dirs we want to consider
        time = 0
        for row in grid:
            if 1 in row:
                return -1
            time = max(time, max(row))
            
        return time - 2 if time > 0 else 0

        
    def dfs(self, grid, i, j, time):
        # base case
        
        # check bounds
        if i < 0 or j < 0 or i == len(grid) or j == len(grid[0]):
            return
        
        # if current time is greater than time at the grid, we have already rot the orange, so stop the dfs 
        if grid[i][j] != 1 and grid[i][j] < time: 
            return
        
        # logic
        grid[i][j] = time
        for d in self.dirs:
            nr = i + d[0]
            nc = j + d[1]
            self.dfs(grid, nr, nc, time + 1)
            

