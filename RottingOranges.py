'''
    Time Complexity:
        O(mn) (where m = number of rows of the grid, n = number of columns of the grid)

    Space Complexity:
        O(mn) (where m = number of rows of the grid, n = number of columns of the grid)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        BFS approach.
        Put all the rotten oranges in the queue.
        Process all these oranges by marking their neighbors as rotten if they were fresh.
        If any orange is marked rotten, add it to the queue to process its neighbors too.
        If the grid still has any fresh orange left, return -1, else return the time elapsed.
'''
FRESH = 1
ROTTEN = 2
DIRECTIONS = [
    (-1, 0), (0, 1), (1, 0), (0, -1)
]

class Solution:
    def __init__(self):
        self.grid = []
        self.time = 0
        self.fresh_ct = 0
        self.q = collections.deque()

    def orangesRotting(self, grid: List[List[int]]) -> int:
        self.grid = grid
        self.find_rotten()
        self.rot_neighbors()

        return -1 if self.fresh_ct > 0 else self.time

    def find_rotten(self):
        for i, row in enumerate(self.grid):
            for j, orange in enumerate(row):
                if orange == ROTTEN:
                    self.q.append((i, j))
                elif orange == FRESH:
                    self.fresh_ct += 1

    def rot_neighbors(self):
        while self.q:
            rotten_oranges = len(self.q)
            visited = 0
            rot_neighbors = False

            while visited < rotten_oranges:
                i, j = self.q.popleft()

                for r, c in DIRECTIONS:
                    if self.rot(i+r, j+c):
                        rot_neighbors = True

                visited += 1

            if rot_neighbors:
                self.time += 1

    def rot(self, i, j):
        if i not in range(0, len(self.grid)):
            return False

        if j not in range(0, len(self.grid[i])):
            return False

        if self.grid[i][j] != FRESH:
            return False

        self.grid[i][j] = ROTTEN
        self.q.append((i, j))
        self.fresh_ct -= 1
        return True
