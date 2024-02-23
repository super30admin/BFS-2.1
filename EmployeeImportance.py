'''
TC: O(n)
SC: O(n)
'''
# Definition for Employee.
from typing import List

class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates


class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        self.emap = {}
        for e in employees:
            self.emap[e.id] = e
        self.total = 0
        def dfs(root):
            if not root:
                return
            self.total += root.importance
            for candidates in root.subordinates:
                dfs(self.emap[candidates])
        dfs(self.emap[id])
        return self.total