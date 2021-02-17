################## Iterative solution
# Time complexity: O(n*m)
# Space complexity: O(n*m)
# Worked on leetcode: yes
# Iterative approach: This algorithm uses a BFS like approach. Firstly we search a 2 in the grid, and push it in the queue. We also maintain the number of 1's in the queue.
# Then we check its neighbors, and push the neighbors whose value is 1, into queue. We update the value from 1 to 2 of that neighbor. If the queue is not empty,
# we keep popping out the elements and pushing their neighbors whose values are 1.Finally, we check if the number of 1's in the grid is 0 or greater. If its 0, we use
# number of levels to calculate the minimum time required, else we return -1



class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if len(grid) == 0 or grid == None or len(grid[0]) == 0:
            return None

        queue = []
        fresh_count = 0
        # search 2
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    fresh_count += 1

                elif grid[i][j] == 2:
                    queue.append([i, j])

        directions = [[-1, 0], [1, 0], [0, 1], [0, -1]]
        level = 0
        while (len(queue) > 0):
            size = len(queue)

            for x in range(size):
                pair = queue.pop(0)

                for direction in directions:
                    i = pair[0] + direction[0]
                    j = pair[1] + direction[1]

                    if (i >= 0 and i < len(grid) and j >= 0 and j < len(grid[0]) and grid[i][j] == 1):
                        grid[i][j] = 2
                        queue.append([i, j])
                        fresh_count -= 1

            level += 1

        print(fresh_count)
        if fresh_count != 0: return -1

        if level > 0:
            return level - 1
        else:
            return level