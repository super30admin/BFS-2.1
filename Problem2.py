'''
Time Complexity: O(n)
Space Complexity: O(n)
Run on Leetcode: YES
'''
from ast import List
from collections import deque

# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates


class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        dictSub = {}
        imp = 0
        for emp in employees:
            dictSub[emp.id] = emp
        queue = deque()
        queue.append(id)
        while(len(queue) != 0):
            curr = queue.popleft()
            emp = dictSub[curr]
            imp += emp.importance
            for eid in emp.subordinates:
                queue.append(eid)
        return imp