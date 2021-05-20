from typing import List
from collections import deque


class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates


class Solution:
    result = 0

# Space:- O(n+m)
# Time:- O(n)
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        if employees is None or len(employees) > 0:

            mapEmployee = {}
            for node in employees:
                mapEmployee[node.id] = node

        def dfs(id: int):

            self.result += mapEmployee[id].importance
            for emp in mapEmployee[id].subordinates:
                dfs(emp)

        dfs(id)

        return self.result


    # def getImportance(self, employees: List['Employee'], id: int) -> int:
    #     if employees is None or len(employees)>0:
    #         level=deque()
    #         result=0
    #         mapEmployee={}
    #         for node in employees:
    #
    #
    #             mapEmployee[node.id]=node
    #         level.append(mapEmployee[id])
    #         while(level.__len__()>0):
    #             emp=level.popleft()
    #             result+=emp.importance
    #             for report in emp.subordinates:
    #                 level.append(mapEmployee[report])
    #
    #         return result
# Time O(n)
# space O(n/2)
if __name__ == '__main__':
    print(Solution().getImportance([[1, 5, [2, 3]], [2, 3, []], [3, 3, []]],1))