#https://leetcode.com/problems/the-maze/
#https://www.thes30.com/problem/5d688ae079fd880017e4af5d
def maze(grid,start,dest): #output is bool true or false 

    m = len(grid)
    n = len(grid[0])
    q = []
    q.append([start[0],start[1]])
    print(start[0])
    grid[start[0]][start[1]] = -1
    #grid[0][1]

    dirs = [[-1,0],[0,-1],[1,0],[0,1]]
    
    while q:
        ele = q.pop(0)
        for dir1 in dirs:
            i =  ele[0]
            j =  ele[1]
            #have to keep going in same dir so we add that to i and j below until we hit a wall or out of scope
            while(i>=0 and i<m and j>=0 and j < n and grid[i][j] != 1):
                i +=  dir1[0]
                j +=  dir1[1]
            #goto the prev element of the wall or out of scope
            i -=  dir1[0]
            j -=  dir1[1]
            if(i == dest[0] and j == dest[1]):
                return True
            if(grid[i][j] == 0):
                grid[i][j] = -1
                q.append([i,j])
                
    return False
    
    #bfs(start[0],start[1],grid)
    
    
    #def bfs(i,j,grid):
        #base case 
    #    if(i<=0 or i>m or j<=0 or j>=m or grid[i][j] == 1):
    #        return
        
        
        
        
        
        







map = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]
start = [0,4]
dest = [3,2]

map1 = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]
start1 = [0,4]
dest1 = [4,4]

print(maze(map1, start1, dest1))