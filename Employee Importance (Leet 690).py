#Time complexity: O(n)
#Space complexity: O(h)

"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution:
    imp = 0
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        if employees is None or len(employees) == 0:
            return 0
        
        temp = dict()
        for i in employees:
            temp[i.id] = i
        
        self.imp = 0
        self.dfs(employees,id,temp)
        return self.imp
    
    def dfs(self, employees, id, temp):
        # if temp[id].subordinates is None:
        #     return
        
        self.imp += temp[id].importance
        for i in temp[id].subordinates:
            self.dfs(employees, i, temp)


#Time complexity: O(n)
#Space complexity: O(n)

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
        
        if employees is None or len(employees) == 0:
            return 0
        
        temp = dict()
        for i in employees:
            temp[i.id] = i
        
        q = list()
        q.append(id)
        imp = 0
        while len(q) != 0:
            curr = q.pop(0)
            imp += temp[curr].importance
            for i in temp[curr].subordinates:
                q.append(temp[i].id)
        return imp