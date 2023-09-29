#time complexity:o(MN), traversing all the elements of the matrix
#space complexity: o(MN), for the queue
#passed all cases on LeetCode: yes
#https://leetcode.com/problems/rotting-oranges/description/

class Solution:
    def orangesRotting(self, grid):
        if not grid:
            return -1
        row, col = len(grid), len(grid[0])
        dirs = [[0,1], [0, -1], [1, 0], [-1, 0]]
        q, fresh = collections.deque(), 0
        for i in range(row):
            for j in range(col):
                if grid[i][j] == 2:
                    q.append([i, j])
                elif grid[i][j] == 1:
                    fresh += 1
        if fresh == 0:
            return 0
        lvl = 0
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                for dirc in dirs:
                    nc = curr[1] + dirc[1]
                    nr = curr[0] + dirc[0]
                    if nc >= 0 and nr >= 0 and nc <= col-1 and nr <= row-1 and grid[nr][nc] == 1:
                        grid[nr][nc] = 2
                        q.append([nr,nc])
                        fresh -= 1
            lvl += 1

        if fresh > 0:
            return -1
        return lvl-1
