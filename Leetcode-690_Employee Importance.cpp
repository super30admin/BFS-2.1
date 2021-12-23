// Time Complexity : O(M+N) // Nodes+connections
// Space Complexity : O(M) //M refers to number of employees/nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
// Definition for Employee.
class Employee {
public:
    int id;
    int importance;
    vector<int> subordinates;
};
*/

class Solution 
{
public:
    int getImportance(vector<Employee*> employees, int id) 
    {
        queue<int>q;
        unordered_map<int, Employee*> importance_map;
        // create a Hashmap to map employeeId to Employee Info for 0(1) lookup
        
        for(auto emp : employees)
        {
            importance_map[emp->id]= emp;
            if(emp->id == id) // push the employee with given ID.
              q.push(emp->id); 
        }
        
        int sum=0;
        
        while(!q.empty())
        {
            int ele = q.front();
            q.pop();
            
            Employee *obj = importance_map[ele]; // Assuming test cases are not error prone.
            sum+= obj->importance;
            
            for(auto subordinate: obj->subordinates)
                q.push(subordinate);
        }
        
        return sum;
    }
};