class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        time: O(mn)
        space: O(mn)
        """
        ans = 0
        rotten = deque([])
        fresh = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 2:
                    rotten.append((i, j))
                elif grid[i][j] == 1:
                    fresh += 1

        if fresh == 0:
            return 0
        dirn = [(0, 1), (0, -1), (1, 0), (-1, 0)]      
        time = 0
        while rotten:
            size = len(rotten)
            for _ in range(size):
                cur = rotten.popleft()
                for dx, dy in dirn:
                    nx, ny = cur[0]+dx, cur[1]+dy
                    if 0 <= nx < len(grid) and 0 <= ny < len(grid[0]) and grid[nx][ny] == 1:
                        grid[nx][ny] = 2
                        fresh -= 1
                        rotten.append((nx, ny))
            
            time += 1
            if fresh == 0:
                return time     
        return -1

    def getImportance(self, employees, id):
        """
        :type employees: List[Employee]
        :type id: int
        :rtype: int
        time: O(n)
        space: O(n)
        n = total employees
        """
        id2employee = {e.id: e for e in employees}
        importance = [0]
        def helper(eid):
            importance[0] += id2employee[eid].importance
            for sub in id2employee[eid].subordinates:
                helper(sub)
        
        def helper_bfs():
            q = deque([id])
            while q:
                cur = q.popleft()
                importance[0] += id2employee[cur].importance
                for sub in id2employee[cur].subordinates:                     
                    q.append(sub)
        
        helper_bfs()
        return importance[0]