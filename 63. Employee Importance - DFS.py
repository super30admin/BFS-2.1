from collections import deque

"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""


# DFS
class Solution:
    result = 0
    m = {}

    def getImportance(self, employees: List['Employee'], id: int) -> int:
        self.result = 0
        self.m = {}
        for e in employees:
            self.m[e.id] = e

        self.dfs(id)
        return self.result

    def dfs(self, eid):

        e = self.m.get(eid)
        self.result += e.importance

        for subid in e.subordinates:
            self.dfs(subid)

# DFS
# TC = O(V + E)
# Space complexity : O(V).
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
