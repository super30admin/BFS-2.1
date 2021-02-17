"""
994. Rotting Oranges
Time Complexity - O(n*m)
Space Complexity -O(n*m)
First find index of rotten oranges and find number of fresh orange
Using BFS concept finding adjacent oranges to rotten orange index values store in queue.
Change adjacent orange value to rotten orange
If fresh is not equal to 0
    return -1
If level is greater than 1
    level - 1
else 
    return 0
"""
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if grid == None or len(grid) == 0 or grid[0] == None or len(grid[0]) == 0:
            return 
        fresh = 0
        queue = []
        
        # Find index of rotten oranges in given input and counting number of fresh oranges in input
        for i in range(0,len(grid)):
            for j in range(0,len(grid[0])):
                if  grid[i][j] == 2:
                    queue.append((i,j))
                elif grid[i][j] == 1:
                    fresh += 1
        
        # Traversing to find adjacent oranges to fresh oranges and calculate minutes
        level = 0
        direction = [(-1,0),(0,1),(1,0),(0,-1)]
        while (len(queue) > 0):
            size = len(queue)
            for i in range(size):
                temp = queue.pop(0)
                for dir_val in direction:
                    r = temp[0] + dir_val[0]
                    c = temp[1] + dir_val[1]
                    if r >= 0 and r < len(grid) and c >= 0 and c < len(grid[0]) and grid[r][c] == 1:
                        queue.append((r,c))
                        grid[r][c] = 2
                        fresh -= 1
            level += 1
        
        # Return value
        if fresh != 0:
            return -1
        if level > 0 :
            return level-1
        return 0