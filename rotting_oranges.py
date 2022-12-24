#Time Complexity :  O(m * n)
#Space Complexity :  O(m * n)
#Did this code successfully run on Leetcode : Yes

#code along with comments 

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        rows, cols  = len(grid), len(grid[0])               #getting length of rows and cols
        time, fresh = 0,0
        directions = [[0,1], [0,-1], [1,0], [-1, 0]]        #maintaining directions array
        q = deque()                                         #using a double ended queue
        
        if grid == None or len(grid) == 0:                  #base case check 
            return 0
        
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 2:                         #if rotting orange
                    q.append([r, c])                        #we append coordinates of rotting orange
                if grid[r][c] == 1:                         #if fresh orange
                    fresh += 1                              #increment fresh count by 1
        
        while q and fresh > 0:
            for i in range(len(q)):
                r,c = q.popleft()
                for dr, dc in directions:
                    row, col = dr+r, dc+c
                    if(row<0 or row==len(grid) or           #if out of bounds and not fresh we skip
                       col<0 or col==len(grid[0]) or 
                       grid[row][col]!=1):
                        continue
                    else:                                   #if within bounds and fresh, then make them rotten
                        grid[row][col] = 2
                        q.append([row,col])
                        fresh -= 1
            
            time += 1
            
        return time if fresh == 0 else -1                   #if no fresh we return time else -1