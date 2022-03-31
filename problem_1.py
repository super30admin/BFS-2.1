#Time complexity:O(N)
#Space complexity:O(N)
#Did it run on LeetCode: Yes
class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        queue = []
        time = 0
        fresh_oranges = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 2:
                    queue.append((i,j))
                elif grid[i][j] == 1:
                    fresh_oranges += 1
        if fresh_oranges  == 0:
            return 0
        
        while queue:
            for i in range(len(queue)):
                r,c = queue.pop(0)
                dirs = [[0,1],[1,0],[-1,0],[0,-1]]
                for direct in dirs:
                    if r + direct[0]>=0 and r + direct[0] < len(grid) and c + direct[1] >=0 and c + direct[1] < len(grid[0]):
                        if grid[r + direct[0]][c+direct[1]] == 1:
                            grid[r + direct[0]][c+direct[1]] =2
                            queue.append((r + direct[0], c + direct[1]))
                            fresh_oranges -= 1
            time += 1
            
        
        if fresh_oranges>0:
            return -1
        
        return time-1
            