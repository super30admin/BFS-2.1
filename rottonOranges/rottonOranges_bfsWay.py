'''
// Time Complexity : 0(m*n) -- end up traversing all the nodes
// Space Complexity : 0(max(m,n)) or 0(m*n) -- 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : (W.r.t minutes-- had to walkthrough the videos)

// Your code here along with comments explaining your approach
'''
from collections import deque
class Solution:
    
    def __init__(self):
        
        # Initialize dirMatrix
        self.dirMatrix = [
            [0,1],   # move right
            [0,-1],  # move left
            [-1,0],  # move top
            [1,0]    # move bottom
        ]
        
        
    def orangesRotting(self, matrix: List[List[int]]) -> int:
        
        # Initialize queue
        queue = deque([])
        
        # Initialze rows and cols of matrix
        m = len(matrix)
        n = len(matrix[0])
        
        # fresh-oranges count
        freshOranges = 0
        
        # Iterate the matrix to get fresh-oranges count and rotton-oranges
        for i in range(0,m):
            for j in range(0,n):
                
                if matrix[i][j] == 1:
                    # Maintain fresh oranges count
                    freshOranges += 1
                
                if matrix[i][j] == 2:
                    # Rotton orange; enque to the queue
                    queue.append((i,j))
        
        # base-check
        if freshOranges == 0:
            # I dont have any freshOranges
            return 0
        
        # define minutes
        minutes = 1
        
        while len(queue) != 0:
            
            # get the size
            size = len(queue)
            
            # iterate till my i == size
            for i in range(0,size):
                
                # pop from the queue
                ele = queue.popleft()
                
                # Iterate the directionMatrix
                for pair in self.dirMatrix:
                    # set temp_row and temp_col
                    temp_i = pair[0] + ele[0]
                    temp_j = pair[1] + ele[1]

                    # check for bounds
                    if ((temp_i>=0 and temp_i < m) and (temp_j>=0 and temp_j < n)) and ((matrix[temp_i][temp_j] == 1)):
                        
                        # add the pair to the queue
                        queue.append((temp_i,temp_j))
                        
                        # make it rotton
                        matrix[temp_i][temp_j] = 2

                        # Reduce freshOranges count
                        freshOranges -= 1
                        
                        # check freshOranges
                        if freshOranges == 0:
                            return minutes
            
            # update my minutes
            minutes += 1
        
        # return the result
        if freshOranges == 0:
            return minutes
        
        else:
            return -1
                
        