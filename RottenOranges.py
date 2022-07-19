class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        
        #BFS
        ''' "ALL" the nodes/ oranges that are rotten has to be kept in the queue first.
        Then put the neighbors into the queue and while adding it into the queue make it rotten, that is change its state.
        '''
        #Time Complexity: O(mn)
        #Sapace Complexity: O(mn)
        
        #Edge case
        if len(grid)==0:
            return -1
        
        m=len(grid)
        n=len(grid[0])
        
        #Direction array [up, left, down, right]
        dirs=[[-1,0],[0,-1],[1,0],[0,1]]
        
        #We have to maintain a queue of arrays as we are adding pair of row and col index
        queue=deque()
        
        #In order to get the fresh count we need to go over all the elements in the grid
        fresh=0
        for i in range(m):
            for j in range(n):
                #if rotten add to queue
                if grid[i][j] == 2:
                    queue.append([i,j])
                elif grid[i][j]==1:
                    fresh+=1
        #Process the queue
        if fresh==0:
            return 0
        time=0
        while len(queue)!=0:
            size=len(queue)
            #process the level
            for i in range(size):
                curr=queue.popleft()
                #print(curr)
                #Loop through the directions
                for direction in dirs:
                    #print(fresh)
                    nr=direction[0]+curr[0]
                    nc=direction[1]+curr[1]
                    print(nr,nc)
                    #check bounds
                    if nr >=0 and nc>=0 and nr < m and nc < n and grid[nr][nc] ==1:
                        #Make if rotten and add it to the queue
                        grid[nr][nc]=2
                        fresh-=1
                        queue.append([nr,nc])
                        
            time+=1

        if fresh != 0:
            return -1
        else:
            return time-1
                    
                    
        
        
