#Time completiy is O(m x n) where m and n are number of rows and columns
#Space completiy is O(m x n)
#Code ran successfully on leetcode
#No issues faced while developing the code

#Rotten oranges
import collections
class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        if(grid==None):
            return 0
        #taking the number of rows and columns
        m=len(grid)
        n=len(grid[0])
        #Storing the directions in an array
        dirs=[[-1,0],[0,-1],[1,0],[0,1]]#left up right down
        #Creating a queue and count variable which contains the count of fresh oranges
        q=collections.deque()
        count=0
        #We are adding the indexes of rotten orranges into the queue and taking the count of fresh oranges
        for i in range(0,m):
            for j in range(0,n):
                if(grid[i][j]==2):
                    q.append([i,j])
                elif(grid[i][j]==1):
                    count+=1
        #Creating the time variable to store the time
        time=0
        if(count==0):
            return 0
        while(len(q)):
            size=len(q)
            for i in range(0, size):
                curr=q.popleft()
                #For the current popped value, we are checking the values in all the four directions 
                #and we are appending them into the queue and updating the value to 2 
                for d in dirs:
                    nr=d[0]+curr[0]
                    nc=d[1]+curr[1]
                    if(nr>=0 and nc>=0 and nr<m and nc<n and grid[nr][nc]==1):
                        q.append([nr,nc])
                        grid[nr][nc]=2
                        count-=1
            #Once all are completed, we will increment time 
            time+=1

        #based on the count value we will return the time
        if(count==0):
            return time-1
        else:
            return -1


