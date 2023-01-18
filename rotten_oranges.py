# Time Complexity :
# O(N*M)

# Space Complexity :
# O(1) (No extra space is used - we update the board in place)

# Did this code successfully run on Leetcode :
#Yes

#We update the board based on if any of it's 4 neighbour is rotten- we do this by going over the board, updating an orange location to 3 if it's neighbours are rotten. In the second pass, we update the 3s to 2s (rotten neighbour oraanges to rotten)
#If the board does not change, then it maens no more change can happen. If there are still some non-rotten oranges, then it is impossible
#If all oranges are rotten, then we return the number of times the board was updated until it reached a non-changing state

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        repeat = self.board_update(grid)
        seconds = 0
        while repeat == False :
            seconds += 1
            repeat = self.board_update(grid)

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1 :
                    return -1

        return seconds

    def board_update(self,grid):
        repeat= True
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1 :
                    if i > 0:
                        if grid[i-1][j] == 2:
                            grid[i][j] = 3
                            repeat = False
                            continue
                    if i < len(grid) - 1 :
                        if grid[i+1][j] == 2:
                            grid[i][j] = 3
                            repeat = False
                            continue
                    if j > 0:
                        #if j > 0 :
                        if grid[i][j-1] == 2 :
                            grid[i][j] = 3
                            repeat = False
                            continue
                    if j < len(grid[0]) - 1 :
                        if grid[i][j+1] == 2 :
                            grid[i][j] = 3
                            repeat = False
                            continue

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 3 :
                    grid[i][j] = 2
        return repeat


