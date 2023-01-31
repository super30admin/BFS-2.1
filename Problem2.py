# Time Complexity : O(V+E) V is the number of Vertices in hashMap and E is the edge which is each elements subordinates
# Space Complexity : O(V)  Number of vertices of hashMap
# Did this code successfully run on Leetcode :  Yes 
# Any problem you faced while coding this : No

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
        hashMap = {}
        for emp in employees:
            hashMap[emp.id] = emp
        
        queue = []
        total = 0
        queue.append(id)
        # while(len(queue)>0):
        #     size = len(queue)           
        #     for i in range(size):
        #         curr = queue.pop(0)
        #         emp = hashMap.get(curr)
        #         total += emp.importance
        #         queue += emp.subordinates
        
        while(len(queue)!=0):
            curr = queue.pop(0)
            emp = hashMap.get(curr)
            total += emp.importance
            edges = emp.subordinates
            if len(edges) ==0:
                continue
            for edge in edges:
                queue.append(edge)
        
        return total



##Another approach :
#Same Time complexity as above

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
        empLen = len(employees)
        queue = None
        value = 0
        for i in range(empLen):
            if employees[i].id == id:
                queue = employees[i].subordinates
                value = employees[i].importance
        
        if len(queue) == 0:
            return value
        
        while len(queue)!=0:
            size = len(queue)
            for i in range(size):
                curr = queue.pop(0)
                for i in range(empLen):
                    if employees[i].id == curr:
                        value += employees[i].importance
                        if len(employees[i].subordinates) > 0:
                            queue= queue + employees[i].subordinates
        return value




        
