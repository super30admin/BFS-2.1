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
        if employees == None or len(employees)==0:return 0
        map1={}
        for e in employees:
            map1[e.id]=e

        total=0
        q=[]
        q.append(id)
        while(len(q)!=0):
            curr=q.pop(0)
            emp=map1.get(curr)
            total=total+emp.importance
            for juniors in emp.subordinates:
                    q.append(juniors)
        return total
        