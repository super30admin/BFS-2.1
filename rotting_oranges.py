#time complexity:o(mXn), traversing all the elements of the matrix
#space complexity: o(mxn), for the q
#passed all cases on LeetCode:yes
#difficulty faced:
# comments:in the code
#https://leetcode.com/problems/rotting-oranges/description/

class Solution:
    def orangesRotting(self, grid: 'List[List[int]]') -> int:
        dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        m = len(grid)
        n = len(grid[0])
        freshoranges = 0
        q = []

        #this is a bfs approach so we need to find the rotten orange 1st
        #to append to the q, these rooten oranges are at level 0 from where 
        #different bfs will start, add the coordinates of rotten oranges to the q
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    q.append([i,j])
                elif grid[i][j] == 1:
                    freshoranges += 1
        if freshoranges == 0: return 0

        self.lvl = 0
        while q:
            size1 = len(q)
            for ii in range(size1):
                curr = q.pop(0)
                #print("curr value:",curr)
                #have to search for fresh orange in all 4 dirs
                for dir1 in dirs:
                    #print("curr vlaue:",curr)
                    nr = curr[0] + dir1[0]
                    nc = curr[1] + dir1[1]
                    #print("new r and new cols:",nr,nc)
                    #check if index is inbounds and nr and nc have fresh orange
                    if nr >= 0 and nr < m  and nc < n and nc >= 0 and grid[nr][nc] == 1:
                        #print("nr and nc inside if:",nr,nc)
                        q.append([nr,nc])
                        grid[nr][nc] = 2
                        freshoranges -= 1

            self.lvl += 1
        print(freshoranges)
        if freshoranges > 0: return -1
        return self.lvl-1