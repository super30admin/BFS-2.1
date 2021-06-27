"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""
from collections import deque
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        if not employees: return 0
        self.hashmap = {}
        self.total_importance = 0
        for emp in employees:
            self.hashmap[emp.id] = emp
        self.dfs(id)
        return self.total_importance
    
    def dfs(self, id):
        #base 
        if self.hashmap[id].subordinates == None:
            return
        #logic
        e = self.hashmap[id]
        self.total_importance += e.importance
        for sub in e.subordinates:
            self.dfs(sub)
            
        
            
#Time complexity is O(n) and space complexity is O(n)
#DFS approach used for evaluating all the subordiantes of the given id.
            