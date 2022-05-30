'''
// Time Complexity : 0(n) -- number of id + subbordinates or 0(v+e)
// Space Complexity : 0(n/2) --- at-max children i.e. leaf's for subbordinates for queue
                    : 0(n) -- adjacencyList
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : (W.r.t minutes-- had to walkthrough the videos)

// Your code here along with comments explaining your approach
'''

from collections import deque
"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        
        # set importance
        imp = 0
        
        # convert employees into adjacency-list
        adjacencyList = {}
        
        for emp in employees:
            if emp.id not in adjacencyList:
                adjacencyList[emp.id] = emp
        
        # perform either bfs or dfs traversal
        # **here bfs**
        
        # initialize queue
        queue = deque([])
        
        # append id to the queue
        queue.append(id)
        
        # maintain lvl
        lvl = 0
        
        # iterate while len(queue) != 0
        while len(queue)!= 0:
            
            # get the size of the queue
            size = len(queue)
            
            # iterate till count == size
            for count in range(0,size):
                
                # deque id
                ele = queue.popleft()
                
                # set the importance
                imp = imp + adjacencyList[ele].importance 
                
                # enque it's subbordinates
                for subId in adjacencyList[ele].subordinates:
                    queue.append(subId)
                
            # update the lvl
            lvl += 1
        
        # update the lvl
        lvl -= 1
        
        # print the imp 
        # print("importance is:\t",imp)
        return imp