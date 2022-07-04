#Time Complexity: O(n) where n is number of employees or O(V+E)
#Space Complexity: O(n)
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
        hashmap={} #integer to employee
        result=0
        for e in employees:
            hashmap[e.id]=e
        q=deque()
        for e in employees:
            if e.id==id:
                q.append(e)
                break
        while q:
            eid=q.popleft()
            result+=eid.importance
            for subid in eid.subordinates:
                q.append(hashmap[subid])
        return result
            