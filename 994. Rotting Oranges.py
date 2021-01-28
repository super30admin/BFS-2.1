# // Time Complexity : O(mn)
# // Space Complexity : O(mn)
# // Did this code successfully run on Leetcode : Yes
# // Your code here along with comments explaining your approach
	# Create a queue with all the rotten oranges
	# Perform BFS on each of the rotten cell considering the subsequent rotton oranges


from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if not grid:
            return 0
        m = len(grid)
        n = len(grid[0])
        
        fresh = 0
        
        QueueRow = deque()
        for i in range(0,m):
            for j in range(0,n):
                if grid[i][j] == 2:
                    QueueRow.append([i,j])
                elif grid[i][j] == 1:
                    fresh += 1
        time = 0
        if fresh == 0:
            return 0
        dirs = [[0,1],[0,-1],[-1,0],[1,0]]
        
        while(len(QueueRow) != 0):
            size = len(QueueRow)
            
            for i in range(0,size):
                CurrCell = QueueRow.popleft()
                for d in dirs:
                    r = CurrCell[0] + d[0]
                    c = CurrCell[1] + d[1]
                    if r < m and c < n and r >= 0 and c >= 0 and grid[r][c] == 1:
                        grid[r][c] = 2
                        QueueRow.append([r,c])
                        fresh -= 1
            time += 1
        if fresh != 0:
            return -1
        return time - 1