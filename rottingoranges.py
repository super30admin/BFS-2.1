class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        q=[]
        count=0
        counttemp=0
        time=0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]==2:
                    q.append((i,j))
                    count+=1
                elif grid[i][j]==1:
                    count+=1

        
        while len(q)!=0:
            size=len(q)
            time+=1
            for i in range(size):
                counttemp+=1
                temp = q.pop(0)
                i = temp[0]
                j= temp[1]
                if i != len(grid)-1:
                    if grid[i+1][j]==1:
                        q.append((i+1,j))
                        grid[i+1][j]=2
                if i != 0:
                    if grid[i-1][j]==1:
                        q.append((i-1,j))
                        grid[i-1][j]=2
                if j != len(grid[0])-1:
                    if grid[i][j+1]==1:
                        q.append((i,j+1))
                        grid[i][j+1]=2
                if j != 0:
                    if grid[i][j-1]==1:
                        q.append((i,j-1))
                        grid[i][j-1]=2

        if count == counttemp:
            if time == 0:
                return 0
            else:
                return time - 1
        else:
            return -1

                