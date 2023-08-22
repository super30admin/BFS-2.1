#Time Complexity O(n^2)
#Space Complexity O(n)

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        
        if len(grid) == 0 :
            return 0
        
        dirs = [[-1,0] , [1,0] , [0,1] , [0,-1]] ##Up down left right

        #use BFS

        queue = []
        mins = 0
        fresh_oranges = 0

        for rows in range(len(grid)):
            for cols in range(len(grid[0])):

                if grid[rows][cols] == 2:
                    queue.append([rows,cols])
                
                if grid[rows][cols] == 1:
                    fresh_oranges +=1
        
        if fresh_oranges == 0:
            return 0
            
        while len(queue) > 0:
            
            for size in range(len(queue)):
                curr = queue.pop(0)
                for i in range(len(dirs)):
                    new_row = curr[0] + dirs[i][0]
                    new_col = curr[1] + dirs[i][1]

                    if new_row >= 0 and new_row < len(grid) and new_col >= 0 and new_col < len(grid[0]) and grid[new_row][new_col] == 1 : 

                        grid[new_row][new_col] = 2
                        queue.append([new_row,new_col])
                        fresh_oranges -=1
                    
            mins+=1
        
        print(grid)
        
        if fresh_oranges > 0:
            return -1
        

        return mins - 1
