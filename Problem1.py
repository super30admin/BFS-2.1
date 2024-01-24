'''

Time Complexity : O(mn)
Space Complexity : O(mn)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

Your code here along with comments explaining your approach

Go thru the matrix once and add all the positions of rotten oranges to a queue. And then perform the BFS subsequently adding all the neighboring
oranges. Keep a hashset from fresh oranges and remove fresh ones as they get spoiled. After visiting all the neighboring nodes if
anything remains in the fresh hashset, then return the result accordingly

'''

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        fresh = set()
        q = collections.deque()
        dirs = [(0,1),(1,0),(-1,0),(0,-1)]
        m = len(grid)
        n = len(grid[0])

        for i in range(len(grid)):
            for j in range(len(grid[0])):

                if grid[i][j] == 1:
                    fresh.add((i,j))
                elif grid[i][j] == 2:
                    q.append((i,j))

        if q:
            mins = -1
        if not q:
            mins = 0

        while q:
            length = len(q)
            mins += 1
            for i in range(length):
                cr,cc = q.popleft()

                for k in dirs:
                    ni = cr + k[0]
                    nj = cc + k[1]

                    if 0 <= ni < m and 0 <= nj < n and grid[ni][nj] != 0 and grid[ni][nj] != 2:
                        if (ni,nj) in fresh:
                            fresh.remove((ni,nj))
                            q.append((ni,nj))

        if fresh:
            return -1

        if not fresh:
            return mins






