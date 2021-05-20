from typing import List
from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if grid is None or len(grid[0])==0: return 0
        rottenapple=deque()
        fresh=0
        for rowindex in range(len(grid)):
            for columnindex in range(len(grid[0])):
                if grid[rowindex][columnindex]==2:
                    rottenapple.append([rowindex,columnindex])


                elif grid[rowindex][columnindex]==1:
                    fresh+=1

        if fresh==0: return 0
        dirs=[[1,0],[-1,0],[0,1],[0,-1]]
        time=0

        while rottenapple.__len__()>0:
            size=rottenapple.__len__()
            for node in range(size):
                #print(rottenapple.get())
                sample=rottenapple.popleft()



                rotten_row,rotten_column=sample[0],sample[1]


                for coordinate in dirs:
                    row=coordinate[0]+rotten_row
                    column=coordinate[1]+rotten_column
                    if row<len(grid) and row >=0 and column<len(grid[0]) and column >=0 and grid[row][column]==1 :
                        grid[row][column]=2
                        rottenapple.append([row,column])
                        fresh-=1

            time+=1
        if fresh > 0: return -1

        return time -1

















# space:- O(Mn)
# Time:- O(m)



if __name__ == '__main__':
    #x,y=(23,78)

   print(Solution().orangesRotting([[2,1,1],[1,1,0],[0,1,1]]))


