"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution:
    
    # DFS --> Void
    # TC: O(V+E)
    # SC: O(V+E) --> HashMap
    
    finalImportance = 0
    hashMap = dict()
    
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        
        self.finalImportance = 0
        self.hashMap = {}
        
        for employee in employees:
            self.hashMap[employee.id] = employee
            
        employee = self.hashMap.get(id)
        
        self.finalImportance += employee.importance
        self.dfs(employee)
        
        return self.finalImportance
        
    def dfs(self, employee):
        
        # Base Case
        if (employee.subordinates == []):
            return
        
        # Logic
        for subId in (employee.subordinates):
            subOrdinate = self.hashMap.get(subId)
            self.finalImportance += subOrdinate.importance
            self.dfs(subOrdinate)