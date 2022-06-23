# Time Complexity: O(n)
# Space Complexity: O(n)
  
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
    # def __init__(self):
    #     self. res = 0
    #     self.iMap = dict()
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        
        res = 0
        iMap = dict()
        
        for e in employees:
            iMap[e.id] = e
        
        q = deque()
        q.append(id)
        
        while q:
            curr = q.popleft()
            emp = iMap[curr]
            res += emp.importance
            
            for e in emp.subordinates:
                q.append(e)
        
        return res
            
        
        
        
        
