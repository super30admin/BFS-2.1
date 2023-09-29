# Time Complexity: O(m*n)
# Space Complexity: O(m*n)

class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        queue = collections.deque()
        m = len(grid)
        n = len(grid[0])
        fresh = 0
        dir = [[0,-1], [0,1], [1,0], [-1,0]]
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    queue.append([i,j])
                elif grid[i][j] == 1:
                    fresh +=1
        if fresh == 0:
            return 0
        step=0
        while queue:
            for i in range(len(queue)):
                curr_pos = queue.popleft()
                for d in dir:
                    newRow = curr_pos[0]+d[0]
                    newCol = curr_pos[1]+d[1]

                    if 0<=newRow<m and 0<=newCol<n and grid[newRow][newCol] == 1:
                        grid[newRow][newCol] = 2
                        queue.append([newRow,newCol])
                        fresh -=1
            step+=1
        if fresh == 0:
            return step-1
        return -1



