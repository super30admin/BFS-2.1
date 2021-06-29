#Time complexity for put and get: O(n)
#Space complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        q = deque()
        fresh = 0
        
        for i in xrange(len(grid)):
            for j in xrange(len(grid[0])):
                if grid[i][j] == 1:
                    fresh +=1
                if grid[i][j] == 2:
                    q.append((i,j))
        if fresh == 0:
            return 0
        dirs = [(-1,0),(0,-1),(1,0),(0,1)]
        time = 0
        while q:
            size = len(q)
            for i in xrange(size):
                node = q.popleft()
                for dirn in dirs:
                    r = node[0]+dirn[0]
                    c = node[1]+dirn[1]
                    if r>=0 and r<len(grid) and c>=0 and c<len(grid[0]) and grid[r][c] == 1:
                        grid[r][c] = 2
                        fresh -= 1
                        q.append((r,c))
            time += 1
        if fresh != 0:
            return -1
        return time-1