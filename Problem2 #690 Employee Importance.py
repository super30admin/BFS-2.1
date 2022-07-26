# Time Complexity: O(n)
# Space Complexity: O(n)

"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

import collections


class Solution:
    #adj list
    def getImportance(employees, id):
        if employees is None or len(employees) == 0:
            return 0
        
        totalImportance = 0
        hashMap = {}
        for e in employees:
            hashMap[e[id]] = e

        # BFS
        q = collections.deque()
        q.append(id)

        while q:
            currEmployee = q.popleft()
            emp = hashMap[currEmployee]
            totalImportance += emp[importance]
            if emp[subordinates] is None:
                continue
            for sub in emp[subordinates]:
                q.append(sub)

        return totalImportance 