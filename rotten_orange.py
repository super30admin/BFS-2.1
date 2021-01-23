# Time Complexity : O(M * N)
# Space Complexity : O(M * N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        if grid == None or len(grid) == 0:
            return 0
        fresh = 0
        row = len(grid)
        col = len(grid[0])
        
        # initial way of process add rotten to queue and increment fresh
        queue = deque()
        for r in range(row):
            for c in range(col):
                if grid[r][c] == 2:
                    queue.append((r,c)) 
                elif grid[r][c] == 1:
                    fresh += 1
       
        # if fresh == 0 then return 0      
        if fresh == 0:
            return 0
        # setting time to 0
        time = 0
        # directions
        directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]
        while queue:
            queue_len = len(queue)
            for i in range(queue_len):
                #from queue we pop a tuple which is (r, c) from that we visit all the directions in dir array which is of the format (r,c) so we add that to existing direction and move to that
                curr = queue.popleft()
                for dir in directions:
                    r = dir[0] + curr[0]
                    c = dir[1] + curr[1]
                    # boundary check
                    if r >= 0 and r < row and c >= 0 and c < col and grid[r][c] == 1:
                        # rotten the oranges and add to queue 
                        grid[r][c] = 2
                        queue.append((r,c))
                        # decrement fresh one
                        fresh -= 1
                        
            time += 1
        
        # time - 1 since we processed one step ahead
        if fresh != 0:
            return -1
        return time - 1
