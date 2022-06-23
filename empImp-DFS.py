# Time Complexity: O(n)
# Space Complexity: O(n)
  
"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution:
    def __init__(self):
        self.res = 0
        self.iMap = dict()
        
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        
        for e in employees:
            self.iMap[e.id] = e
            
        self.dfs(id)
        return self.res
        
    def dfs(self, id):
        
        emp = self.iMap[id]
        self.res += emp.importance
        
        for e in emp.subordinates:
            self.dfs(e)
            
        
