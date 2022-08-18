# Time Complexity : O(n)
# Space Complexity ; O(n)
# Leetcode : Solved and submitted
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
        n = len(employees)
        data = {}
        sum_val = 0
        
        # store the objects in the Hashmap
        for i in range(n):
            data[employees[i].id] = employees[i]
        
        # start with id as the queue
        q = deque([id])
        while q:
            # pop the element from the queue
            curr = q.popleft()
            e = data[curr]
            
            # add the importance value of that employee
            sum_val += e.importance
            
            # add subordinates to the queue for that employee
            for subId in e.subordinates:
                q.append(subId)
        return sum_val
