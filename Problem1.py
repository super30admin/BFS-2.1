#Time Complexity :- O(mxn)
#Space Complexity :- O(mxn)


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        n = len(grid[0])
        m = len(grid)
        rottenLocation = []
        minutes = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    rottenLocation.append([i,j])

        while len(rottenLocation) != 0 :
            operationDone = False
            for i in range(len(rottenLocation)): 
                rottenLocationElement = rottenLocation.pop(0)
                row = rottenLocationElement[0]
                column = rottenLocationElement[1]             
                if row-1 >= 0 and grid[row-1][column] == 1:
                    rottenLocation.append([row-1, column])
                    grid[row-1][column] = 2
                    operationDone = True
                if row+1 < m and grid[row+1][column] == 1:
                    rottenLocation.append([row+1, column])
                    grid[row+1][column] = 2
                    operationDone = True
                if column-1 >= 0 and grid[row][column-1] == 1:
                    rottenLocation.append([row, column-1])
                    grid[row][column-1] = 2
                    operationDone = True
                if column+1 < n and grid[row][column+1] == 1:
                    rottenLocation.append([row, column+1])
                    grid[row][column+1] = 2
                    operationDone = True
            if operationDone:
                minutes+=1
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    return -1
        return minutes




# Approach 2 with same big O time Complexity and Space Complexity 

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        queueRottenLocation = []
        dirs = [[0,1], [0,-1],[1,0],[-1,0]]
        rows = len(grid)
        columns = len(grid[0])
        freshOrangesCount = 0

        for i in range(rows):
            for j in range(columns):
                if grid[i][j] == 2:
                    queueRottenLocation.append([i,j])
                if grid[i][j]== 1:
                    freshOrangesCount+=1
        
        if freshOrangesCount == 0:
            return 0

        level = 0
        while len(queueRottenLocation)!=0:
            size = len(queueRottenLocation)
            for i in range(size):
                curr = queueRottenLocation.pop(0)
                for dir in dirs:
                    nr = curr[0]+dir[0]
                    nc = curr[1]+dir[1]
                    if nr>=0 and nr<rows and nc>=0 and nc<columns and grid[nr][nc]==1:
                        queueRottenLocation.append([nr,nc])
                        grid[nr][nc] =2
                        freshOrangesCount-=1
            print(queueRottenLocation)
            level+=1
           
        if freshOrangesCount > 0:
            return -1
        return level-1
