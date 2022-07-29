'''

## Problem 994: Rotting Oranges

## Author: Neha Doiphode
## Date:   07-26-2022

## Description:
    You are given an m x n grid where each cell can have one of three values:
        0 representing an empty cell,
        1 representing a fresh orange, or
        2 representing a rotten orange.

        Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
        Return the minimum number of minutes that must elapse until no cell has a fresh orange.
        If this is impossible, return -1.

## Examples:
    Example 1:
        Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
        Output: 4

    Example 2:
        Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
        Output: -1
        Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten,
                     because rotting only happens 4-directionally.

    Example 3:
        Input: grid = [[0,2]]
        Output: 0
        Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.

## Constraints:
    m == grid.length
    n == grid[i].length
    1 <= m, n <= 10
    grid[i][j] is 0, 1, or 2.

## Time complexity: Please refer to doc-strings of respective approaches used below to solve the problem.

## Space complexity: Please refer to doc-strings of respective approaches used below to solve the problem.

'''

from typing import List, Optional
from queue import Queue

def get_input():
    print("Enter the number of rows on the grid of oranges: ", end = "")
    rows = int(input())
    print("Enter the number of columns on the grid of oranges: ", end = "")
    columns = int(input())
    input_matrix = []
    print("Enter values on the grid row by row.")
    print("0 represents empty cell, 1 represents fresh orange, 2 represents rotten orange")
    print("Enter elements(0 or 1 or 2) in each row. Hit ENTER after each entry.")
    for row in range(rows):
        l = []
        print(f"Row {row + 1}: ")
        for column in range(columns):
            inp = int(input())
            l.append(inp)
        input_matrix.append(l)

    return input_matrix

class Solution:
    def orangesRotting_BFS(self, grid: List[List[int]]) -> int:
        '''
        ## Approach:
            In the problem, we have connected components type of situation.
            As, one rotten orange is responsible for rotting its vertical and horizontal neighbors.
            Hence, we have to choose some sort of search/type of traversal.

            With BFS, we could rot multiple oranges in one pass. Hence, it could save a lot of time.
            With DFS, we dump the parent and move to child, we will be starting a DFS for every rotten orange,
                      so time units will also increase with each child processed.

        ## Time complexity : O(m * n), since we are processing m * n cells.
                                       Also, at the max m * n elements can go in the queue.
                                       For oranges getting rotten in 1 pass, we proces m * n cells
                                       Lets say we need to make 2 such passes to rot all oranges.
                                       So, it will be O(2 * (m * n)) ~= O(m * n), asymptotically.

        ## Space complexity: O(m * n), At the max queue size will be m * n.

        '''
        if len(grid) == 0:
            # No grid, no time required
            return 0

        fresh = 0
        q = Queue()
        m = len(grid)
        n = len(grid[0])
                #right    #left   #bottom  #top
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]

        # Start processing the grid
        for row in range(m):
            for column in range(n):
                # count fresh oranges first
                # Also, put cells of current rotten oranges in the queue
                if grid[row][column] == 1:
                    fresh += 1

                elif grid[row][column] == 2:
                    q.put([row, column])


        # After doing basic processing, if we come to know that given input does not contain any fresh orange,
        # we don't need to do anything.
        if fresh == 0:
            return 0

        # initialize time units as 1 because at this point, the assumption is that, queue is already filled in by
        # basic processing of the matrix that we did above.
        time = 0
        size = 0

        # Now, start the actual BFS
        while not q.empty():
            size = q.qsize()
            for _ in range(size):
                current = q.get()
                # Rot neighboring oranges with the help of directions array
                for direct in dirs:
                    nr = current[0] + direct[0]
                    nc = current[1] + direct[1]
                    # check if the computed cell is on the grid and valid
                    if nr >= 0 and nr < m and nc >= 0 and nc < n and grid[nr][nc] == 1:
                        grid[nr][nc] = 2
                        q.put([nr, nc])
                        fresh -= 1
            time += 1

        if fresh != 0:
            return -1

        return time - 1

# Driver code
solution = Solution()
grid = get_input()
print(f"Input grid of oranges: {grid}")
print("If output = -1, means it is impossible to convert all fresh oranges into rotten oranges.")
print(f"Using BFS: Minimum number of minutes that must elapse until no cell has a fresh orange: {solution.orangesRotting_BFS(grid)}")
