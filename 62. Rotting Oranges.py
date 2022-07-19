from collections import deque


class Solution:
    def orangesRotting(self, grid):
        if grid is None:
            return 0
        m = len(grid)
        n = len(grid[0])
        fresh = 0
        q = deque()

        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    fresh += 1
                elif grid[i][j] == 2:
                    q.append([i, j])
        # print(q, fresh)
        if fresh == 0:
            return 0

        time = 0
        dirs = [[0, -1], [0, 1], [-1, 0], [1, 0]]

        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                #print(curr)
                for d in dirs:
                    r = curr[0] + d[0]
                    c = curr[1] + d[1]
                    # print(r, c)
                    if (r >= 0 and c >= 0) and (r < m and c < n) and (grid[r][c] == 1):
                        grid[r][c] = 2
                        q.append([r, c])
                        fresh -= 1
            time += 1
        # print( fresh, "after")
        #print(time, fresh)
        if fresh > 0:
            return -1
        return time - 1

# TC = O(n) * O(m)
# Space complexity : O(n) * O(m).
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No


if __name__ == "__main__":
    obj = Solution()
    print(obj.orangesRotting([[2, 1, 1], [1, 1, 0], [0, 1, 1]]))