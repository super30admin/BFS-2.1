# // Time Complexity :O(m*n)
# // Space Complexity :O(m*n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach





class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        m=len(grid)
        n=len(grid[0])
        dirs=[[0,1],[0,-1],[1,0],[-1,0]]
        fresh=0
        qr=[]
        qc=[]
        level=0
        for i in range(m):
            for j in range(n):
                if grid[i][j]==1:
                    fresh=fresh+1
                if grid[i][j]==2:
                    qr.append(i)
                    qc.append(j)
        if fresh==0:
            return 0
        while qr:
            size=len(qr)
            
            for i in range(size):
                
                r=qr.pop(0)
                c=qc.pop(0)

                for i in dirs:

                    r1=r+i[0]
                    c1=c+i[1]
                    if(r1>=0 and c1>=0 and r1<m and c1<n and grid[r1][c1]==1):
                        qr.append(r1)
                        qc.append(c1)
                        print(r1)
                        print(c1)
                        grid[r1][c1]=2
                        fresh=fresh-1
                        print(grid[r1][c1])
            level=level+1
            print(level)
        print(grid)
        if fresh==0:
            return (level-1)
        else:
            return -1
        
                    
            
            
                    
        