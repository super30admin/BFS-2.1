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
        
        if not employees:
            return None
        result = 0
        q = list()
        dataStore = dict()
        
        for e in employees:
            dataStore[e.id] = e

        q.append(id)
        
        while q:
            curr = q.pop(0)
            e = dataStore.get(curr)
            result += e.importance
            for value in e.subordinates:
                q.append(value)
        
        return result
            
#      BFS approach, time complexity is O(n) and space complexity is O(n)
        
        
