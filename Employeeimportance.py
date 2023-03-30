#TC-O(n)
#SC-O(n)
#logic-create a map with employee objects.Maintain a bfs list and while popping it out
#add its importance to global variable and return it
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
        d={}
        for i in employees:
            d[i.id]=i
        li=[id]
        s=0
        while li:
            l=len(li)
            for i in range(l):
                x = li.pop(0)
                x = d[x]
                s += x.importance
                subs = x.subordinates
                if subs:
                    for k in subs:
                        li.append(k)
        return s




