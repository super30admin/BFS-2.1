#Approach - BFS
#Time complexity : O(m*n) i.e. we are going over all elements in the grids only once if it is rotten and fresh are changed only once
#Space complexity : O(m*n) i.e. number of index pair of rotten grid added to the queue at each level and when all oranges are rotten initially then it is worst case and queue will have all the index pair of whole grid
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
        queue = deque()
        #defining fresh for checking over the number of fresh in the grid 
        fresh = 0
        #iterating over the for loop for counting number of fresh oranges in the grid so that at the end we can check if all are rotten and if any left to rotten then we will return -1
        #checking the rotten oranges in the grid and adding all of them inside the queue for further rotting the oranges
        for i in range(m):
            for j in range(n):
                #if the oranges are rotten then putting the index of the grid in the queue for further rotting the oranges
                if grid[i][j] ==2:
                    queue.append((i,j))
                #if we find any fresh orange in the grid then we will increase the count of the fresh
                if grid[i][j] ==1:
                    fresh +=1
        #handling the edge case if there is no fresh orange found then we don't have to check for the queue
        if fresh == 0:
            return 0
        #taking a variable to store the time so that at each level it gets incremented
        time = 0
        #iterating the while loop till the queue gets empty
        while queue:
            #taking the size for checking the size of the queue for processing each level
            size = len(queue)
            for i in range(size):
                #popping out the first element index of the queue
                current =[]
                current = queue.popleft()
                #processing the neighbouring element of the current pop i.e. iterating over the neighbours
                for direction in self.dirs:
                    nr = current[0] + direction[0]
                    nc = current[1] + direction[1]
                    #checking the bounds of neighbouring row and column and further while iterating over the neighbouring elements checki if there is fresh oranges present if it is present than changing the it to rotten and putting the fresh count less
                    if nr>=0 and nc>=0 and nr<m and nc<n and grid[nr][nc]==1:
                        grid[nr][nc] = 2
                        fresh -=1
                        #after converting to rotten orange then we will put it inside the queue
                        queue.append((nr,nc))
            time+=1
        #checking after going over the grid is their any fresh orange left to be rotten if yes then we will return -1 else the time it took to rotten all the oranges
        if fresh == 0:
            #once the last last level is done at that time still time is incremented by 1 so returning time-1
            return time-1
        return -1
