# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution:
    def getImportance(self, employees, id: int) -> int:
        
        # hashmap to get employess quickly using id
        emap = {emp.id: emp for emp in employees }
        
        def dfs(emp_id):
            employee = emap[emp_id] # get employee from hashmap
            
            # return total importance with all their subordinates
            return (employee.importance + sum(dfs(emp_id) for emp_id in employee.subordinates))
        return dfs(id)