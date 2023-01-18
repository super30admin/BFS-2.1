# Time Complexity :
# O(N)

# Space Complexity :
# O(N)

# Did this code successfully run on Leetcode :
#Yes


#We first find the employee whose ID is given. We also create a map of ID -> employee
#We then go through this employee and it's subordinates in a BFS manner - the employee and all their children and all their children until the end and add the importances
#Then, we return the total importance at the end

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
        self.queue = []
        employee_map = {}

        for employee in employees:
            if employee.id == id :
                self.queue.append(employee)
            employee_map[employee.id] = employee
            
        return_total = 0
        while (len(self.queue) != 0):
            curr_elem = self.queue.pop(0)
            return_total += curr_elem.importance
            for elem in curr_elem.subordinates:
                self.queue.append(employee_map[elem])
        
        return return_total


