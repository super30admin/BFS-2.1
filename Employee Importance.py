"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""


# Time complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:

        # BFS APPROACH
        # hmap = {}
        # for emp in employees:
        #     hmap[emp.id] = emp

        # # print(hmap)

        # result = 0
        # dq = collections.deque()
        # dq.append(hmap[id])

        # while dq:
        #     temp = dq.popleft()
        #     # print(dq)
        #     result += temp.importance
        #     for subor in temp.subordinates:
        #         dq.append(hmap[subor])
        # return result

        # DFS APPROACH
        hmap = {}
        for emp in employees:
            hmap[emp.id] = emp
        global result
        result = 0

        def dfs(emp):
            global result
            result += emp.importance
            for subor in emp.subordinates:
                dfs(hmap[subor])

        dfs(hmap[id])
        return result