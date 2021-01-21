#Time: O(n)
#Space: O(n) 
#leetcode: yes


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
        hashmap={}
        result=0
        for e in employees:
            hashmap[e.id]=e
        q=deque()
        q.append(id)
        while(q!=deque()):
            eid=q.popleft()
            e=hashmap[eid]
            result+=e.importance
            for i in e.subordinates:
                q.append(i)
        return result
        
        