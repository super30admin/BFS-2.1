# TC - O(m^2*n^2) in Method 2
# SC - O(m*n) in Method 2
# In method 1 - BFS, we add indexes of all rotten oranges to the q, and also get count of fresh mangoes.
# Then, run BFS and visit the all kids of these rotten ones by checking all 4 directions and mark fresh oranges as rotten and decrease the coutn of fresh and also add them to the q. This is 1 unit of time. Do this till q is empty.
# In the end, if fresh=0 return time-1 else -1

#In Method 2 - DFS, we add any 1 of the rotten mangoes index and start DFS. Here, instead of marking the fresh as rotten we use an offset of 2 on all elements. 
# Now, we visit one of the rotten's neighbour and check if value there is less than current time, if not change it and start a new DFS. Else, return to previous DFS.
#In the end, all elements will have the least amount of time for them to go rotten, so we take the max of these values and return max_val-2 (offset)


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        #Method 1 - BFS - TC and SC both O(m*n)
        # if not grid: return -1
        # q=deque()
        # m=len(grid)
        # n=len(grid[0])
        # dirs=[[-1,0],[0,-1],[1,0],[0,1]]
        # fresh=0

        # for i in range(m):
        #     for j in range(n):
        #         if grid[i][j]==2: #for ALL 2s are added as this is BFS
        #             q.append([i,j])
        #         elif grid[i][j]==1:
        #             fresh+=1
        # if fresh==0: return 0
        # time=0
        # while q:
        #     size=len(q)
        #     for i in range(size):
        #         curr=q.popleft()
        #         for d in dirs: #for current, explore all 4 directions
        #             nr=curr[0]+d[0]
        #             nc=curr[1]+d[1]

        #             if 0<=nr<m and 0<=nc<n and grid[nr][nc]==1:
        #                 q.append([nr,nc])
        #                 grid[nr][nc]=2 #mark the neighbouring 1s as 2 and decrease fresh count
        #                 fresh-=1
        #     time+=1
        
        # if fresh==0: return time-1 #time-1 cause in the end we will have an additional round of iteration even after all fresh ones are marked as rotten.
        # return -1 #if fresh isn't 0 return -1

        #DFS with inplace offset of 2
        if not grid:
            return -1

        m = len(grid)
        n = len(grid[0])
        fresh = 0
        result = 2 #we are offsetting all grid elements by 2 instead of using another visited matrix
        dirs = [[-1, 0], [0, -1], [1, 0], [0, 1]]

        def dfs(grid, row, col, time):
            # base
            if row < 0 or col < 0 or row == m or col == n: #matrix bounds check
                return
            if grid[row][col] != 1 and grid[row][col]<time:  #if grid already has time less than current time, return. But this will mess with all 1s, so make sure it's not 1 and grid val<time
                return

            # logic
            grid[row][col] = time
            for d in dirs:  # for current, explore all 4 directions
                nr = row + d[0]
                nc = col + d[1]
                dfs(grid, nr, nc, time + 1)

        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2: #for ANY 2s call dfs 
                    dfs(grid, i, j, 2)

        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1: #now, after all dfs is done, if still there is a 1, return -1
                    return -1
                result = max(result, grid[i][j]) #getting max from entire matrix for the time

        return result - 2 # -2 for the offset done intially.
