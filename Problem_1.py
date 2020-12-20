# Rotting Oranges

# Time Complexity : O(M*N)
# Space Complexity : O(M*N)
# Did this code successfully run on Leetcode : Yes, with Runtime: 44 ms and Memory Usage: 14.3 MB
# Any problem you faced while coding this : Initally yes, After class understanding no.
# Your code here along with comments explaining your approach
# Approach
"""
Using DFS approach, finding the rotten oranges positioon i.e 2's in grid 
and than list is maintained to store rotten oranges After traversal, i.e checking
in four directions conversion is done from 1's to 2's and fresh orange count is 
decreased and time is increased and returned.

"""

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        rotten_oranges = [] # List to maintain rotten oranges count
        fresh_count = 0 # Variable to count oranges (1's)
        for row in range(len(grid)):
            for col in range(len(grid[0])):
                if grid[row][col] == 2:  # If rotten oranges is found nothing else count 
                    rotten_oranges.append([row,col]) # fresh oranges
                if grid[row][col] == 1:
                    fresh_count += 1
        time = 0
        directions =[[1,0],[-1,0],[0,1],[0,-1]] # Moving in directions 
        while True:
            new = []
            for row,col in rotten_oranges:
                for direc in directions:
                    nextrow = direc[0] + row
                    nextcol = direc[1] + col
                    if nextrow < len(grid) and nextrow >=0 and nextcol < len(grid[0]) and nextcol >=0:
                         if grid[nextrow][nextcol] == 1:
                            grid[nextrow][nextcol] = 2
                            fresh_count -= 1
                            new.append([nextrow,nextcol])
            rotten_oranges = new
            if not rotten_oranges:
                break
            time += 1
        return  time if fresh_count == 0 else -1