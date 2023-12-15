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
        q=[]
        hashmap = {}
        importa=0

        for emp in employees:
            hashmap[emp.id] = emp

        for j in hashmap[id].subordinates:
            q.append(j)
        importa+= hashmap[id].importance      

        while len(q)!=0:
            size = len(q)
            for i in range(size):
                temp = q.pop(0)
                print(temp)
                importa +=hashmap[temp].importance  

                for j in hashmap[temp].subordinates:
                    q.append(j)    

        return importa

        