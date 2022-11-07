# TC: O(n)
# SC: O(h)
# Does this code run on Leetcode: Yes
# Did you find any difficulty in coding the solution: No
class Solution:
    def getImportance(self, employees, id):
        id_to_emp = {employee.id: employee for employee in employees}
        importance = 0
        stack = [id_to_emp[id]]
        while stack:
            cur_emp = stack.pop()
            importance += cur_emp.importance
            stack.extend([id_to_emp[new_emp] for new_emp in cur_emp.subordinates])
        return importance 