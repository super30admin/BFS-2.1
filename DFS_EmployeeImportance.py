# // Time Complexity : O(V+E)
# // Space Complexity :O(V+E)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :

# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates

class Solution:
    hMap = dict()
    result = 0
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        self.hMap = {}
        for employee in employees:
            self.hMap[employee.id] = employee
        
        self.dfs(id)
        return self.result
    
    def dfs(self,id):
        # logic
        e = self.hMap[id]
        self.result += e.importance
        for subId in e.subordinates:
            self.dfs(subId)
        
        
        
        