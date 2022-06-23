'''
Time Complexity: O(m*n)
Space Complexity: O(m*n)
Run on Leetcode: YES
'''
from ast import List
from collections import deque


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        fresh = 0
        myQueue = deque()
        m = len(grid)
        n = len(grid[0])
        if m == 0:
            return 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    myQueue.append([i,j])
                elif grid[i][j] == 1:
                    fresh += 1
        if fresh == 0:
            return 0
        time = 0
        direction = [[-1,0], [0,1], [1,0], [0, -1]]
        while(len(myQueue) != 0):
            size = len(myQueue)
            for i in range(size):
                curr = myQueue.popleft()
                for direct in direction:
                    newR = curr[0] + direct[0]
                    newC = curr[1] + direct[1]
                    if(newR >= 0 and newC >= 0 and newR < m and newC < n and grid[newR][newC] == 1):
                        grid[newR][newC] = 2
                        fresh -= 1
                        myQueue.append([newR,newC])
            time += 1
        
        if fresh != 0:
            return -1
        return time - 1