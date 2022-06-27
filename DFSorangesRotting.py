#Approach - DFS
#Time complexity : O(m*n)^2 i.e. we are going over elements in the grids everytime 2 is encoundered and going over dfs from the loop over the all possible travelled orange from the grid
#Space complexity : O(m*n) i.e. for recursive stack
#Did this code successfully run on Leetcode : Yes
#youtube : https://www.youtube.com/watch?v=lMaZpCmcMfA
class Solution:
    #defining 4 directions
    dirs= [[0,1], [1,0], [0,-1], [-1,0]] 
    
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if grid == None or len(grid) ==0:
            return 0
        #number of rows and columns
        m = len(grid)
        n = len(grid[0])
        #iterating over all the element in the grid and where we encounter first rotten orange we will call the dfs recursion function from there and continue it for all the rotten orange present after it 
        for i in range(m):
            for j in range(n):
                if grid[i][j] ==2:
                    #here by default we are setting the time as 2 because as we are mutating the grid by putting the time to the fresh orange when converted to rotten and further  to differentiate the grid from the rotten, fresh and empty place
                    self.dfs(grid, i, j, 2)
        
        #setting the maximum element as 0 because all the elements inside the grid are greater than or equal to 0
        maximum = 0
        #creating for loop for getting the time of rotting all the oranges
        for i in range(m):
            for j in range(n):
                #if any fresh orange is encountered after the dfs traversal then it can't be reached from any neighbouring element
                if grid[i][j] == 1:
                    return -1
                elif grid[i][j] != 0:
                    #getting the maximum time it took to rotten all the oranges
                    #comparing the maximum value with the maximum and grid value -2 as we are incrementing the time from 2
                    maximum = max(maximum, grid[i][j]-2)
                    
        return maximum
    
    def dfs(self, grid: List[List[int]], i: int, j: int, time :int):
        #base condition
        #checking the bounds of the neighbour calculated from the logic in previous recursion call
        if i<0 or j<0 or i == len(grid) or j == len(grid[0]):
            return
        #checking if the orange at particular grid is visited if it is visited then checking the time if time is greater then the previous time assigned if that is the case then return else it will go it logic for updating the time and for prrocessing further its neighbour
        if grid[i][j] !=1 and grid[i][j]<time:
            return
        #logic 
        #reassigning the travelled node value with time 
        grid[i][j] = time
        #getting the neigbouring elements
        for direction in self.dirs:
            nr = i + direction[0]
            nc = j + direction[1]
            self.dfs(grid, nr, nc, time+1)
