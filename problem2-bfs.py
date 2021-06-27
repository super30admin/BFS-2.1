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
        hashmap = {}
        for emp in employees:
            hashmap[emp.id] = emp
        
        q = deque()
        q.append(id)
        
        total_importance = 0
        
        while q:
            size = len(q)
            for i in range(size):
                eid = q.popleft()
                e = hashmap[eid]
                total_importance += e.importance
                for sub in e.subordinates:
                    q.append(sub)
        return total_importance
            
#Time complexity is O(n) and space complexity is O(n)
#BFS approach used for evaluating all the subordiantes of the given id.
            