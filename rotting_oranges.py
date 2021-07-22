#Time Complexity :  O(mn)
#Space Complexity : O(mn)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no


from collections import deque
class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        if len(grid)==0:
            return 0
        
        fresh = 0
        queue = deque()
        m = len(grid)
        n = len(grid[0])
        for row in range(0,m):
            for col in range(0,n):
                if grid[row][col]== 1:
                    fresh+=1
                if grid[row][col]==2:
                    queue.append((row,col))

        if fresh==0:
            return 0
        completed = 0
        time = 0
        dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        while(queue):
            for ele in range(len(queue)):
                pop_value = queue.popleft()
                r = pop_value[0]
                c = pop_value[1]
                for neighbour in dirs:
                    r1 = r+neighbour[0]
                    c1 = c+neighbour[1]
                    if (r1>=0 and r1<m) and (c1>=0 and c1<n):
                        
                        if grid[r1][c1]==1:
                            grid[r1][c1]=2
                            completed+=1
                            queue.append((r1,c1))
            time+=1
        return time-1 if completed==fresh else -1             
                            
                             
            