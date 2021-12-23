/*
// Definition for Employee.
class Employee {
public:
    int id;
    int importance;
    vector<int> subordinates;
};
*/

//Time complexity : O(n) // O(V + E)
//Space complexity : O(v)

//Approach :
            // Calculate importance of given employee id
            // Traverse through all direct and indirect subordinates using BFS and add its importance
            // Return total importance

class Solution {
public:
    int getImportance(vector<Employee*> employees, int id) {
        if(employees.size() == 0)
            return 0;
        
        map<int, Employee*> itoe;
        
        for(auto emp : employees)
        {
            itoe[emp->id] = emp;
        }
        
        queue<int> q;
        q.push(id);
        int total = 0;
        
        while(!q.empty())
        {
            int eid = q.front();
            q.pop();
            
            Employee *emp = itoe[eid];
            total += emp->importance;
            
            for(auto sub: emp->subordinates)
            {
                q.push(sub);
            }
        }
        
        return total;
    }
};