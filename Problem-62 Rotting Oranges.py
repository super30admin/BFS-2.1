# 994. Rotting Oranges
# https://leetcode.com/problems/rotting-oranges/

# Logic: 

# Time Complexiety: O(n*m)
# Space Complexiety: 

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        # identify idependent nodes
        n = len(grid)
        m = len(grid[0])
        time = 0
        q = list()
        freshOranges = 0
        
        for i in range(n):
            for j in range(m):
                if grid[i][j] == 2:
                    q.append((i,j))
                
                if grid[i][j] == 1:
                    freshOranges += 1
        
        # No. fresh oranges are available
        if freshOranges == 0:
            return 0

        # Apply BFS from all the idependent nodes
        while q:
            size = len(q)
            
            for i in range(size):
                node = q.pop(0)
                print(node)
                neighbours = [(0,1),(0,-1),(1,0),(-1,0)]
                
                for neighbour in neighbours:
                    row = node[0] + neighbour[0]
                    col = node[1] + neighbour[1]
                    
                    if (row >= 0 and row < n) and (col >= 0 and col < m):
                        if grid[row][col] == 1:
                            grid[row][col] = 2
                            freshOranges -= 1
                            q.append((row,col))
            time += 1
        
        if freshOranges != 0:
            return -1
        return time - 1