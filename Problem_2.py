# BFS Solution
from typing import List
import queue
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates


class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        if employees == None or len(employees) == 0:
            return 0
        result = 0
        map = {}
        for e in employees:
            map[e[0]] = e
            #map[e.id] = e
        q = queue.Queue()
        q.put(id)
        while not q.empty():
            eid = q.get()
            e = map[eid]
            result += e[1]
            #result += e.importance
            #for subid in e.subordinates:
            for subid in e[2]:
                q.put(subid)
        return result

obj = Solution()
print(obj.getImportance([[1,5,[2,3]],[2,3,[]],[3,3,[]]],1))
print(obj.getImportance([[1,2,[5]],[5,-3,[]]],5))

# DFS Solution
# class Solution:
#     def getImportance(self, employees: List['Employee'], id: int) -> int:
#         if employees == None or len(employees) == 0:
#             return 0
#         self.result = 0
#         self.map = {}
#         for e in employees:
#             self.map[e.id] = e
#         self.dfs(id)
#         return self.result
    
#     def dfs(self, id: int) -> None:
#         e = self.map[id]
#         self.result += e.importance
#         for subid in e.subordinates:
#             self.dfs(subid)



# Time Complexity : O(V + E) = O(n)
# Space Complexity : O(V + E) = O(n)

