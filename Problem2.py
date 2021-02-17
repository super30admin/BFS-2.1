#Time Complexity - O(n)
#Space Complexity - O(n) "Worst Case"
#Made a HashMap with id as key and value as employee object
#Stored value of key in queue.Till the queue is not emmpty run the loop.
#pop first element of queue and store its subbordinate in a temp list and add importance to imp variable.
#transfer temp list values in queue that indicates next subbordinates and again run loop till queue is empty
#return imp variable that stores total sum
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
     
        if employees == None and len(employees) == 0:
            return
        map_items = {}
        
        for emp in employees:
            map_items[emp.id] = emp
        queue = []
        queue.append(id)
        imp = 0
        
        while(len(queue) > 0):
            val = queue.pop(0)
            subb = map_items[val].subordinates
            imp += map_items[val].importance
            for sub in subb:
                queue.append(sub)
                
        return imp
            
                