#Approach - DFS
#Time complexity : O(V+E) i.e. we are going over particular employee and then getting all the subpart of tree from it. Here vertex is employee id and E is not there as subordinates are not connected to other employee i.e. it becomes O(V)
#Space complexity : O(V) i.e.we are storing all employee id with the object in hashmap and the size of recursive stack i.e it becomes O(2V)
#Did this code successfully run on Leetcode : Yes
#youtube : https://www.youtube.com/watch?v=lMaZpCmcMfA
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        #here sptoring employee id as the key for the hashmap and emp i.e whole one object reference of the emp as the value
        hashmap = {emp.id : emp for emp in employees}
        #calling dfs function with the given id of the employee
        return self.dfs(hashmap, id)
    
    def dfs(self, hashmap : {int, 'Employee'}, id: int):
        #fetching the importance of current employee from the hashset
        result = hashmap[id].importance
        #calling the subordinates of the current employee through dfs recursive call 
        for sub in hashmap[id].subordinates:
            result += self.dfs(hashmap,sub)
        return result
