'''
// Time Complexity : 0((m*n)*(m*n)) -- end up traversing all the nodes for 1 dfs call, and
again we end up doing recursive call from different direction on the same node
// Space Complexity : 0(m*n) -- can have all the nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : (W.r.t minutes-- had to walkthrough the videos)

// Your code here along with comments explaining your approach
'''
class Solution:
    
    def __init__(self):
        
        # Initialize dirMatrix
        self.dirMatrix = [
            [0,1],   # move right
            [0,-1],  # move left
            [-1,0],  # move top
            [1,0]    # move bottom
        ]
        
    
    def dfsWay(self,matrix,row,col):
        
        # check in 4 directions
        for pair in self.dirMatrix:
            
            temp_row = pair[0] + row
            temp_col = pair[1] + col
            
            # check in-bounda range only
            if ((temp_row>=0 and temp_row < len(matrix)) and (temp_col>=0 and temp_col < len(matrix[0]))):
                # enter and check sub-conditions
                
                if matrix[temp_row][temp_col] == 0:
                    # no orange
                    continue
                    
                elif matrix[temp_row][temp_col] == 1:
                    
                    # fresh-orange, make it rotton
                    matrix[temp_row][temp_col] = matrix[row][col] + 1
                    
                    # recursive-call dfs
                    self.dfsWay(matrix,temp_row,temp_col)            

                elif matrix[temp_row][temp_col] >= 2:
                    getMin =  min(matrix[temp_row][temp_col],matrix[row][col] + 1)

                    if matrix[temp_row][temp_col] <= getMin:
                        # no-change
                        continue

                    else:
                        # we have a change   
                        matrix[temp_row][temp_col] = min(matrix[temp_row][temp_col],matrix[row][col] + 1)
                        # recursive-call dfs
                        self.dfsWay(matrix,temp_row,temp_col)

            
    def orangesRotting(self, matrix: List[List[int]]) -> int:
        # define minutes offset
        offset = 2
        
        # define minMinutes
        minMinutes = 0
        
        # perform dfs
        for i in range(0,len(matrix)):
            for j in range(0,len(matrix[0])):
                
                if matrix[i][j] == 2:
                    # perform dfs
                    self.dfsWay(matrix,i,j)
        
        # print("Mutated matrix is:\t",matrix)
        
        # Iterate the grid to get maxMinutes
        for i in range(0,len(matrix)):
            for j in range(0,len(matrix[0])):
                
                if matrix[i][j] == 1:
                    # cannot be reached
                    return -1
                
                elif matrix[i][j] == 2 or matrix[i][j] == 0:
                    continue
                
                else:
                    matrix[i][j] = matrix[i][j] - offset
                    minMinutes = max(minMinutes,matrix[i][j])
        
        return minMinutes
        