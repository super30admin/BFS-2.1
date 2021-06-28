// Time Complexity : O(n)
// Space Complexity :  O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this - 

/*
// Definition for Employee.
class Employee {
public:
    int id;
    int importance;
    vector<int> subordinates;
};
*/

class Solution {
public:
    int get_idx(vector<Employee*> &employees, int id)
    {
        for(int i = 0; i < employees.size(); i++)
        {
            if(employees[i]->id == id)
            {
                return i;
            }
        }
        
        return -1;
    }
    
    int getImportance(vector<Employee*> employees, int id) {
        
        queue<Employee*> q;
        
        int length = employees.size();
        
        vector<int> visited(length);
        
        for(int i = 0; i < length; i++)
        {
            visited[i] = 0;
        }
        
        int total_imp = 0;
        
        int idx = get_idx(employees, id);
        
        q.push(employees[idx]);
        
        while(!q.empty())
        {
            Employee* temp = q.front();
            q.pop();
            
            total_imp += temp->importance;
            visited[get_idx(employees,temp->id)] = 1;
            
            for(int j = 0; j < temp->subordinates.size(); j++)
            {
                int idx = get_idx(employees, temp->subordinates[j]);
                
                if(visited[idx] == 0)
                {
                    q.push(employees[idx]);
                }
            }
            
        }
        
        return total_imp;
    }
};