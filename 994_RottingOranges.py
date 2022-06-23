"""
Leetcode- https://leetcode.com/problems/rotting-oranges/
TC - O(m*n), SC- O(m*n) BFS
Lecture- https://youtu.be/lMaZpCmcMfA
Challenge- Finding the connection between our time and BFS approach, doing DFS with multiple roots and time
FAQ-
Any other possible approach? DFS can be used
What will be Time/space complexity of DFS? (m*n)^2 and O(1) auxiliary

You are given an m x n grid where each cell can have one of three values:
0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

Example 1:
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Example 2:
Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

Example 3:
Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.

Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.
"""

from collections import deque


class Solution:
    '''
    Ideation - BFS approach O(m*n), O(m*n)
    Start off with all rotten oranges in the queue and process all rotten oranges in same level in BFS at time = *, add
    its neighbors and increment time.
    Infect them as you visit them.
    Time progresses when all unvisited rotten oranges are processed at each step as you go.
    Only process the fresh oranges. Also, keep a track for any fresh oranges left
    '''

    def orangesRotting1(self, grid):
        m = len(grid)
        if m == 0:
            return 0
        n = len(grid[0])
        queue = deque()
        dirs = [[0, -1], [0, 1], [-1, 0], [1, 0]]
        # count track of fresh oranges and add rotten oranges to initial queue, so we can process all rotten oranges in
        # same time t = *
        fresh = 0
        size = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    queue.append((i, j))
                    size += 1
                elif grid[i][j] == 1:
                    fresh += 1
        # corner case - no fresh oranges to rot
        if fresh == 0:
            return 0

        # process queue
        time = 0
        while queue:
            # count maintains size of next level in BFS
            count = 0
            for i in range(size):
                curr = queue.popleft()
                for dir in dirs:
                    x = curr[0] + dir[0]
                    y = curr[1] + dir[1]
                    # check boundary and if the neighbor has fresh orange
                    if 0 <= x < m and 0 <= y < n and grid[x][y] == 1:
                        grid[x][y] = 2
                        fresh -= 1
                        queue.append((x, y))
                        count += 1
            # increment time since
            size = count
            time += 1

        # any fresh oranges left, then we were unable to reach our desired state, return -1
        if fresh != 0:
            return -1
        # since after we processed our last iteration in BFS, our time was incremented by 1
        return time - 1

    '''
    Ideation- DFS O((m*n)^2) TC O(1) SC
    Our intention still remains the same, start off our exploration with all initially rotten oranges and process it.
    Now the challenge with DFS is that one node can be visited by multiple rotten parents, to solve this situation,
    we will take the minimum time taken by the child to be processed. We can achieve it by manipulation value of the
    child to indicate it's processed and at which time, and take minimum of current and previous time recorded.
    Notice, you will need to add an offset to your recorded time since elements 0, 1 and 2 are already occupied.
    
    The max element in the matrix will be our answer
    '''

    def orangesRotting(self, grid):
        self.m = len(grid)
        if self.m == 0:
            return 0
        self.n = len(grid[0])
        self.dirs = [[0, -1], [0, 1], [-1, 0], [1, 0]]
        # count track of fresh oranges and call dfs on the rotten ones
        self.offset = 2
        for i in range(self.m):
            for j in range(self.n):
                if grid[i][j] == 2:
                    # do dfs
                    self.dfs(grid, i, j, self.offset)
        # find max element in matrix for answer
        result = 0
        for i in range(self.m):
            for j in range(self.n):
                # corner case - no fresh oranges to rot
                if grid[i][j] == 1:
                    return -1
                result = max(result, grid[i][j] - self.offset)

        return result

    def dfs(self, grid, i, j, time):
        # base - out of bound or zero or 2 when t!=offset
        if i < 0 or j < 0 or i >= self.m or j >= self.n or grid[i][j] == 0 or (time != self.offset and grid[i][j] == 2):
            return
        # prune dfs for previously visited node by previous parent whose time is already minimum than current
        if grid[i][j] != 1 and grid[i][j] < time:
            return
        # logic
        grid[i][j] = time
        for dir in self.dirs:
            x = i + dir[0]
            y = j + dir[1]
            self.dfs(grid, x, y, time + 1)


matrix = [[2, 1, 1], [1, 1, 1], [0, 1, 2]]
result = Solution().orangesRotting(matrix)
print(result)
