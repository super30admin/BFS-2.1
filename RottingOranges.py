# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :

# Your code here along with comments explaining your approach
# Using BFS. Initialize a queue and iterate over the grid to find the rotten oranges and append the index i and j it to queue
# Else if there is a fresh orange increment fresh by one
# Until queue is empty iterate over the queue and pop the indexes i and j
# Initialize a list of tuples with the 4 directions or neighbors
# Iterate over the neighbors and get the row and col index by adding i and j with each neighbor
# Check the boundaries of row and col and check if the orange is fresh then append it to queue and make it rotten and decrement the fresh by one
# Increment the time by one until for each level until the queue is not empty
# Then check if the fresh is not 0 return -1 else return time-1


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if not grid:
            return None
        fresh = 0
        time = 0
        queue = deque([])
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 2:
                    queue.append((i, j))
                elif grid[i][j] == 1:
                    fresh += 1
        if fresh == 0:
            return 0
        while queue:
            neighbors = [(0, 1), (1, 0), (0, -1), (-1, 0)]
            for i in range(len(queue)):
                i, j = queue.popleft()
                for neighbor in neighbors:
                    row = i + neighbor[0]
                    col = j + neighbor[1]
                    if row >= 0 and row < len(grid) and col >= 0 and col < len(
                            grid[0]) and grid[row][col] == 1:
                        queue.append((row, col))
                        grid[row][col] = 2
                        fresh -= 1
            time += 1
        if fresh != 0:
            return -1
        else:
            return time - 1
