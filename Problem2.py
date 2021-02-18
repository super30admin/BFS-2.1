# Time Complexity :O(n^2)
# Space Complexity :O(n)
#  Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no
#Leetcode : 994

# You are given an m x n grid where each cell can have one of three values:
#
# 0 representing an empty cell,
# 1 representing a fresh orange, or
# 2 representing a rotten orange.
# Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
#
# Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

# Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
# Output: 4
#
# Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
# Output: -1
# Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.


from collections import deque

dir = [[1, 0], [0, 1], [-1, 0], [0, -1]]


class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        row = len(grid)
        col = len(grid[0])

        if row == 0:
            return -1

        rotten = deque()
        fresh_count = 0
        for i in range(row):
            for j in range(col):
                if grid[i][j] == 2:
                    rotten.append((i, j))
                elif grid[i][j] == 1:
                    fresh_count += 1

        minutes_passed = 0

        while rotten and fresh_count > 0:

            minutes_passed += 1

            for each in range(len(rotten)):
                i, j = rotten.popleft()
                for each in dir:
                    newI = i + each[0]
                    newJ = j + each[1]

                    if newI < 0 or newI == row or newJ < 0 or newJ == col:
                        continue
                    if grid[newI][newJ] == 0 or grid[newI][newJ] == 2:
                        continue

                    fresh_count -= 1
                    grid[newI][newJ] = 2
                    rotten.append((newI, newJ))

        return minutes_passed if fresh_count == 0 else -1

grid = [[2,1,1],[1,1,0],[0,1,1]]
print(Solution().orangesRotting(grid))