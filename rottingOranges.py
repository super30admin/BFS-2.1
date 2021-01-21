# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Had a bug where the time was consistently 
# outputting 6..it was because where I was incrementing time was within the for loop


# Your code here along with comments explaining your approach

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        """
        Should use BFS because if DFS is used it would go through all cells
        and it is possible that a cell will be counted multiple times
        
            - Queue of coordinates.
            - Need to count freshness and populate queue if we found rotten spot
            - Use size variable because there is a differentiate situation goin on
        """
        if not grid:
            return 0
        fresh = 0 
        time = 0 
        queue = deque([])
        #perform bfs on rotten parts
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    fresh += 1
                elif grid[i][j] == 2:
                    queue.append([i,j])
        
        #if there are no fresh oranges
        if fresh == 0:
            return 0 
        
        dirs = [[0,1], [0,-1], [-1,0], [1,0]] #right, left, up, down
        
        while queue:
            size = len(queue)
            
            for i in range(size):
                curr = queue.popleft()
                for direction in dirs:
                    row = direction[0] + curr[0]
                    col = direction[1] + curr[1]
                    
                    if row >= 0 and row < len(grid) and col >= 0 and col < len(grid[0]) and grid[row][col] == 1:
                        queue.append([row,col])
                        grid[row][col] = 2
                        fresh -= 1
            time += 1
        if fresh != 0:
            return -1
        
        return time - 1