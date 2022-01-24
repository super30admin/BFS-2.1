
# // Time Complexity : O(V+E)
# // Space Complexity :O(V+E)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :

# Definition for a binary tree node.
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        q = list()
        q.append(id)
        result = 0
        hMap = dict()
        for employee in employees:
            hMap[employee.id] = employee
            
        while(q != []):
            size = len(q)
            for i in range(size):
                eid = q.pop(0)
                e = hMap[eid]
                result += e.importance
                for subId in e.subordinates:
                    q.append(subId)
        
        return result
        
        