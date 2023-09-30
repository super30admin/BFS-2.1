"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        dic = dict()
        total = 0
        q = deque()
        for i in range(len(employees)):
            dic[employees[i].id] = employees[i]
        
        q.append(id)
        while q:
            s = len(q)
            curr = q.popleft()
            print(curr)
            val = dic[curr]
            total += val.importance
            for j in val.subordinates:
                q.append(j)
        return total
#TC: O(n)
#SC: O(n)