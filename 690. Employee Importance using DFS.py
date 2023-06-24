# Solution using DFS
# Time and space complexity : O(V+E) & O(V)
"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""
from queue import Queue
class Solution:
    total = 0
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        self.hashmap = {}
        for e in employees:     # Storing a pair of employee id to a reference pointer of employees (eid:e*)
            self.hashmap[e.id]= e 
        self.dfs(id)                # Running a DFS on ID
        return self.total
    def dfs(self,id: int):
        e = self.hashmap[id]    # Getting employee reference for corresponding eid
        self.total+=e.importance    
        for subId in e.subordinates: # Storing the subordinates id for every employee and running DFS for them
            self.dfs(subId)

