"""
Problem : 1

Time Complexity : O(m*n) //m,n=dimensions of the input grid
Space Complexity : O(m*n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

For BFS - 
appending the indices of all the rotten tomatoes in the queue, and also counting the number of fresh tomatoes in the grid, initializing timer to 0
popping each index from queue, checking all of its direction for a fresh tomato, if found, changing the value and decrementing the counter and incrementing the timer
if counter becomes zero, returning the timer, if not returning -1 as we could not rott all tomatoes

"""

# Rotting Oranges

# Approach - 1
# BFS

class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        count_ones=0
        m=len(grid)
        n=len(grid[0])
        q=collections.deque()
        
        for i in range(m):
            for j in range(n):
                if grid[i][j]==1:
                    count_ones+=1
                if grid[i][j]==2:
                    q.append((i,j))

        if count_ones==0:
            return 0
        if not q:
            return -1

        direction=[[1,0],[0,-1],[0,1],[-1,0]]

        
        time=0
        while q:
            size=len(q)
            
            for i in range(size):
                curr=q.popleft()
                for dirs in direction:
                    r=curr[0]+dirs[0]
                    c=curr[1]+dirs[1]
                    if r>=0 and r<m and c>=0 and c<n and grid[r][c]==1:

                        grid[r][c]=3
                        count_ones-=1
                        q.append((r,c))
                        if count_ones==0:
                            return time+1
            time+=1
            
        if count_ones!=0:
            return -1
        else:
            return 0