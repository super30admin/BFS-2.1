# O(N) TIME AND O(N) SPACE WHERE N IS NO.OF EMPLOYEES
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
        lookup = {}
        for emp in employees:
            lookup[emp.id] = emp
        importance = 0
        que= deque()
        que.append(id)
        while que:
            emp = lookup[que.popleft()]
            importance += emp.importance
            for subs in emp.subordinates:
                que.append(subs)
        return importance
        
        