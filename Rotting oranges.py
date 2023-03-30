class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:

        # BFS APPROACH
        # Time Complexity: O(m*n)
        # Space Complexity: O(m*n)
        # rowlen = len(grid)
        # collen = len(grid[0])
        # count = 0 # To keep track of number of 1's in the array
        # dirs = [[-1,0],[1,0],[0,-1],[0,1]] # Direction BFS will traverse
        # # Create a BFS queue
        # dq = collections.deque()
        # prv_lvl = lvl = 0
        # # First, find all 2's in the matrix and add them to the queue of BFS
        # for i in range(rowlen):
        #     for j in range(collen):
        #         if grid[i][j] == 2:
        #             dq.append((i,j,lvl))
        #         if grid[i][j] == 1:
        #             count += 1
        # # print(dq)
        # # Start the BFS
        # while dq:
        #     r,c,lvl = dq.popleft()
        #     for dirr in dirs:
        #         nr = r + dirr[0]
        #         nc = c + dirr[1]
        #         if nr in range(rowlen) and nc in range(collen) and grid[nr][nc] == 1:
        #             grid[nr][nc] = 2
        #             dq.append((nr,nc,lvl+1))
        #             count -= 1

        # if count == 0: return lvl
        # return -1

        # DFS APPROACH
        # Time Complexity: O(m*n)**2
        # Space Complexity: O(m*n)**2
        global rowlen, collen, count, dirs
        matrix = grid
        rowlen = len(grid)
        collen = len(grid[0])
        count = 0  # To keep track of number of 1's in the array
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]  # Direction DFS will traverse

        def dfs(r, c, offset):
            # print("here")
            global rowlen, collen, dirs
            if grid[r][c] == 0: return
            if grid[r][c] != 1 and grid[r][c] < offset: return
            matrix[r][c] = offset
            for dirr in dirs:
                nr = r + dirr[0]
                nc = c + dirr[1]
                if nr in range(rowlen) and nc in range(collen) and matrix[nr][nc] > 0:
                    dfs(nr, nc, offset + 1)

        for i in range(rowlen):
            for j in range(collen):
                if grid[i][j] == 2:
                    dfs(i, j, 2)
        result = 0
        # print(grid)
        for i in range(rowlen):
            for j in range(collen):
                if grid[i][j] == 1:
                    return -1
                result = max(result, grid[i][j] - 2)
        return result




