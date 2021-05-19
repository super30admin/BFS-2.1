"""994. Rotting Oranges
Time Complexity - O(n^n)
Space Complexity - O(mn)"""
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        from collections import deque
        queue = deque()
        time_elapsed =0
        fresh_count =0
        
        #iterate through the grid and add location the rotten oranges to the queue, keep a count of fresh oranges
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]==1:
                    fresh_count +=1
                if grid[i][j]==2:
                    queue.append([i,j])
        #list of all possible directions            
        dirs = [[1,0],[-1,0],[0,1],[0,-1]]
        #no oranges
        if fresh_count==0:
            return 0
        
        while queue:
            size =len(queue)
            time_elapsed +=1
            for i in range(size):
                curr = queue.popleft()
                for direction in dirs:
                    r = curr[0]+direction[0]
                    c = curr[1]+direction[1]
                    if r>=0 and r<len(grid) and c>=0 and c<len(grid[0]) and grid[r][c]==1: 
                        grid[r][c]=2 #make oranges rotten
                        queue.append([r,c]) #add to queue
                        fresh_count-=1  #reduce count of fresh
                        
    
        if fresh_count >0: # if fresh oranges remains then it is unreachable oranges 
            return -1
        return time_elapsed-1
                    