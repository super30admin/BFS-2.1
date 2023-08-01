class Solution(object):
    def orangesRotting(self, grid):
        """
        BFS
        Time complexity: O(rows * cols), where rows is the number of rows in the grid and cols is the number of columns.
        Space complexity: O(rows * cols), for the queue and the grid.
        :type grid: List[List[int]]
        :rtype: int
        """
        rows = len(grid)
        cols = len(grid[0])
        # Define the directions: right, left, up, down
        directions = [(0, 1), (0, -1), (-1, 0), (1, 0)]

        queue = deque()  # Create a queue for BFS
        fresh = 0  # Initialize a variable to count the number of fresh oranges

        # Traverse the grid and populate the queue and count the number of fresh oranges
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == 2:  # If the orange is rotten, enqueue its position
                    queue.append((i, j))
                elif grid[i][j] == 1:  # If the orange is fresh, increment the fresh count
                    fresh += 1
        if fresh == 0:
            return 0
        time = 0  # Initialize the time variable to track the minutes elapsed

        while queue:
            size = len(queue)

            for _ in range(size):
                curr = queue.popleft()  # Dequeue an orange

                for direction in directions:
                    # Calculate the new row position
                    nr = curr[0] + direction[0]
                    # Calculate the new column position
                    nc = curr[1] + direction[1]

                    # Check if the new position is within the grid boundaries and if the orange is fresh
                    if nr >= 0 and nc >= 0 and nr < rows and nc < cols and grid[nr][nc] == 1:
                        queue.append((nr, nc))  # Enqueue the fresh orange
                        grid[nr][nc] = 2  # Mark the orange as rotten
                        fresh -= 1  # Decrement the count of fresh oranges

            time += 1  # Increment the time by 1 minute

        if fresh == 0:
            # If all oranges are rotten, return the elapsed time - 1 (as the last round is not needed)
            return time - 1

        return -1  # If there are still fresh oranges remaining, return -1 to indicate it's not possible to rot all oranges
