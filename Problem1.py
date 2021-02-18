# Time Complexity :O(n)
# Space Complexity :O(n)
#  Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no
#Leetcode : 994

# You are given a data structure of employee information, which includes the employee's unique id, their importance value and their direct subordinates' id.

# For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. They have importance value 15, 10 and 5, respectively. Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3 is also a subordinate of employee 1, the relationship is not direct.

# Now given the employee information of a company, and an employee id, you need to return the total importance value of this employee and all their subordinates.
#
# Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
# Output: 11
# Explanation:
# Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3. They both have importance value 3. So the total importance value of employee 1 is 5 + 3 + 3 = 11.


from collections import deque


# Definition for Employee.
class Employee(object):
    def __init__(self, id, importance, subordinates):
        # #################
        # :type id: int
        # :type importance: int
        # :type subordinates: List[int]
        # #################
        self.id = id
        self.importance = importance
        self.subordinates = subordinates



class Solution(object):
    def getImportance(self, employees, id):
        """
        :type employees: List[Employee]
        :type id: int
        :rtype: int
        """

        myMap = {}
        for each in employees:
            myMap[each.id] = each

        queue = deque()
        queue.append(myMap[id])

        total = 0
        while queue:
            currentEmployee = queue.popleft()
            total += currentEmployee.importance

            for each in currentEmployee.subordinates:
                queue.append(myMap[each])

        return total


emp1 = Employee(1,5,[2,3])
emp2 = Employee(2,3,[])
emp3 = Employee(3,3,[])

print(Solution().getImportance([emp1,emp2,emp3],1))



