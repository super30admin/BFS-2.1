# Time complexity: O(n)
# Space complexity: O(n)

# The code sucessfully ran on Leetcode

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
        if employees == None or len(employees) == 0: return 0
        
        map = dict()
        
        for e in employees:
            map[e.id] = e
            
        q = []
        total = 0
        q.append(id)
        
        while q:
            eid = q.pop(0)
            emp = map[eid]
            
            total += emp.importance
            edges = emp.subordinates
            
            if edges == None: continue
                    
            for edge in edges:
                q.append(edge)
                
        
        return total
        