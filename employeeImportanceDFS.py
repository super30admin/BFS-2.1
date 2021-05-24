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
        self.dataStore = dict()
        self.result = 0
        
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        
        if not employees:
            return None
        
        for e in employees:
            self.dataStore[e.id] = e
        
        self.dfs(id)
        return self.result
    
    def dfs(self, id: int):
        #base
        #logic
        curr = self.dataStore[id]
        
        self.result+=curr.importance
        
        for value in curr.subordinates:
            self.dfs(value)

#  recursive dfs solution.
# time and space complexity is O(n)
        
        
        
        
