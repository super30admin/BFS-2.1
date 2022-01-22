'''
TC: O(N)
SC: O(N)
'''
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
        hmap = dict()
        
        for empData in employees:
            hmap[empData.id] = empData
            
        root = hmap[id]
        queue = deque()
        
        queue.append(root)
        s = 0
        
        while queue:
            top = queue.popleft()
            s += top.importance
            
            for c in top.subordinates:
                queue.append(hmap[c])
        
        return s
            
        
        