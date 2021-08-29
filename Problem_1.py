class Solution:
    """
    simply fins all the frresh and all the rotten tomattoes location
    iterate and rot all the neighbor tomatoes and count the level
    TC - O(n)
    Sc - O(n)
    """
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if not grid:
            return -1
        m = len(grid)
        n = len(grid[0])
        q = []
        fresh = 0
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == 2:
                    q.append([i, j])
                elif grid[i][j] == 1:
                    fresh += 1
        if fresh == 0:
            return 0
        ans = 0
        dic = [[0, 1], [1, 0], [-1, 0], [0, -1]]
        while len(q) > 0:
            size = len(q)
            for i in range(size):
                cur = q.pop(0)
                for d in dic:
                    r = d[0] + cur[0]
                    c = d[1] + cur[1]
                    if r >= 0 and r < m and c >= 0 and c < n and grid[r][c] == 1:
                        grid[r][c] = 2
                        q.append([r, c])
                        fresh -= 1
            ans += 1
        if fresh == 0:
            return ans - 1
        return -1



