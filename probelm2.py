#employee importance
#space complexity: O(n)
#time compleixty: O(n) where n is the number of employees
class Solution(object):
    def getImportance(self, employees, id):
        """
        :type employees: Employee
        :type id: int
        :rtype: int
        """
        def helper(id):
            res = dic[id]
            for sub_id in sub[id]:
                res += helper(sub_id)
            return res
        
        dic = {}
        sub = {}
        for employee in employees:
            dic[employee.id] = employee.importance
            sub[employee.id] = employee.subordinates
        return helper(id)