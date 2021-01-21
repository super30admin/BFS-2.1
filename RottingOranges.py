# TC: O(mxn)
# SC: O(mxn) exponential increase at each level
# 1. Connected components -> go for graph solution -> BFS would be better as we are checking immediate neighbours first, if DFS considered we cannot compute time taken for rotten.
# 2. Always start with indpendent nodes(similar to course schedule)

from collections import deque
class Solution:
    def orangesRotting(self, grid):
        # edge case
        if grid == None or len(grid) == 0: return 0
        # we keep fresh count to check if any left
        fresh, m, n = 0, len(grid), len(grid[0])
        q = deque()
        for i in range(m):
            for j in range(n):
                # append all rotten to queue
                if grid[i][j] == 2:
                    q.append((i,j))
                elif grid[i][j] == 1:
                    # calculate total fresh ones
                    fresh += 1
        # rotting process starts! t= 0(level = 0)
        time = 0
        # nothing more to rot, return 0 time
        if fresh == 0: return 0
        # direction array for 4-direction navigation at each node
        dirs = [(0,1), (0,-1), (-1,0), (1,0)]
        while q:
            # we process(rot) at each level first before the next- this takes place in 1 unit time
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                for d in dirs:
                    # consider all 4 neighbours at each node
                    r, c = d[0] + curr[0], d[1] + curr[1]
                    # rot if fresh, append rotten ones to queue, decrement pre calculated fresh count 
                    if r >=0 and r < m and c>=0 and c < n and grid[r][c] == 1:
                        grid[r][c] = 2
                        q.append((r,c))
                        fresh -= 1
            # each time queue elements are evaluated, time icreases by 1 unit
            time += 1
        # still some fresh, -1
        if fresh != 0 : return -1
        # return time
        return time-1