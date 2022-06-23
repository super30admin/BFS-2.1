# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# BFS
# storing employee class as value in hashmap
from collections import deque


class Employee:
    def __init__(self, id, importance, subordinates):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates


class Solution:
    def getImportance(self, employees: list['Employee'], id: int) -> int:
        dictu = {}
        for e in employees:
            dictu[e.id] = e
        result = 0
        queue = deque()
        queue.append(id)
        while queue:
            pop = dictu[queue.popleft()]
            result += pop.importance
            for i in pop.subordinates:
                queue.append(i)
        return result


check = Employee(1, 5, [2, 3, 8])
check1 = Employee(2, 3, [])
check2 = Employee(3, 3, [])
check3 = Employee(8, 8, [5, 10])
check4 = Employee(5, 5, [])
check5 = Employee(10, 10, [])
print(Solution().getImportance([check, check1, check2, check3, check4, check5], 1))


# storing subordinates and importance as a list in hashmap
# from collections import deque
#
#
# class Employee:
#     def __init__(self, id, importance, subordinates):
#         self.id = id
#         self.importance = importance
#         self.subordinates = subordinates
#
#
# class Solution:
#     def getImportance(self, employees: list['Employee'], id: int) -> int:
#         dictu = {}
#         for e in employees:
#             dictu[e.id] = [e.subordinates, e.importance]
#         result = 0
#         queue = deque()
#         queue.append(id)
#         while queue:
#             pop, importance = dictu[queue.popleft()]
#             result += importance
#             for i in pop:
#                 queue.append(i)
#         return result
#
#
# check = Employee(1, 5, [2, 3])
# check1 = Employee(2, 3, [])
# check2 = Employee(3, 3, [])
# print(Solution().getImportance([check, check1, check2], 1))


# DFS
# TC: O(n); SC: O(n) for hashmap.
# class Solution:
#     def __init__(self):
#         self.dictu = {}
#         self.result = 0
#
#     def dfs(self, id):
#         # base
#         if self.dictu[id].subordinates is None:
#             return
#         # logic
#         self.result += self.dictu[id].importance
#         for i in self.dictu[id].subordinates:
#             self.dfs(i)
#
#     def getImportance(self, employees: list['Employee'], id: int) -> int:
#         self.dictu = {}
#
#         for e in employees:
#             self.dictu[e.id] = e
#         self.dfs(id)
#         return self.result
#
#
# check = Employee(1, 5, [2, 3, 8])
# check1 = Employee(2, 3, [])
# check2 = Employee(3, 3, [])
# check3 = Employee(8, 8, [5, 10])
# check4 = Employee(5, 5, [])
# check5 = Employee(10, 10, [])
# print(Solution().getImportance([check, check1, check2, check3, check4, check5], 1))
