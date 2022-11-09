# https://leetcode.com/problems/rotting-oranges/
#Approach 1 - BFS
# Time Complexity : O(mn)
# Space Complexity : O(mn)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        fresh = 1
        rotten = 2

        q = collections.deque()

        directions = [(-1, 0), (1,0), (0, -1), (0, 1)]

        count = 0
        time = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == rotten:
                    q.append([i,j])
                elif grid[i][j] == fresh:
                    count += 1
                else:
                    continue
        
        while(len(q) != 0 and count >0):
            size = len(q)
            while(size > 0):
                a = q.popleft()
                for b in directions:
                    x, y = a[0], a[1]
                    if 0 <= x + b[0] <len(grid):
                        x += b[0]
                    else:
                        continue
                    if 0 <= y + b[1] < len(grid[0]):
                        y += b[1]
                    else:
                        continue
                    if grid[x][y] == fresh:
                        grid[x][y] = rotten
                        q.append((x,y))
                        count -= 1
                size -= 1
            time += 1

        if count == 0:
            return time
        else:
            return -1
                    









