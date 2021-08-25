"""
//Time Complexity : O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : NO
"""
class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        if len(grid)==0:
            return 0
        m = len(grid)
        n= len(grid[0])
        from collections import deque
        q= deque()
        fresh = 0
        for i in range(0,m):
            for j in range(0,n):
                if(grid[i][j]==2):
                    q.append([i,j])
                elif (grid[i][j]==1):
                    fresh+=1
        if fresh == 0:
            return 0
        level = 0
        dirs = [[0,1],[1,0],[-1,0],[0,-1]] #right,down,up,left
        while q:
            size = len(q)
            for i in range(0,size):
                curr = q.popleft()
                for direction in dirs:
                    r = curr[0] + direction[0]
                    c = curr[1] + direction[1]
                if((r>=0 and r<m)  and (c>=0 and c<n) and grid[r][c]==1):
                    grid[r][c] = 2
                    q.append([r,c])
                    fresh-=1
            level+=1 
        if (fresh == 0):
            return level-1
        return -1 
                