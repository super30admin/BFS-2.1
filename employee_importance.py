# Did this code successfully run on Leetcode : YES

# TC: O(N)
# SC: O(N)

"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""
# from collections import defaultdict
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        dic = {}
        for e in employees:
            dic[e.id] = {'imp': e.importance, 'sub': e.subordinates}
        res = 0
        def dfs(id):
            nonlocal res
            res += dic[id]['imp']
            for sub in dic[id]['sub']:
                dfs(sub)
        dfs(id)
        return res