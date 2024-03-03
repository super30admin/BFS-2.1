#
# @lc app=leetcode id=994 lang=python3
#
# [994] Rotting Oranges
#

# @lc code=start
'''
Time Complexity - O(mn) for BFS as we traverse entire matrix in worst case to find a rotten orange.
                  O(mn) amortized from DFS as the complexity can go beyond O(mn) in worst case.
Space Complexity - O(mn) for both BFS and DFS

This code work on Leetcode for DFS and BFS
'''
from collections import deque
class Solution:
    def __init__(self):
        self.dirs = [[-1,0],[1,0],[0,1],[0,-1]] #create a dirs array

    
    def orangesRotting(self, grid: List[List[int]]) -> int:
        #BFS
        q = deque() #create a deque
        frshCnt, time = 0, 0 
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 2: #find a rotten orange
                    q.append((i,j)) #add the position to queue
                if grid[i][j] == 1:
                    frshCnt+=1 #increment the fresh orange count as well
        if frshCnt == 0:
            return 0 #No fresh oranges present
        if len(q) == 0: #if we are unable to add any rotten orange to queue return -1
            return -1
        while q: 
            for i in range(len(q)): #process a queue level wise
                pos = q.popleft() #take out the first element from the queue
                r = pos[0]
                c = pos[1]
                for dir in self.dirs: #check all directions
                    nr = r + dir[1]
                    nc = c + dir[0]
                    if nr >= 0 and nr < len(grid) and nc>=0 and nc<len(grid[0]) and grid[nr][nc] == 1:
                        grid[nr][nc] = 2 #if we find a fresh orange, make it rotten and add to queue
                        q.append((nr, nc))
                        frshCnt-=1 #reduce fresh count
            time+=1 #after every level increase time by 1
        if frshCnt == 0: #end when all oranges are rotten
                return time - 1  #we are doing increment and then process hence we have time 1 unit extra.
        else:
            return -1
        #DFS
        # for i in range(len(grid)):
        #     for j in range(len(grid[0])):
        #         if grid[i][j] == 2: #look for a rotten orange
        #             self.dfs(grid, 2, i, j) #start DFS keep with initial time offset as 2
        # maxTime = 2 #we have an offset of 2
        # for i in range(len(grid)):
        #     for j in range(len(grid[0])):
        #         if grid[i][j] == 1: #if we come across a 1, we were not able to reach there
        #             return -1
        #         maxTime = max(maxTime, grid[i][j])
        # return maxTime - 2 #return the max time take to rot all oranges, except balance the offset
        
        
    def dfs(self, grid, time, r, c):
        if r >= len(grid) or r < 0 or c >= len(grid[0]) or c<0 or grid[r][c] == 0: #We are going out of bounds or no orange present at a grid spot
            return
        if grid[r][c] != 1 and grid[r][c] < time: # if time taken to rot an orange is less than the current time, return
            return
        
        grid[r][c] = time 
        for dir in self.dirs: #check all directions
            nr = r + dir[1]
            nc = c + dir[0]
            self.dfs(grid, time+1, nr, nc) #start DFS in each direction with incremented time



        
        
# @lc code=end

