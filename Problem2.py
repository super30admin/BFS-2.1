#Time Complexity :O(n)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

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
        eMap={}
        q=deque()
        q.append(id)
        result=0
        for e in employees:
            eMap[e.id]=e

        while q:
            currEmp=q.popleft()
            e=eMap[currEmp]
            result+=e.importance
            for sub in e.subordinates:
                q.append(sub)

        return result
        