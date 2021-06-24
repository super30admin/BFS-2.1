"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution:
    '''
    Time Complexity: O(n) because you need to search for each employee
    Space Complexity: O(n) worst case you will need to store a dict of all employees
    '''
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        # create a dict to query the employees then complete a search
        temp_dict = {e.id: e for e in employees}
        
        # essentially here you want to complete a dfs to find each employee's subordinates
        def dfs(employee_id):
            # search for the current employee from the dict
            employee = temp_dict[employee_id]
            # get the importance of the employee + a recursive call of dfs for all employee subordinates
            return employee.importance + sum(dfs(employee_id) for employee_id in employee.subordinates)
        
        return dfs(id)