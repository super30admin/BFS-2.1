'''
    Time Complexity:
        O(V+E) (where V = number of employees, E = number of employee-subordinate relationships)

    Space Complexity:
        O(V) (where V = number of employees)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        DFS approach.
        Start from the given id and keep adding importances of all of its subordinates.
'''

"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution:
    def __init__(self):
        self.employee_map = {}
        self.total_imp = 0

    def getImportance(self, employees: List['Employee'], id: int) -> int:
        self.employee_map = {e.id: e for e in employees}
        self.calc_imp(id)

        return self.total_imp

    def calc_imp(self, id):
        e = self.employee_map[id]
        self.total_imp += e.importance
        for sub in e.subordinates:
            self.calc_imp(sub)
