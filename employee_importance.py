# Time complexity:  O(V + E) - No. of vertices as employees
# Space complexity:  O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
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
        result = 0
        emap = {}
        
        # add employee in emap dic id as key and e as value
        # Note: It's just pointing through reference
        for e in employees:
            emap[e.id] = e
        
        #deque since add and remove from the end and front is O(1) in python
        queue = deque()
        queue.append(id)
        
        # till queue not none
        while queue:
            eid = queue.popleft()
            # employee has all id, importance and subordinate
            employee = emap[eid]
            
            # access importance through employee and append to result
            result += employee.importance
            
            # check for subordinates if exists add it into queue
            for subID in employee.subordinates:
                queue.append(subID)
                
        return result
        
        
# DFS Approach
class Solution(object):
    #DFS Approach 
    def getImportance(self, employees, id):
        """
        :type employees: List[Employee]
        :type id: int
        :rtype: int
        """
        self.result = 0
        self.emap = {}
        for e in employees:
            self.emap[e.id] = e
        self.dfs(id)
        return self.result
        #print(emap) # it's object acting as pointer
        #print(emap.keys())
        #print(emap.values()) it's object 
        
        
    def dfs(self, eid):
        employee = self.emap[eid]
        self.result += employee.importance
        for subID in employee.subordinates:
            self.dfs(subID)
