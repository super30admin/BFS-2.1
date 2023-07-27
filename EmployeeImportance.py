"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

from ast import List


class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        d = {}
        for emp in employees:
            d[emp.id] = []
            d[emp.id].append(emp.importance)
            d[emp.id].append(emp.subordinates)
        self.imp = 0
        def helper(empId):
            # base
            if empId is None:
               return

            # main logic
            self.imp += d[empId][0]
            for v in d[empId][1]:
                helper(v)

        
        helper(id)
        return self.imp

