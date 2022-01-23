class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if len(grid) == 0: return 0
        m = len(grid)
        n = len(grid[0])
        q = []
        time = 0
        fresh = 0 
        dirs = [[0,1], [0, -1], [1, 0], [-1, 0]]
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    fresh += 1
                elif grid[i][j] == 2:
                    q.append([i, j])
        
        while q and fresh > 0:
            for i in range(len(q)):
                i, j = q.pop(0)
                for dr, dc in dirs:
                    row, col = dr + i, dc + j
                    if (row < 0 or row == len(grid) or col < 0 or col == len(grid[0])or grid[row][col] != 1):
                        continue
                    grid[row][col] == 2
                    q.append([row, col])
                    fresh -= 1
            time += 1
       
        return time if fresh == 0 else -1 
    
    
# T.C=>O(m * n) => Since we traverse all the matrix in a BFS manner
# S.C=> O(N) =>There might be need where we fill allt h values in a queue
# Approach => Its a BFS approach. Here we traverse the matrix breadth wise and check for the values that are either 1 or 2. if its 2 we store it in a queue its row and colm. after that er iterate through every up, down, left and right box to make it value 2 at elapse the minutes as wee and decrement fresh count. 
# Lastly if there are fresh oranges just return that or return -1 
    
    
# T.C=>O(m * n) => Since we traverse all the matrix in a BFS manner
# S.C=> O(N) =>There might be need where we fill allt h values in a queue
# Approach => Its a BFS approach. Here we traverse the matrix breadth wise and check for the values that are either 1 or 2. if its 2 we store it in a queue its row and colm. after that er iterate through every up, down, left and right box to make it value 2 at elapse the minutes as wee and decrement fresh count. 
# Lastly if there are fresh oranges just return that or return -1