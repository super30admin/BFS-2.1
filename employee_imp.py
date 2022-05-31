"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

#APPROACH : first task is to understand that employees list given here is a graph and how to iterate it. 
#I created a dictionary to make an adjacency list for mapping emp.id with respective emp.object and then used BFS to find importance
#Time Complexity : O(n)
#Space Complexity: O(n)
#Did your code run on leetcode : yes

from collections import deque
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        result = 0
        emp_map = {}
        
        if(employees == None):return 0
        
        #making adjacency list
        for emp in employees:
            emp_map[emp.id] = emp
        
        queue = deque()
        queue.append(id)
        
        while(len(queue)!=0):
            current = queue.popleft()
            employee = emp_map[current]
            print(employee)
            result += employee.importance
            
            for sub in employee.subordinates:
                print(sub)
                queue.append(sub)
        return result
        
        
            
        
        
    
        
