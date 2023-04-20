# Time Complexity: O(m*n)
# Space Complexity: O(m*n) as the oranges are added to the queue and set
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
We get the rotten oranges and fresh oranges in the grid and add them to a queue and a set respectively. 
And we iterate over the queue and convert all the adjacent orages to rotten if they are fresh and put them 
in the queue and remove them from the set, also keeping track of minutes with the size variable. Finally we 
return the minutes when the fresh set is empty and -1 if the fresh set is not empty.
"""

from queue import Queue
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if grid == None: return 0

        rotten = Queue()
        fresh = set()

        for i in range(len(grid)): 
            for j in range(len(grid[0])):
                if grid[i][j] == 1: fresh.add((i,j))
                if grid[i][j] == 2: rotten.put((i,j))

        minutes = 0

        if not fresh:
            return minutes

        while not rotten.empty():
            size = rotten.qsize()
            minutes += 1

            for _ in range(size):
                i,j = rotten.get()

                if i-1 >= 0 and (i-1, j) in fresh:
                    fresh.remove((i-1, j))
                    rotten.put((i-1, j))
                if i+1 < len(grid) and (i+1, j) in fresh:
                    fresh.remove((i+1, j))
                    rotten.put((i+1, j))
                if j-1 >= 0 and (i, j-1) in fresh:
                    fresh.remove((i, j-1))
                    rotten.put((i, j-1))
                if j+1 <= len(grid[0]) and (i, j+1) in fresh:
                    fresh.remove((i, j+1))
                    rotten.put((i, j+1))
            if not fresh:
                return minutes

        if fresh:
            return -1