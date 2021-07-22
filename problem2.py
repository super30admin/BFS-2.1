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
        store=dict()
        for i in employees:
            employee,imp,sub=i.id,i.importance,i.subordinates
            store[employee]=[imp,sub]
            
        self.final=0
        def dfs(id,store,visited):
            if id not in visited:
                visited[id]=True
                self.final+=store[id][0]
                for subor in store[id][1]:
                    if subor not in visited:
                        dfs(subor,store,visited)
            
        dfs(id,store,dict())
        return self.final
    #Time O(n)- as number of employees, once visited we will not visit again
    #Space O(n)- visited arr and store
