# // Time Complexity : O(N)
# // Space Complexity :O(N)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :

# Definition for a binary tree node.

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if grid == None:
            return 0
        fresh = 0
        q = []
        time = 0
        dirs = [[1,0],[-1,0],[0,1],[0,-1]]
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 2:
                    q.append([i,j])
                if grid[i][j] == 1:
                    fresh += 1
        
        if q == [] and fresh == 0:
            return time
            
        while(q != []):
            size = len(q)
            for i in range(size):
                curr = q.pop(0)
                for direction in dirs:
                    nr = curr[0] + direction[0]
                    nc = curr[1] + direction[1]
                    if nr >= 0 and nc >= 0 and nr < len(grid) and nc < len(grid[0]) and grid[nr][nc] == 1 :
                        grid[nr][nc] = 2
                        q.append([nr,nc])
                        fresh -= 1
            time += 1
            
        if fresh != 0:
            return -1

        return time -1
                        
                    
                    
        
                    
                    
        