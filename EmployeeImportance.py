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
        
        dic = {}
        for e in employees:
            dic[e.id] = e
            
        queue = deque()
        queue.append(dic[id])
        result = 0
        while queue:
            temp = queue.popleft()
            result += temp.importance
            for i in temp.subordinates:
                queue.append(dic[i])
        
        return result