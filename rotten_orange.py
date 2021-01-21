class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        '''
        Time Complexity: O(n^2)
        Space Complexity: O(n^2)
        '''
        q = deque()
        o = 0
        
        for i in range(0,len(grid)):
            for j in range(0,len(grid[0])):
                if(grid[i][j]==2):
                    q.append((i,j))
                elif(grid[i][j]==1):
                    o+=1
        
        count=0
        min=-1
        if(o==0):
            return 0
        dirs = ((0,1), (0,-1), (1,0), (-1,0))
        while(len(q)>0):
            size = len(q)
            j = 0
            while(j<size):
                x = q.popleft()
                for i in dirs:
                    r = i[0] + x[0]
                    c = i[1] + x[1]
                    if(r>=0 and c>=0 and r<len(grid) and c<len(grid[0]) and grid[r][c]==1):
                        count+=1
                        grid[r][c] = 2
                        q.append((r,c))
                j+=1
            min+=1
        if(count!=o):
            return -1
        else:
            return min
