"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""
#Time Complexity: O(n)
#Space Complexity: O(n)

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        dic = {}
        queue = []
        val = 0
        for i in employees:
            dic[i.id] = i 
        queue.append(id)
        
        while queue:
            tempid = queue.pop()
            e = dic[tempid]
            val += e.importance
            for i in e.subordinates:
                queue.append(i)
            
        return val